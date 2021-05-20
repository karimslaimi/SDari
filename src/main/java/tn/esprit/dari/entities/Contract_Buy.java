package tn.esprit.dari.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@IdClass(CBId.class)
public class Contract_Buy implements Serializable {

    @Id
    private int id_user;
    @Id
    private int id_property;

    private String details;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date date;

    public Contract_Buy() {
    }

    public Contract_Buy(int id_user, int id_property, String details, Date date) {
        this.id_user = id_user;
        this.id_property = id_property;
        this.details = details;
        this.date = date;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_property() {
        return id_property;
    }

    public void setId_property(int id_property) {
        this.id_property = id_property;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract_Buy that = (Contract_Buy) o;
        return Objects.equals(details, that.details) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash( details, date);
    }

    @Override
    public String toString() {
        return "Contract_Buy{" +
                "id_Client=" + id_user +
                ", id_Buy=" + id_property +
                ", details='" + details + '\'' +
                ", date=" + date +
                '}';
    }
}
