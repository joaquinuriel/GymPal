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

    @OneToMany(cascade = CascadeType.ALL)
    private List<Entrenamiento> entrenamientos;

    private Date fechaInicio;

    public Rutina() {
    }

    public Rutina(List<Entrenamiento> entrenamientos) {
        this.entrenamientos = entrenamientos;
        this.fechaInicio = new Date();
    }

    // Método para verificar si la rutina se ha cumplido a la perfección
    public boolean esPerfecta() {
        for (Entrenamiento entrenamiento : entrenamientos)
            if (!entrenamiento.estaCompleto())
                return false;
        return true;
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
