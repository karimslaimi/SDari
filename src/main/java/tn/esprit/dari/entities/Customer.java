package tn.esprit.dari.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("C")
public class Customer extends Utilisateur implements Serializable {

    String username;

    @JsonIgnore
    @OneToMany(mappedBy = "customers")
    private List<Subscribe> subscribes ;

    @ManyToMany
    @JoinTable(name = "Favorites", joinColumns = @JoinColumn(name = "utilisateurId")
            , inverseJoinColumns = @JoinColumn(name = "id_prop"))
    List<Property> favorites;
    @OneToMany(mappedBy = "owner")
    List<Appointment> ownerAppointments;

    @OneToMany(mappedBy = "customer")
    List<Appointment> customerAppointments;

    @OneToMany(mappedBy="cust" )
    List<Furniture> furs;

    @OneToMany(mappedBy="customer" )
    List<Property> props;

    @OneToMany(mappedBy="custo" )
    List<Orders> ords;

    @OneToOne
    private Panier panier;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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
