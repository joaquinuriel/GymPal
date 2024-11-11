package ar.edu.uade.gympal.model.rutina;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Entrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final Date fecha;

    @ManyToOne
    private Rutina rutina;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entrenamiento")
    private final List<Ejercicio> ejercicios;

    public Entrenamiento(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
        this.fecha = new Date();
    }

    public boolean estaCompleto() {
        for (Ejercicio ejercicio : ejercicios)
            if (!ejercicio.isRealizado())
                return false;
        return true;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }
}