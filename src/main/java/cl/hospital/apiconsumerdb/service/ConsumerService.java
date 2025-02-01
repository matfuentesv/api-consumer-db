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
import java.time.LocalDateTime;
import java.util.concurrent.TimeoutException;

@Component
public class ConsumerService {


    @Autowired
    private AlertRepository alertRepository;



    @RabbitListener(queues = "alertQueue")
    public void receiveMessage(SignosVitalesMq vitales) {
        System.out.println(" [x] Received payload: " + vitales);

        // Guardar en la base de datos
        SignosVitales signosVitales = setBody(vitales);
        alertRepository.save(signosVitales);

        System.out.println("Objeto guardado: " + signosVitales);
    }

    private SignosVitales setBody(SignosVitalesMq body){
        return  new SignosVitales()
                .setPaciente(new Paciente(body.getPacienteId()))
                .setFecha(LocalDateTime.now().toString())
                .setFrecuenciaCardiaca(body.getFrecuenciaCardiaca())
                .setNivelOxígeno(body.getNivelOxigeno())
                .setPresionArterial(body.getPresionArterial());
    }
}
