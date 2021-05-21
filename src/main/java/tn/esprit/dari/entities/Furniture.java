package tn.esprit.dari.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

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


   private String title;

   private String type;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idcust")
    private Customer cust;

    @JsonIgnore
    @OneToMany(mappedBy = "furs", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Detail_Panier> dpan;

    @OneToOne(mappedBy = "fur",cascade = CascadeType.REMOVE, orphanRemoval = true)
    private LigneCommande lc;


    public Furniture() {
    }

    public Furniture(String title,int id_fur, int price, String description, String picture, boolean selected, String furt, Customer cust, List<Detail_Panier> dpan, LigneCommande lc) {
        this.id_fur = id_fur;
        this.price = price;
        this.description = description;
        this.picture = picture;
        this.type = furt;
        this.cust = cust;
        this.dpan = dpan;
        this.lc = lc;
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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


}
