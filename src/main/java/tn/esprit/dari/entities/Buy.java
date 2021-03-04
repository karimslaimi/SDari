package tn.esprit.dari.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Buy extends Property implements Serializable {



    private float price;
    @ManyToOne
    @JoinColumn(name = "utilisateurId")
    private Utilisateur user;

    public Buy() {
    }

    public Buy( float price) {

        this.price = price;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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
