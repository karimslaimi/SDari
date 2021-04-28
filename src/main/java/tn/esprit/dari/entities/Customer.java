package tn.esprit.dari.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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



    @JsonIgnore
    @OneToMany(mappedBy = "customers")
    private List<Subscribe> subscribes ;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "Favorites", joinColumns = @JoinColumn(name = "Customer_id")
            , inverseJoinColumns = @JoinColumn(name = "prop_id"))
    List<Property> favorites;


    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    List<Appointment> ownerAppointments;


    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    List<Appointment> customerAppointments;

    @JsonIgnore
    @OneToMany(mappedBy="cust" )
    List<Furniture> furs;

    @JsonIgnore
    @OneToMany(mappedBy="customer" )
    List<Property> props;

    @JsonIgnore
    @OneToMany(mappedBy="custo" )
    List<Orders> ords;

    @OneToOne
    private Panier panier;




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

    public List<Furniture> getFurs() {
        return furs;
    }

    public void setFurs(List<Furniture> furs) {
        this.furs = furs;
    }

    public List<Property> getProps() {
        return props;
    }

    public void setProps(List<Property> props) {
        this.props = props;
    }

    public List<Orders> getOrds() {
        return ords;
    }

    public void setOrds(List<Orders> ords) {
        this.ords = ords;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }


}
