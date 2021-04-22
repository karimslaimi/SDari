package tn.esprit.dari.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Buy extends Property implements Serializable {

    private float price;

    @ManyToOne
    @JoinColumn
    private Utilisateur user;

    public Buy() {
    }

    public Buy(String adress,String state, String city, String zipCode, int nbrooms, float surface, float superficie, String image, String video, float loyer, float prix,  float price) {
        super.setAdress(adress);
        super.setState(state);
        super.setCity(city);
        super.setZipCode(zipCode);
        super.setNbrooms(nbrooms);
        super.setSurface(surface);
        super.setSuperficie(superficie);
        super.setImage(image);
        super.setVideo(video);
        super.setLoyer(loyer);
        super.setPrix(prix);
        this.price=price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buy buy = (Buy) o;
        return  Float.compare(buy.price, price) == 0 ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(  price);
    }

    @Override
    public String toString() {
        return "Buy{" +
                ", price=" + price +
                '}';
    }
}
