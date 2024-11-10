package ar.edu.uade.gympal.model.objetivo;

import ar.edu.uade.gympal.model.Medicion;
import ar.edu.uade.gympal.model.rutina.Rutina;
import ar.edu.uade.gympal.model.Socio;
import jakarta.persistence.Entity;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Entity
public class MantenerFigura extends Objetivo {

    private float pesoInicial;
    private float margenPeso;

    public MantenerFigura(String fechaInicio, Socio socio, Rutina rutina, float pesoInicial, float margenPeso) throws ParseException {
        super(new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio), socio, rutina);
        this.pesoInicial = pesoInicial;
        this.margenPeso = margenPeso;
    }

    public MantenerFigura() {

    }

    @Override
    public boolean estaCumplido() {
        Medicion actual = socio.ultimaMedicion(); // Asegúrate de que este método esté en Socio
        float pesoActual = actual.getPeso(); // Asume que Medicion tiene un atributo peso

        float pesoMaximo = pesoInicial + (pesoInicial * margenPeso / 100);
        float pesoMinimo = pesoInicial - (pesoInicial * margenPeso / 100);

        return pesoActual <= pesoMaximo && pesoActual >= pesoMinimo;
    }

    @Override
    public double calcularProgreso() {
        float pesoActual = socio.getPeso(); // Asegúrate de que Socio tiene este método

        float pesoMaximo = pesoInicial + (pesoInicial * margenPeso / 100);
        float pesoMinimo = pesoInicial - (pesoInicial * margenPeso / 100);

        if (pesoActual >= pesoMinimo && pesoActual <= pesoMaximo) {
            return 100; // Si el peso está dentro del margen, el progreso es 100%
        }

        float diferenciaPeso = Math.abs(pesoInicial - pesoActual);
        float margenTotal = 2 * margenPeso; // Margen total considerando ambas direcciones

        return Math.max(0, 100 - ((diferenciaPeso / margenTotal) * 100)); // Calcula el progreso
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
