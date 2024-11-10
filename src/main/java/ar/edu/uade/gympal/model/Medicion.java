package ar.edu.uade.gympal.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Medicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float peso;
    private float masaMuscular;
    private float porcentajeGrasa;
    private Date fechaMedicion;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

    public Medicion(float peso, float masaMuscular, float porcentajeGrasa, Socio socio) {
        this.peso = peso;
        this.masaMuscular = masaMuscular;
        this.porcentajeGrasa = porcentajeGrasa;
        this.fechaMedicion = new Date();
        this.socio = socio;
    }

    public Medicion() {

    }

    public Date getFechaMedicion() {
        return fechaMedicion;
    }

    public Long getId() {
        return id;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getMasaMuscular() {
        return masaMuscular;
    }

    public void setMasaMuscular(float masaMuscular) {
        this.masaMuscular = masaMuscular;
    }

    public float getPorcentajeGrasa() {
        return porcentajeGrasa;
    }

    public void setPorcentajeGrasa(float porcentajeGrasa) {
        this.porcentajeGrasa = porcentajeGrasa;
    }

    public void setFechaMedicion(Date fechaMedicion) {
        this.fechaMedicion = fechaMedicion;
    }

    public Socio getSocio() {
        return socio;
    }
}
