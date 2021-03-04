package tn.esprit.dari.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("A")
public class Admin extends Utilisateur implements Serializable {
    private AdminType adminType;
}
