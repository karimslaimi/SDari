package tn.esprit.dari.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
@Entity
public class Furniture  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_fur;
   private int price;
   private String description;
   private String picture;
   private boolean selected;



    @Enumerated
   private FurnitureType furt;
    @ManyToOne
    @JoinColumn(name = "idcust")
    private Customer cust;

    @OneToMany(mappedBy = "furs")
    private List<Detail_Panier> dpan;

    @OneToOne(mappedBy = "fur")
    private LigneCommande lc;


    public Furniture() {
    }

    public Furniture(int id_fur, int price, String description, String picture, boolean selected, FurnitureType furt, Customer cust, List<Detail_Panier> dpan, LigneCommande lc) {
        this.id_fur = id_fur;
        this.price = price;
        this.description = description;
        this.picture = picture;
        this.selected = selected;
        this.furt = furt;
        this.cust = cust;
        this.dpan = dpan;
        this.lc = lc;
    }


    public int getId_fur() {
        return id_fur;
    }

    public void setId_fur(int id_fur) {
        this.id_fur = id_fur;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public FurnitureType getFurt() {
        return furt;
    }

    public void setFurt(FurnitureType furt) {
        this.furt = furt;
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public List<Detail_Panier> getDpan() {
        return dpan;
    }

    public void setDpan(List<Detail_Panier> dpan) {
        this.dpan = dpan;
    }

    public LigneCommande getLc() {
        return lc;
    }

    public void setLc(LigneCommande lc) {
        this.lc = lc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture) o;
        return id_fur == furniture.id_fur && price == furniture.price && selected == furniture.selected && Objects.equals(description, furniture.description) && Objects.equals(picture, furniture.picture) && furt == furniture.furt && Objects.equals(cust, furniture.cust) && Objects.equals(dpan, furniture.dpan) && Objects.equals(lc, furniture.lc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_fur, price, description, picture, selected, furt, cust, dpan, lc);
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "id_fur=" + id_fur +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                ", selected=" + selected +
                ", furt=" + furt +
                ", cust=" + cust +
                ", dpan=" + dpan +
                ", lc=" + lc +
                '}';
    }
}
