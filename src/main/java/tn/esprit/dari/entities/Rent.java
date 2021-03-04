package tn.esprit.dari.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Rent extends Property implements Serializable {

    @ManyToOne
    private Utilisateur user;
    private float pricePerDay;
    private float pricePerMonth;

    public Rent() {
    }

    public Rent(int id_rent,  float pricePerDay, float pricePerMonth) {

        this.pricePerDay = pricePerDay;
        this.pricePerMonth = pricePerMonth;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }


    public float getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public float getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(float pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rent rent = (Rent) o;
        return  Float.compare(rent.pricePerDay, pricePerDay) == 0 && Float.compare(rent.pricePerMonth, pricePerMonth) == 0 ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pricePerDay, pricePerMonth);
    }

    @Override
    public String toString() {
        return "Rent{" +

                ", pricePerDay=" + pricePerDay +
                ", pricePerMonth=" + pricePerMonth +
                '}';
    }
}
