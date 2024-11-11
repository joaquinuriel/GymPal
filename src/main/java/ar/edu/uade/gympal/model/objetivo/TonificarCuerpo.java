package ar.edu.uade.gympal.model.objetivo;

import ar.edu.uade.gympal.model.Socio;
import jakarta.persistence.Entity;

@Entity
public class TonificarCuerpo extends Objetivo {

    private float masaMuscularObjetivo;
    private float porcentajeGrasaObjetivo;

    // Constructor vacío
    public TonificarCuerpo() {
        super(); // Llama al constructor de la clase padre
    }

    // Constructor con parámetros
    public TonificarCuerpo(Socio socio, float masaMuscularObjetivo, float porcentajeGrasaObjetivo) {
        super(socio);
        this.masaMuscularObjetivo = masaMuscularObjetivo;
        this.porcentajeGrasaObjetivo = porcentajeGrasaObjetivo;
    }

    @Override
    public boolean estaCumplido() {
        return socio.getMasaMuscular() >= masaMuscularObjetivo && socio.getPorcentajeGrasa() <= porcentajeGrasaObjetivo;
    }

    @Override
    public double calcularProgreso() {
        float progresoMasaMuscular = (float) Math.min(100, (socio.getMasaMuscular() / masaMuscularObjetivo) * 100);

        float progresoPorcentajeGrasa = (float) Math.min(100,
                ((porcentajeGrasaObjetivo - socio.getPorcentajeGrasa()) / porcentajeGrasaObjetivo) * 100);

        return (progresoMasaMuscular + progresoPorcentajeGrasa) / 2;
    }

    // Getters y setters
    public float getMasaMuscularObjetivo() {
        return masaMuscularObjetivo;
    }

    public void setMasaMuscularObjetivo(float masaMuscularObjetivo) {
        this.masaMuscularObjetivo = masaMuscularObjetivo;
    }

    public float getPorcentajeGrasaObjetivo() {
        return porcentajeGrasaObjetivo;
    }

    public void setPorcentajeGrasaObjetivo(float porcentajeGrasaObjetivo) {
        this.porcentajeGrasaObjetivo = porcentajeGrasaObjetivo;
    }
}
