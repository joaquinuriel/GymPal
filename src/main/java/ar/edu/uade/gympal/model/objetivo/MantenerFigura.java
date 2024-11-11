package ar.edu.uade.gympal.model.objetivo;

import ar.edu.uade.gympal.model.Medicion;
import ar.edu.uade.gympal.model.Socio;
import jakarta.persistence.Entity;

@Entity
public class MantenerFigura extends Objetivo {

    private float pesoInicial;
    private float margenPeso;

    public MantenerFigura(Socio socio, float pesoInicial, float margenPeso) {
        super(socio);
        this.pesoInicial = pesoInicial;
        this.margenPeso = margenPeso;
    }

    @Override
    public boolean estaCumplido() {
        Medicion actual = socio.ultimaMedicion();
        float pesoActual = actual.getPeso();
        float pesoMaximo = pesoInicial * (100 + margenPeso) / 100;
        float pesoMinimo = pesoInicial * (100 - margenPeso) / 100;
        return pesoActual <= pesoMaximo && pesoActual >= pesoMinimo;
    }

    // Metodo para calcular el progreso basado en el peso actual
    @Override
    public double calcularProgreso() {

        return 0;
    }

    // Getters y setters
    public float getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(float pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public float getMargenPeso() {
        return margenPeso;
    }

    public void setMargenPeso(float margenPeso) {
        this.margenPeso = margenPeso;
    }
}