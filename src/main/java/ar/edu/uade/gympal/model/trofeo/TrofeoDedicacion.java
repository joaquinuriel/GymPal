package ar.edu.uade.gympal.model.trofeo;


import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("DEDICACION")
public abstract class TrofeoDedicacion extends Trofeo {

}
