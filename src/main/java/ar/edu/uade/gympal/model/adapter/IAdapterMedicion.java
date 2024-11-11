package ar.edu.uade.gympal.model.adapter;

import ar.edu.uade.gympal.model.Socio;

public interface IAdapterMedicion {
    public float getPorcentajeGrasa(Socio socio);

    public float getMasaMuscular(Socio socio);

    public float getPorcentajeGrasaObjetivo(Socio socio);

    public float getMasaMuscularObjetivo(Socio socio);
}
