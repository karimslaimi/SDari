package tn.esprit.dari.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class LigneCommande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLigne;
    private int quantite;
    private double prix;

@JsonIgnore
    @OneToOne
    private Furniture fur;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idorder")
    private Orders ord;


    public LigneCommande() {
    }

    public LigneCommande(int idLigne, int quantite, double prix, Furniture fur, Orders ord) {
        this.idLigne = idLigne;
        this.quantite = quantite;
        this.prix = prix;
        this.fur = fur;
        this.ord = ord;
    }

    public int getIdLigne() {
        return idLigne;
    }

    public void setIdLigne(int idLigne) {
        this.idLigne = idLigne;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Furniture getFur() {
        return fur;
    }

    public void setFur(Furniture fur) {
        this.fur = fur;
    }

    public Orders getOrd() {
        return ord;
    }

    public void setOrd(Orders ord) {
        this.ord = ord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LigneCommande that = (LigneCommande) o;
        return idLigne == that.idLigne && quantite == that.quantite && Double.compare(that.prix, prix) == 0 && Objects.equals(fur, that.fur) && Objects.equals(ord, that.ord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLigne, quantite, prix, fur, ord);
    }


    @Override
    public String toString() {
        return "LigneCommande{" +
                "idLigne=" + idLigne +
                ", quantite=" + quantite +
                ", prix=" + prix +
                ", fur=" + fur +
                ", ord=" + ord +
                '}';
    }
}