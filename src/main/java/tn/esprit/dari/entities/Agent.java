package tn.esprit.dari.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.dari.entities.Utilisateur;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@DiscriminatorValue("Ag")
public class Agent extends Utilisateur implements Serializable {

@OneToMany(mappedBy = "agent")
    private List<Appointment> appointments;
}
