package tn.esprit.dari.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Detail_Panier implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idDetPanier;

    private Date dateAjout;


    @ManyToOne
    @JoinColumn(name="ID_PANIER")
    private Panier panier;

    @ManyToOne
    private Furniture furs;

    @Transient
    private int idf;
    @Transient
    private int idp;
    public Detail_Panier() {
    }

    public Detail_Panier(Integer idDetPanier, Date dateAjout,Panier panier, Furniture furs) {
        this.idDetPanier = idDetPanier;
        this.dateAjout = dateAjout;
        this.panier = panier;
        this.furs = furs;
    }

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public Integer getIdDetPanier() {
        return idDetPanier;
    }

    public void setIdDetPanier(Integer idDetPanier) {
        this.idDetPanier = idDetPanier;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public Furniture getFurs() {
        return furs;
    }

    public void setFurs(Furniture furs) {
        this.furs = furs;
    }

}
