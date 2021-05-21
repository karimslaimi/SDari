package tn.esprit.dari.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_o;
    private Date datecommande;

    @Transient
    private Long idc;
    @Transient int idf;

    private float somme;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id")
    private Customer custo;

    @OneToOne
    private Furniture fur;

    @OneToMany(mappedBy = "ord" , orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<LigneCommande> lc;

    public Orders() {
    }

    public Orders(int id_o, Date datecommande,  Customer custo, Furniture fur, List<LigneCommande> lc) {
        this.id_o = id_o;
        this.datecommande = datecommande;
        this.custo = custo;
        this.fur = fur;
        this.lc = lc;
    }

    public float getSomme() {
        return somme;
    }

    public void setSomme(float somme) {
        this.somme = somme;
    }

    public Long getIdc() {
        return idc;
    }

    public void setIdc(Long idc) {
        this.idc = idc;
    }

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public int getId_o() {
        return id_o;
    }

    public void setId_o(int id_o) {
        this.id_o = id_o;
    }

    public Date getDatecommande() {
        return datecommande;
    }

    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
    }



    public Customer getCusto() {
        return custo;
    }

    public void setCusto(Customer custo) {
        this.custo = custo;
    }

    public Furniture getFur() {
        return fur;
    }

    public void setFur(Furniture fur) {
        this.fur = fur;
    }

    public List<LigneCommande> getLc() {
        return lc;
    }

    public void setLc(List<LigneCommande> lc) {
        this.lc = lc;
    }


}
