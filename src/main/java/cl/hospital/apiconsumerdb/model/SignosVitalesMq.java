package cl.hospital.apiconsumerdb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SignosVitalesMq implements Serializable {

    private Long pacienteId;
    private double frecuenciaCardiaca;
    private double presionArterial;
    private double nivelOxígeno;


    public Long getPacienteId() {
        return pacienteId;
    }

    public double getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public double getPresionArterial() {
        return presionArterial;
    }

    public double getNivelOxígeno() {
        return nivelOxígeno;
    }


    @Override
    public String toString() {
        return "SignosVitalesMq{" +
                "pacienteId=" + pacienteId +
                ", frecuenciaCardiaca=" + frecuenciaCardiaca +
                ", presionArterial=" + presionArterial +
                ", nivelOxígeno=" + nivelOxígeno +
                '}';
    }
}
