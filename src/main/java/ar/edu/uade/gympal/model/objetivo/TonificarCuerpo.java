package ar.edu.uade.gympal.model.objetivo;

import java.util.Date;

import ar.edu.uade.gympal.model.Socio;
import ar.edu.uade.gympal.model.rutina.Rutina;
import jakarta.persistence.Entity;

@Entity
public class TonificarCuerpo extends Objetivo {

    private float masaMuscularObjetivo;
    private float porcentajeGrasaObjetivo;

    public TonificarCuerpo(Date fechaInicio, Socio socio, Rutina rutina, float masaMuscularObjetivo, float porcentajeGrasaObjetivo) {
        super(fechaInicio, socio, rutina);
        this.masaMuscularObjetivo = masaMuscularObjetivo;
        this.porcentajeGrasaObjetivo = porcentajeGrasaObjetivo;
    }

    @Override
    public boolean estaCumplido() {
        return socio.getMasaMuscular() >= masaMuscularObjetivo && socio.getPorcentajeGrasa() <= porcentajeGrasaObjetivo;
    }

    // Metodo para calcular el progreso en función de masa muscular y porcentaje de grasa
    @Override
    public double calcularProgreso() {
        float progresoMasaMuscular = Math.min(100, (socio.getMasaMuscular() / masaMuscularObjetivo) * 100); //Calcula el progreso de masa muscular en porcentaje, donde 100% significa que el socio ha alcanzado o superado la masa muscular objetivo.
        float progresoPorcentajeGrasa = Math.min(100, ((porcentajeGrasaObjetivo - socio.getPorcentajeGrasa()) / porcentajeGrasaObjetivo) * 100); ////Calcula el progreso de masa muscular en porcentaje, donde 100% significa que el socio ha alcanzado o superado la masa muscular objetivo.

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

