package tn.esprit.dari.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Buy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_buy;
    private int id_client;
    private float price;

    public Buy() {
    }

    public Buy(int id_buy, int id_client, float price) {
        this.id_buy = id_buy;
        this.id_client = id_client;
        this.price = price;
    }

    public int getId_buy() {
        return id_buy;
    }

    public void setId_buy(int id_buy) {
        this.id_buy = id_buy;
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
        return id_buy == buy.id_buy && id_client == buy.id_client && Float.compare(buy.price, price) == 0 ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_buy, id_client, price);
    }

    @Override
    public String toString() {
        return "Buy{" +
                "id_buy=" + id_buy +
                ", id_client=" + id_client +
                ", price=" + price +
                '}';
    }
}
