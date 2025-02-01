package cl.hospital.apiconsumerdb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SignosVitalesMq implements Serializable {

    private Long pacienteId;
    private double frecuenciaCardiaca;
    private double presionArterial;
    private double nivelOxigeno;
    private boolean anomalous;


    public Long getPacienteId() {
        return pacienteId;
    }

    public double getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public double getPresionArterial() {
        return presionArterial;
    }

    public double getNivelOxigeno() {
        return nivelOxigeno;
    }

    public boolean isAnomalous() {
        return anomalous;
    }
}
