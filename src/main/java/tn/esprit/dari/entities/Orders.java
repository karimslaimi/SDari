package tn.esprit.dari.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_o;
    private int nb_o;
    private float total_price;

    @ManyToOne
    @JoinColumn(name = "id")
    private Customer custo;



    public Orders() {
    }


    public Orders(int id_o, int nb_o, float total_price) {
        this.id_o = id_o;
        this.nb_o = nb_o;
        this.total_price = total_price;
    }

    public int getId_o() {
        return id_o;
    }

    public void setId_o(int id_o) {
        this.id_o = id_o;
    }

    public int getNb_o() {
        return nb_o;
    }

    public void setNb_o(int nb_o) {
        this.nb_o = nb_o;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }


    @Override
    public String toString() {
        return "Orders{" +
                "id_o=" + id_o +
                ", nb_o=" + nb_o +
                ", total_price=" + total_price +
                ", custo=" + custo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id_o == orders.id_o && nb_o == orders.nb_o && Float.compare(orders.total_price, total_price) == 0 && custo.equals(orders.custo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_o, nb_o, total_price, custo);
    }
}
