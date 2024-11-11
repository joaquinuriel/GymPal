package ar.edu.uade.gympal.model.objetivo;

import ar.edu.uade.gympal.model.Socio;
import jakarta.persistence.Entity;

@Entity
public class TonificarCuerpo extends Objetivo {

    private float masaMuscularObjetivo;
    private float porcentajeGrasaObjetivo;

    public TonificarCuerpo(Socio socio, float masaMuscularObjetivo, float porcentajeGrasaObjetivo) {
        super(socio);
        this.masaMuscularObjetivo = masaMuscularObjetivo;
        this.porcentajeGrasaObjetivo = porcentajeGrasaObjetivo;
    }

    public TonificarCuerpo() {

    }

    @Override
    public boolean estaCumplido() {
        return socio.getMasaMuscular() >= masaMuscularObjetivo && socio.getPorcentajeGrasa() <= porcentajeGrasaObjetivo;
    }

    // Metodo para calcular el progreso en función de masa muscular y porcentaje de
    // grasa
    @Override
    public double calcularProgreso() {
        float progresoMasaMuscular = Math.min(100, (socio.getMasaMuscular() / masaMuscularObjetivo) * 100); // Calcula

        float progresoPorcentajeGrasa = Math.min(100,
                ((porcentajeGrasaObjetivo - socio.getPorcentajeGrasa()) / porcentajeGrasaObjetivo) * 100); //// Calcula


        // Promedio de ambos factores para determinar el progreso total
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
