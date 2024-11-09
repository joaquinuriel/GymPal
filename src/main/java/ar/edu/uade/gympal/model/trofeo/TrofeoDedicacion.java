package ar.edu.uade.gympal.model.trofeo;

import ar.edu.uade.gympal.model.Socio;

public class TrofeoDedicacion extends Trofeo {
    public boolean verificarCriterio(Socio socio) {
        return socio.haCumplidoObjetivo();
    }
}
