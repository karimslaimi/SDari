package tn.esprit.dari.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.dari.entities.Utilisateur;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@DiscriminatorValue("C")
@Data
public class Customer extends Utilisateur implements Serializable {



    @OneToMany(mappedBy = "customer")
    private List<Subscribe> subscribes ;

    @ManyToMany()
    @JoinTable(name = "Favorites", joinColumns = @JoinColumn(name = "utilisateurId")
            , inverseJoinColumns = @JoinColumn(name = "id_prop"))
    List<Property> favorites;



    @OneToMany(mappedBy = "owner")
    List<Appointment> ownerAppointments;
    @OneToMany(mappedBy = "customer")
    List<Appointment> customerAppointments;


}
