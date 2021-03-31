package tn.esprit.dari.entities;

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
    private float total_price;

    @ManyToOne
    @JoinColumn(name = "id")
    private Customer custo;

    @OneToOne
    private Furniture fur;

    @OneToMany(mappedBy = "idorder")
    private List<LigneCommande> lc;


    public Orders() {
    }

    public Orders(int id_o, Date datecommande, float total_price, Customer custo, Furniture fur, List<LigneCommande> lc) {
        this.id_o = id_o;
        this.datecommande = datecommande;
        this.total_price = total_price;
        this.custo = custo;
        this.fur = fur;
        this.lc = lc;
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

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id_o == orders.id_o && Float.compare(orders.total_price, total_price) == 0 && Objects.equals(datecommande, orders.datecommande) && Objects.equals(custo, orders.custo) && Objects.equals(fur, orders.fur) && Objects.equals(lc, orders.lc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_o, datecommande, total_price, custo, fur, lc);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id_o=" + id_o +
                ", datecommande=" + datecommande +
                ", total_price=" + total_price +
                ", custo=" + custo +
                ", fur=" + fur +
                ", lc=" + lc +
                '}';
    }
}
