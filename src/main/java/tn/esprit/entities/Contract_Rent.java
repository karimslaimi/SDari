package tn.esprit.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@IdClass(CRId.class)
public class Contract_Rent implements Serializable {

    @Id
    private int id_Rent;
    @Id
    private int id_Client;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date dateDebut;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date dateFin;
    private String details;

    public Contract_Rent() {
    }

    public Contract_Rent(int id_Rent, int id_Client, Date dateDebut, Date dateFin, String details) {
        this.id_Rent = id_Rent;
        this.id_Client = id_Client;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.details = details;
    }

    public int getId_Rent() {
        return id_Rent;
    }

    public void setId_Rent(int id_Rent) {
        this.id_Rent = id_Rent;
    }

    public int getId_Client() {
        return id_Client;
    }

    public void setId_Client(int id_Client) {
        this.id_Client = id_Client;
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
        return id_Rent == that.id_Rent && id_Client == that.id_Client && Objects.equals(dateDebut, that.dateDebut) && Objects.equals(dateFin, that.dateFin) && Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Rent, id_Client, dateDebut, dateFin, details);
    }

    @Override
    public String toString() {
        return "Contract_Rent{" +
                "id_Rent=" + id_Rent +
                ", id_Client=" + id_Client +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", details='" + details + '\'' +
                '}';
    }
}
