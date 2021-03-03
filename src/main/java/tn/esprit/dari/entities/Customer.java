package tn.esprit.dari.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.dari.entities.Utilisateur;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;


@Entity
@Data
public class Customer extends Utilisateur implements Serializable {

    @OneToMany(mappedBy = "customer")
    private List<Subscribe> subscribes ;


    @OneToMany(mappedBy = "owner")
    private List<Appointment> ownerAppointments;
    @OneToMany(mappedBy = "customer")
    private  List<Appointment> customerAppointments;

    @OneToMany(mappedBy = "customer")
    private List<Property> properties ;
    @OneToMany(mappedBy = "pk.property")
    private List<Favorites> favorites;

}
