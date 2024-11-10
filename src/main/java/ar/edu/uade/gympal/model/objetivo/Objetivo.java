package ar.edu.uade.gympal.model.objetivo;

import java.util.Date;

import ar.edu.uade.gympal.model.Socio;
import ar.edu.uade.gympal.model.rutina.Rutina;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_objetivo")
public abstract class Objetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaInicio;
    private int nivelAerobicoMin;
    private int nivelAerobicoMax;
    private int nivelEjercitacionMuscularMin;
    private int nivelEjercitacionMuscularMax;

    @OneToOne(cascade = CascadeType.ALL)
    private Rutina rutina;

    // private TrofeoDedicacion trofeo;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    protected Socio socio;

    // quien crea el objetivo?
    public Objetivo(Socio socio) {
        this.fechaInicio = new Date();
        this.socio = socio;
    }

    public abstract boolean estaCumplido();

    // ? Calcular progreso del objetivo o de la rutina ??

    // Metodo abstracto para que cada subclase defina cómo calcular el progreso
    public abstract double calcularProgreso();

    // Getters y setters
    public Long getId() {
        return id;
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

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNivelAerobicoMin() {
        return nivelAerobicoMin;
    }

    public void setNivelAerobicoMin(int nivelAerobicoMin) {
        this.nivelAerobicoMin = nivelAerobicoMin;
    }

    public int getNivelAerobicoMax() {
        return nivelAerobicoMax;
    }

    public void setNivelAerobicoMax(int nivelAerobicoMax) {
        this.nivelAerobicoMax = nivelAerobicoMax;
    }

    public int getNivelEjercitacionMuscularMin() {
        return nivelEjercitacionMuscularMin;
    }

    public void setNivelEjercitacionMuscularMin(int nivelEjercitacionMuscularMin) {
        this.nivelEjercitacionMuscularMin = nivelEjercitacionMuscularMin;
    }

    public int getNivelEjercitacionMuscularMax() {
        return nivelEjercitacionMuscularMax;
    }

    public void setNivelEjercitacionMuscularMax(int nivelEjercitacionMuscularMax) {
        this.nivelEjercitacionMuscularMax = nivelEjercitacionMuscularMax;
    }
}
