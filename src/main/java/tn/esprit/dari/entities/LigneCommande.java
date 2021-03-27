package tn.esprit.dari.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLigne;
    private int quantite;
    private double prix;



    @OneToOne
    private Furniture fur;
    @ManyToOne
    private Orders ord;



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
    public String toString() {
        return "LigneCommande{" +
                "idLigne=" + idLigne +
                ", quantite=" + quantite +
                ", prix=" + prix +
                ", fur=" + fur +
                ", ord=" + ord +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LigneCommande that = (LigneCommande) o;
        return idLigne == that.idLigne && quantite == that.quantite && Double.compare(that.prix, prix) == 0 && fur.equals(that.fur) && ord.equals(that.ord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLigne, quantite, prix, fur, ord);
    }
}
