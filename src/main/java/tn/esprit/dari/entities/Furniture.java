package tn.esprit.dari.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
public class Furniture  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_fur;
   private int nb;
   private int price;
   private String dimentions;
   private String description;
   private String picture;
    @ManyToOne
    @JoinColumn(name = "id")
    private Customer cust;
    public Furniture() {
    }

    public Furniture(int id_fur, int nb, int price, String dimentions, String description, String picture) {
        this.id_fur = id_fur;
        this.nb = nb;
        this.price = price;
        this.dimentions = dimentions;
        this.description = description;
        this.picture = picture;
    }

    public int getId_fur() {
        return id_fur;
    }

    public void setId_fur(int id_fur) {
        this.id_fur = id_fur;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDimentions() {
        return dimentions;
    }

    public void setDimentions(String dimentions) {
        this.dimentions = dimentions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "id_fur=" + id_fur +
                ", nb=" + nb +
                ", price=" + price +
                ", dimentions='" + dimentions + '\'' +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture) o;
        return id_fur == furniture.id_fur && nb == furniture.nb && price == furniture.price && dimentions.equals(furniture.dimentions) && description.equals(furniture.description) && picture.equals(furniture.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_fur, nb, price, dimentions, description, picture);
    }
}
