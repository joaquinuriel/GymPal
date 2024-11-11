package ar.edu.uade.gympal.model.adapter;

import ar.edu.uade.gympal.model.Socio;

public interface IAdapterMedicion {
    float getPorcentajeGrasa(Socio socio);

    float getMasaMuscular(Socio socio);

    float getPorcentajeGrasaObjetivo(Socio socio);

    float getMasaMuscularObjetivo(Socio socio);
}
