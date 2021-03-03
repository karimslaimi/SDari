package tn.esprit.dari.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.dari.entities.Utilisateur;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity


public class Agent extends Utilisateur implements Serializable {

@OneToMany(mappedBy = "agent")
    private List<Appointment> appointments;
}
