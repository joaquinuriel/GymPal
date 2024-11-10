package ar.edu.uade.gympal.model.objetivo;

import java.util.Date;

import ar.edu.uade.gympal.model.Medicion;
import ar.edu.uade.gympal.model.Socio;
import ar.edu.uade.gympal.model.rutina.Rutina;
import jakarta.persistence.Entity;

@Entity
public class MantenerFigura extends Objetivo {

    private float pesoInicial;
    private float margenPeso;

    public MantenerFigura(Socio socio, Rutina rutina, float pesoInicial, float margenPeso) {
        super(socio, rutina);
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
        // float pesoActual = getSocio().getPeso();
        // if (pesoActual >= (pesoInicial - margenPeso) && pesoActual <= (pesoInicial +
        // margenPeso)) {
        // setProgreso(100.0); // Si el peso está dentro del margen, progreso es 100%
        // } else {
        // float diferenciaPeso = Math.abs(pesoInicial - pesoActual);
        // float margenTotal = 2 * margenPeso;
        // setProgreso(Math.max(0, 100 - ((diferenciaPeso / margenTotal) * 100)));
        // // Calcula el progreso en función de la cercanía al margen
        // }
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
