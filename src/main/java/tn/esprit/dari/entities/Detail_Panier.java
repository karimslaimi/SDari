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

    private double prixFuniture;

    private int quantite;

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

    public Detail_Panier(Integer idDetPanier, Date dateAjout, double prixFuniture, int quantite, Panier panier, Furniture furs) {
        this.idDetPanier = idDetPanier;
        this.dateAjout = dateAjout;
        this.prixFuniture = prixFuniture;
        this.quantite = quantite;
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

    public double getPrixFuniture() {
        return prixFuniture;
    }

    public void setPrixFuniture(double prixFuniture) {
        this.prixFuniture = prixFuniture;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
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

    @Override
    public String toString() {
        return "Detail_Panier{" +
                "idDetPanier=" + idDetPanier +
                ", dateAjout=" + dateAjout +
                ", prixFuniture=" + prixFuniture +
                ", quantite=" + quantite +
                ", panier=" + panier +
                ", furs=" + furs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detail_Panier that = (Detail_Panier) o;
        return Double.compare(that.prixFuniture, prixFuniture) == 0 && quantite == that.quantite && idDetPanier.equals(that.idDetPanier) && dateAjout.equals(that.dateAjout) && panier.equals(that.panier) && furs.equals(that.furs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDetPanier, dateAjout, prixFuniture, quantite, panier, furs);
    }
}
