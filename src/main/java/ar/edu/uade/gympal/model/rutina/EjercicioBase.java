package ar.edu.uade.gympal.model.rutina;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EjercicioBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public final String nombre;
    public final int peso;
    public final int series;
    public final int repeticiones;
    public final int nivelAerobico;
    public final int nivelExigenciaMuscular;
    public final GrupoMuscular grupoMuscular;

    public EjercicioBase(
            String nombre,
            int peso,
            int series,
            int repeticiones,
            int nivelAerobico,
            int nivelExigenciaMuscular,
            GrupoMuscular grupoMuscular) {
        this.nombre = nombre;
        this.peso = peso;
        this.series = series;
        this.repeticiones = repeticiones;
        this.nivelAerobico = nivelAerobico;
        this.nivelExigenciaMuscular = nivelExigenciaMuscular;
        this.grupoMuscular = grupoMuscular;
    }
}
