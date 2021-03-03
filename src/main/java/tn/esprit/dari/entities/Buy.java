package tn.esprit.dari.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Buy extends Property implements Serializable {


    private int id_client;
    private float price;
    @ManyToOne
    @JoinColumn(name = "utilisateurId")
    private Utilisateur user;

    public Buy() {
    }

    public Buy(int id_client, float price) {
        this.id_client = id_client;
        this.price = price;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }



    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
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
        return  id_client == buy.id_client && Float.compare(buy.price, price) == 0 ;
    }

    @Override
    public int hashCode() {
        return Objects.hash( id_client, price);
    }

    @Override
    public String toString() {
        return "Buy{" +

                ", id_client=" + id_client +
                ", price=" + price +
                '}';
    }
}
