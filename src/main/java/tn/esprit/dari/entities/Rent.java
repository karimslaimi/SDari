package tn.esprit.dari.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity

public class Rent extends Property implements Serializable, Comparable<Rent> {

    @ManyToOne
    private Utilisateur user;

    private float pricePerDay;
    private float pricePerMonth;

    public Rent() {
    }
    public Rent(String adress,String state, String city, String zipCode, int nbrooms, float surface, float superficie, String image, String video, float loyer, float prix,  float pricePerDay, float pricePerMonth) {
        super.setAdress(adress);
        super.setState(state);
        super.setCity(city);
        super.setZipCode(zipCode);
        super.setNbrooms(nbrooms);
        super.setSurface(surface);
        super.setSuperficie(superficie);
        super.setImage(image);
        super.setVideo(video);
        super.setLoyer(loyer);
        super.setPrix(prix);
        this.pricePerDay = pricePerDay;
        this.pricePerMonth = pricePerMonth;
    }


   /* public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
*/

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
    @Override
    public int compareTo(Rent o) {
        return (this.getNbrooms()-o.getNbrooms());
    }
}
