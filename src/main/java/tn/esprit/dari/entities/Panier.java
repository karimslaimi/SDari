package tn.esprit.dari.entities;

import javax.persistence.*;
import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Panier implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idPanier;
    private Date dateMajPanier;
    private double sommeTotale;
    private String etatPanier;


    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy="panier")
     private List<Detail_Panier> detail_paniers;


    @OneToOne
    private Customer cust;

    public Panier() {
    }

    public List<Detail_Panier> getDetail_paniers() {
        return detail_paniers;
    }

    public void setDetail_paniers(List<Detail_Panier> detail_paniers) {
        this.detail_paniers = detail_paniers;
    }

    public Panier(int idPanier, Date dateMajPanier, double sommeTotale, String etatPanier, Customer cust) {
        this.idPanier = idPanier;
        this.dateMajPanier = dateMajPanier;
        this.sommeTotale = sommeTotale;
        this.etatPanier = etatPanier;
        this.cust = cust;
    }

    public int getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public Date getDateMajPanier() {
        return dateMajPanier;
    }

    public void setDateMajPanier(Date dateMajPanier) {
        this.dateMajPanier = dateMajPanier;
    }

    public double getSommeTotale() {
        return sommeTotale;
    }

    public void setSommeTotale(double sommeTotale) {
        this.sommeTotale = sommeTotale;
    }

    public String getEtatPanier() {
        return etatPanier;
    }

    public void setEtatPanier(String etatPanier) {
        this.etatPanier = etatPanier;
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Panier panier = (Panier) o;
        return idPanier == panier.idPanier && Double.compare(panier.sommeTotale, sommeTotale) == 0 && Objects.equals(dateMajPanier, panier.dateMajPanier) && Objects.equals(etatPanier, panier.etatPanier) && Objects.equals(cust, panier.cust);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPanier, dateMajPanier, sommeTotale, etatPanier, cust);
    }

    @Override
    public String toString() {
        return "Panier{" +
                "idPanier=" + idPanier +
                ", dateMajPanier=" + dateMajPanier +
                ", sommeTotale=" + sommeTotale +
                ", etatPanier='" + etatPanier + '\'' +
                ", cust=" + cust +
                '}';
    }
}
