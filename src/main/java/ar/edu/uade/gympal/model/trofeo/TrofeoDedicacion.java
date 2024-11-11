package ar.edu.uade.gympal.model.trofeo;

import ar.edu.uade.gympal.model.Socio;

public class TrofeoDedicacion extends Trofeo {
    public TrofeoDedicacion() {
        super();
    }

    @Override
    public boolean verificarCriterio(Socio socio) {
        if (!socio.getObjetivo().estaCumplido())
            return false;
        TrofeoDedicacion trofeo = new TrofeoDedicacion();
        socio.añadirTrofeo(trofeo);
        return true;
    }
}