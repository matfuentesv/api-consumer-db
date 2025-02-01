package cl.hospital.apiconsumerdb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;




@Entity
@Table(name = "SignosVitales")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignosVitales  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "frecuenciaCardiaca")
    private double frecuenciaCardiaca;

    @Column(name = "presionArterial")
    private double presionArterial;

    @Column(name = "nivelOxígeno")
    private double nivelOxígeno;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id", nullable = false)
    private Paciente paciente;


    public Long getId() {
        return id;
    }

    public SignosVitales setId(Long id) {
        this.id = id;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public SignosVitales setPaciente(Paciente paciente) {
        this.paciente = paciente;
        return this;
    }

    public String getFecha() {
        return fecha;
    }

    public SignosVitales setFecha(String fecha) {
        this.fecha = fecha;
        return this;
    }
}
