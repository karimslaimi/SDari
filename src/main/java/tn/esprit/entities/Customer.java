package tn.esprit.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;


@Entity

public class Customer extends Utilisateur implements Serializable {

}
