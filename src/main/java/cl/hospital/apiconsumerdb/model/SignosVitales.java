package cl.hospital.apiconsumerdb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;




@Entity
@Table(name = "SignosVitales")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignosVitales  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pacienteId;

    @Column(name = "frecuenciaCardiaca")
    private double frecuenciaCardiaca;

    @Column(name = "presionArterial")
    private double presionArterial;

    @Column(name = "nivelOxígeno")
    private double nivelOxígeno;



    public Long getPacienteId() {
        return pacienteId;
    }

    public SignosVitales setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
        return this;
    }

    public double getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public SignosVitales setFrecuenciaCardiaca(double frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        return this;
    }

    public double getPresionArterial() {
        return presionArterial;
    }

    public SignosVitales setPresionArterial(double presionArterial) {
        this.presionArterial = presionArterial;
        return this;
    }

    public double getNivelOxígeno() {
        return nivelOxígeno;
    }

    public SignosVitales setNivelOxígeno(double nivelOxígeno) {
        this.nivelOxígeno = nivelOxígeno;
        return this;
    }

}
