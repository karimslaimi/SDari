package tn.esprit.dari.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("D")
public class DeliveryMan extends Utilisateur implements Serializable {






}
