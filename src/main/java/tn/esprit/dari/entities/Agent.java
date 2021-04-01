package tn.esprit.dari.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@DiscriminatorValue("B")// B stands for broker
public class Agent extends Utilisateur implements Serializable {

@OneToMany(mappedBy = "agent")
@JsonIgnore
    private List<Appointment> appointments;
}
