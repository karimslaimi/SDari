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

public class Customer extends Utilisateur implements Serializable {



    @OneToMany(mappedBy = "Customer")
    private List<Subscribe> subscribes ;

}
