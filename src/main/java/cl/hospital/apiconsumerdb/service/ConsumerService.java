package cl.hospital.apiconsumerdb.service;

import cl.hospital.apiconsumerdb.model.Paciente;
import cl.hospital.apiconsumerdb.model.SignosVitales;
import cl.hospital.apiconsumerdb.model.SignosVitalesMq;
import cl.hospital.apiconsumerdb.repository.AlertRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class ConsumerService {


    @Autowired
    private AlertRepository alertRepository;



    @RabbitListener(queues = "alertQueue")
    public void receiveMessage(SignosVitales signosVitales) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        ObjectMapper mapper = new ObjectMapper();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // Declarar la cola de la cual consumir con la propiedad durable
        boolean durable = true;

        // Declarar la cola de la cual consumir
        channel.queueDeclare("alertQueue", durable, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        // Definir la función de callback para el consumidor
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");

            SignosVitalesMq vitales = mapper.readValue(message, SignosVitalesMq.class);
            System.out.println("Objeto" + vitales);
            alertRepository.save(setBody(vitales));

        };

        // Consumir mensajes de la cola
        channel.basicConsume("alertQueue", true, deliverCallback, consumerTag -> { });
    }

    private SignosVitales setBody(SignosVitalesMq body){
        return  new SignosVitales()
                .setPaciente(new Paciente(body.getPacienteId()))
                .setFrecuenciaCardiaca(body.getFrecuenciaCardiaca())
                .setNivelOxígeno(body.getNivelOxigeno())
                .setPresionArterial(body.getPresionArterial());
    }
}
