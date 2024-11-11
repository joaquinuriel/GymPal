package ar.edu.uade.gympal.model.trofeo;

import ar.edu.uade.gympal.model.Socio;

public class TrofeoCreido extends Trofeo {
    public TrofeoCreido() {
        super();
    }

    public boolean verificarCriterio(Socio socio) {
        boolean cumplido = socio.getCantidadPesajesEnUltimoMes() > 3;
        if (cumplido)
            socio.añadirTrofeo(new TrofeoCreido());
        return cumplido;
    }
}