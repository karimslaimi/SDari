package tn.esprit.dari.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Panier implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idPanier")
    private int idPanier;
    @Column(name="dateMajPanier", nullable=false, length=100)
    private Date dateMajPanier;
    @Column(name="sommeTotale", nullable=false, length=100)
    private double sommeTotale;
    @Column(name="etatPanier", nullable=false, length=100)
    private String etatPanier;
    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="panier")

    @OneToOne
    private Customer cust;




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
}
