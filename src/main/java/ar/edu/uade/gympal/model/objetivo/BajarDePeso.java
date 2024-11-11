package ar.edu.uade.gympal.model.objetivo;

import ar.edu.uade.gympal.model.Socio;
import ar.edu.uade.gympal.model.trofeo.TrofeoDedicacion;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("BAJAR_PESO")
public class BajarDePeso extends Objetivo {

    private double pesoObjetivo;
    @ManyToOne
    @JoinColumn(name = "trofeo_dedicacion_id")
    private TrofeoDedicacion trofeoDedicacion;

    public TrofeoDedicacion getTrofeoDedicacion() {
        return trofeoDedicacion;
    }

    public void setTrofeoDedicacion(TrofeoDedicacion trofeoDedicacion) {
        this.trofeoDedicacion = trofeoDedicacion;
    }

    private float pesoActual() {
        return socio.ultimaMedicion().getPeso();
    }

    public BajarDePeso(Socio socio, double pesoObjetivo) {
        super(socio);
        this.pesoObjetivo = pesoObjetivo;
    }

    @Override
    public boolean estaCumplido() {
        boolean cumplido = pesoActual() <= pesoObjetivo;
        trofeoDedicacion.verificarCriterio(socio);
        return pesoActual() <= pesoObjetivo;
    }

    @Override
    public double calcularProgreso() {
        return pesoActual() / pesoObjetivo;
    }

    public double getPesoObjetivo() {
        return pesoObjetivo;
    }

    public void setPesoObjetivo(double pesoObjetivo) {
        this.pesoObjetivo = pesoObjetivo;
    }
}