package tn.esprit.dari.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Rent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_rent;
    private int id_client;
    private Type type;
    private float pricePerDay;
    private float pricePerMonth;

    public Rent() {
    }

    public Rent(int id_rent, int id_client, Type type, float pricePerDay, float pricePerMonth) {
        this.id_rent = id_rent;
        this.id_client = id_client;
        this.type = type;
        this.pricePerDay = pricePerDay;
        this.pricePerMonth = pricePerMonth;
    }

    public int getId_rent() {
        return id_rent;
    }

    public void setId_rent(int id_rent) {
        this.id_rent = id_rent;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
        return id_rent == rent.id_rent && id_client == rent.id_client && Float.compare(rent.pricePerDay, pricePerDay) == 0 && Float.compare(rent.pricePerMonth, pricePerMonth) == 0 && type == rent.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_rent, id_client, type, pricePerDay, pricePerMonth);
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id_rent=" + id_rent +
                ", id_client=" + id_client +
                ", type=" + type +
                ", pricePerDay=" + pricePerDay +
                ", pricePerMonth=" + pricePerMonth +
                '}';
    }
}
