package tn.esprit.dari.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tn.esprit.dari.entities.Utilisateur;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
@Data
@ToString
@DiscriminatorValue("C")
public class Customer extends Utilisateur implements Serializable {



    @OneToMany(mappedBy = "customers")
    private List<Subscribe> subscribes ;

    @ManyToMany
    @JoinTable(name = "Favorites", joinColumns = @JoinColumn(name = "Customer_id")
            , inverseJoinColumns = @JoinColumn(name = "prop_id"))
    List<Property> favorites;



    @OneToMany(mappedBy = "owner")
    List<Appointment> ownerAppointments;
    @OneToMany(mappedBy = "customer")
    List<Appointment> customerAppointments;

    @OneToMany(mappedBy="cust" )
    List<Furniture> furs;

    @OneToMany(mappedBy="customer" )
    List<Property> props;



    public List<Subscribe> getSubscribes() {
        return subscribes;
    }

    public void setSubscribes(List<Subscribe> subscribes) {
        this.subscribes = subscribes;
    }

    public List<Property> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Property> favorites) {
        this.favorites = favorites;
    }

    public List<Appointment> getOwnerAppointments() {
        return ownerAppointments;
    }

    public void setOwnerAppointments(List<Appointment> ownerAppointments) {
        this.ownerAppointments = ownerAppointments;
    }

    public List<Appointment> getCustomerAppointments() {
        return customerAppointments;
    }

    public void setCustomerAppointments(List<Appointment> customerAppointments) {
        this.customerAppointments = customerAppointments;
    }


}
