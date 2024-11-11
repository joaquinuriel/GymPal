package ar.edu.uade.gympal.model.trofeo;

import ar.edu.uade.gympal.model.Socio;

public class TrofeoConstancia extends Trofeo {
    public TrofeoConstancia() {
        super();
    }

    public boolean verificarCriterio(Socio socio) {
        return socio.haCumplidoRutinaPerfectamente();
    }

    public void entregarTrofeo(Socio socio) {
        socio.añadirTrofeo(this); // no creo que este bien esto
        // hacer algo
    }
}