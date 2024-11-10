package ar.edu.uade.gympal.dto;

import ar.edu.uade.gympal.model.objetivo.Objetivo;

public class SocioDTO {

    private Long id;
    private String nombre;
    private int edad;
    private float peso;
    private float altura; // Nueva propiedad
    private String objetivo; // Puede ser un String representando el objetivo
    private int rutinasCompletadas;
    private int progresoObjetivo;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public int getRutinasCompletadas() {
        return rutinasCompletadas;
    }

    public void setRutinasCompletadas(int rutinasCompletadas) {
        this.rutinasCompletadas = rutinasCompletadas;
    }

    public int getProgresoObjetivo() {
        return progresoObjetivo;
    }

    public void setProgresoObjetivo(int progresoObjetivo) {
        this.progresoObjetivo = progresoObjetivo;
    }
}
