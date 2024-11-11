package ar.edu.uade.gympal.model.adapter;

import ar.edu.uade.gympal.model.Socio;

public interface IAdapterBalanza {
    public float getPeso(Socio socio);

    public float getPesoObjetivo(Socio socio);
}
