package tn.esprit.dari.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_o;
    private int nb_o;
    private float total_price;

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
}
