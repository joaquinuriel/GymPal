package ar.edu.uade.gympal.model.trofeo;

import ar.edu.uade.gympal.model.Socio;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CONSTANCIA")
public class TrofeoConstancia extends Trofeo {

    @Override
    public boolean verificarCriterio(Socio socio) {
        return socio.haCumplidoRutinaPerfectamente();
    }

    @Override
    public void entregarTrofeo(Socio socio) {
        socio.añadirTrofeo(this); // Relaciona este trofeo con el socio
    }
}
