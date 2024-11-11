package ar.edu.uade.gympal.model.trofeo;

import ar.edu.uade.gympal.model.Socio;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
public class TrofeoDedicacion extends Trofeo {

    private Long id;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

    public void setSocio(Socio socio) {
        this.socio = socio;
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