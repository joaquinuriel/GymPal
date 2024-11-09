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
    public final int peso;
    public final int nivelAerobico;
    public final int nivelExigenciaMuscular;
    public final GrupoMuscular grupoMuscular;

    public EjercicioBase(int peso, int nivelAerobico, int nivelExigenciaMuscular, GrupoMuscular grupoMuscular) {
        this.peso = peso;
        this.nivelAerobico = nivelAerobico;
        this.nivelExigenciaMuscular = nivelExigenciaMuscular;
        this.grupoMuscular = grupoMuscular;
    }
}
