package tn.esprit.dari.entities;

import ch.qos.logback.core.net.server.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Property implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prop;
    private String title;
    private String type;
    private int nbrooms;
    private float surface;
    private float superficie;
    private String image;
    private String video;
    private float loyer;
    private float prix;
    private Status status;
    private String adress;
    private String state;
    private String city;
    private String zipCode;
    private String description;

    @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "id")
   private Customer customer;

 /* @ManyToMany(mappedBy = "properties")
  List<Customer> customers;*/



    public Property() {
    }

    public Property(String description,String title,String adress,String state, String city, String zipCode,int id_prop, String type, int nbrooms, float surface, float superficie, String image, String video, float loyer, float prix, Status status, Customer customer) {
        this.adress=adress;
        this.state=state;
        this.city=city;
        this.zipCode=zipCode;
        this.id_prop = id_prop;
        this.type = type;
        this.nbrooms = nbrooms;
        this.surface = surface;
        this.superficie = superficie;
        this.image = image;
        this.video = video;
        this.loyer = loyer;
        this.prix = prix;
        this.status = status;
        this.customer = customer;
        this.title=title;
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdress() { return adress;}

    public void setAdress(String adress) { this.adress = adress;}

    public String getState() {return state;}

    public void setState(String state) {this.state = state;}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId_prop() {
        return id_prop;
    }

    public void setId_prop(int id_prop) {
        this.id_prop = id_prop;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getNbrooms() {
        return nbrooms;
    }

    public void setNbrooms(int nbrooms) {
        this.nbrooms = nbrooms;
    }

    public float getSurface() {
        return surface;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    public float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public float getLoyer() {
        return loyer;
    }

    public void setLoyer(float loyer) {
        this.loyer = loyer;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id_prop=" + id_prop +
                ", type=" + type +
                ", nbrooms=" + nbrooms +
                ", surface=" + surface +
                ", superficie=" + superficie +
                ", image='" + image + '\'' +
                ", video='" + video + '\'' +
                ", loyer=" + loyer +
                ", prix=" + prix +
                ", status=" + status +
                ", adress='" + adress + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                ", customer=" + customer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return id_prop == property.id_prop && nbrooms == property.nbrooms && Float.compare(property.surface, surface) == 0 && Float.compare(property.superficie, superficie) == 0 && Float.compare(property.loyer, loyer) == 0 && Float.compare(property.prix, prix) == 0 && type == property.type && image.equals(property.image) && video.equals(property.video) && status == property.status && customer.equals(property.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_prop, type, nbrooms, surface, superficie, image, video, loyer, customer);
    }
}
