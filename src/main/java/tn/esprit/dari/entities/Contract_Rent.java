package tn.esprit.dari.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@IdClass(CRId.class)
public class Contract_Rent implements Serializable {

    @Id
    private int id_property;
    @Id
    private int id_user;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date dateDebut;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date dateFin;
    private String details;
    private boolean rented;
    public Contract_Rent() {
    }

    public Contract_Rent(int id_property, int id_user, Date dateDebut, Date dateFin, String details, boolean rented) {
        this.id_property = id_property;
        this.id_user = id_user;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.details = details;
        this.rented = rented;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public int getId_property() {
        return id_property;
    }

    public void setId_property(int id_property) {
        this.id_property = id_property;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract_Rent that = (Contract_Rent) o;
        return Objects.equals(dateDebut, that.dateDebut) && Objects.equals(dateFin, that.dateFin) && Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateDebut, dateFin, details);
    }

    @Override
    public String toString() {
        return "Contract_Rent{" +
                "id_Rent=" + id_property +
                ", id_Client=" + id_user +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", details='" + details + '\'' +
                '}';
    }
}
