package ar.edu.uade.gympal.model.objetivo;

import java.util.Date;

import ar.edu.uade.gympal.model.Socio;
import ar.edu.uade.gympal.model.rutina.Rutina;
import ar.edu.uade.gympal.model.trofeo.TrofeoDedicacion;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_objetivo")
public abstract class Objetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaInicio;
    @ManyToOne
    @JoinColumn(name = "rutina_id")
    private Rutina rutina;
    @OneToOne
    @JoinColumn(name = "trofeo_id")
    private TrofeoDedicacion trofeo;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    protected Socio socio;

    public TrofeoDedicacion getTrofeo() {
        return trofeo;
    }

    public void setTrofeo(TrofeoDedicacion trofeo) {
        this.trofeo = trofeo;
    }

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }

    public Objetivo(Date fechaInicio, Socio socio, Rutina rutina) {
        this.fechaInicio = fechaInicio;
        this.socio = socio;
        this.rutina = rutina;
    }

    public Objetivo() {

    }

    public abstract boolean estaCumplido();

    //? Calcular progreso del objetivo o de la rutina ??

    // Metodo abstracto para que cada subclase defina cómo calcular el progreso
    public abstract double calcularProgreso();

    // Getters y setters
    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}
