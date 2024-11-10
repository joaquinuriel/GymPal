package ar.edu.uade.gympal.model.objetivo;

import ar.edu.uade.gympal.model.Socio;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BAJAR_PESO")
public class BajarDePeso extends Objetivo {

    private double pesoInicial;
    private double pesoObjetivo;

    public BajarDePeso(Socio socio, double pesoInicial, double pesoObjetivo) {
        super(socio);
        this.pesoInicial = pesoInicial;
        this.pesoObjetivo = pesoObjetivo;
    }

    @Override
    public boolean estaCumplido() {
        return pesoInicial <= pesoObjetivo;
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
