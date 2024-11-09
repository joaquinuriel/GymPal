package ar.edu.uade.gympal.model.rutina;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private GrupoMuscular grupoMuscular;
    private int series;
    private int repeticiones;
    private int peso;
    private int nivelAerobico;
    private int nivelExigenciaMuscular;
    private boolean realizado = false;

    public void finalizarEjercicio() {
        this.realizado = true;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public GrupoMuscular getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getNivelAerobico() {
        return nivelAerobico;
    }

    public void setNivelAerobico(int nivelAerobico) {
        this.nivelAerobico = nivelAerobico;
    }

    public int getNivelExigenciaMuscular() {
        return nivelExigenciaMuscular;
    }

    public void setNivelExigenciaMuscular(int nivelExigenciaMuscular) {
        this.nivelExigenciaMuscular = nivelExigenciaMuscular;
    }

    public boolean isRealizado() {
        return realizado;
    }
}
