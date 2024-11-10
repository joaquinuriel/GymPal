package ar.edu.uade.gympal.model.objetivo;

import ar.edu.uade.gympal.model.Socio;
import ar.edu.uade.gympal.model.rutina.Rutina;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BAJAR_PESO")
public class BajarDePeso extends Objetivo {

    private double pesoInicial;
    private double pesoObjetivo;

    public BajarDePeso(Socio socio, Rutina rutina, double pesoInicial, double pesoObjetivo) {
        super(socio, rutina);
        this.pesoInicial = pesoInicial;
        this.pesoObjetivo = pesoObjetivo;
    }

    @Override
    public boolean estaCumplido() {
        return pesoObjetivo <= pesoInicial;
    }

    @Override
    public double calcularProgreso() {
        return pesoInicial / pesoObjetivo;
    }

    // Getters y Setters
    public double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public double getPesoObjetivo() {
        return pesoObjetivo;
    }

    public void setPesoObjetivo(double pesoObjetivo) {
        this.pesoObjetivo = pesoObjetivo;
    }
}
