package ar.edu.uade.gympal.model.rutina;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Rutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutina")
    private List<Entrenamiento> entrenamientos;

    private Date fechaInicio;

    // @Embedded
    // private TrofeoConstancia trofeo;

    public Rutina(List<Entrenamiento> entrenamientos) {
        this.entrenamientos = entrenamientos;
        this.fechaInicio = new Date();
    }

    // Método para verificar si la rutina se ha cumplido a la perfección
    public boolean esPerfecta() {
        for (Entrenamiento entrenamiento : entrenamientos)
            if (!entrenamiento.estaCompleto())
                return false;
        // trofeo.entregarTrofeo();
        return true;
    }

    public void reforzarRutina() {
        for (Entrenamiento entrenamiento : entrenamientos) {
            for (Ejercicio ejercicio : entrenamiento.getEjercicios()) {
                ejercicio.setRepeticiones(ejercicio.getRepeticiones() + 1);
                ejercicio.setSeries(ejercicio.getSeries() + 1);
                ejercicio.setPeso(ejercicio.getPeso() + 5);
            }
        }
    }

    public float getProgreso() {
        return 0;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Entrenamiento> getEntrenamientos() {
        return entrenamientos;
    }

    public void setEntrenamientos(List<Entrenamiento> entrenamientos) {
        this.entrenamientos = entrenamientos;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
