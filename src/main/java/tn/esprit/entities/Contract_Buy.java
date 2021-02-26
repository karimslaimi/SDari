package tn.esprit.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@IdClass(CBId.class)
public class Contract_Buy implements Serializable {

    @Id
    private int id_Client;
    @Id
    private int id_Buy;
    private String details;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date date;

    public Contract_Buy() {
    }

    public Contract_Buy(int id_Client, int id_Buy, String details, Date date) {
        this.id_Client = id_Client;
        this.id_Buy = id_Buy;
        this.details = details;
        this.date = date;
    }

    public int getId_Client() {
        return id_Client;
    }

    public void setId_Client(int id_Client) {
        this.id_Client = id_Client;
    }

    public int getId_Buy() {
        return id_Buy;
    }

    public void setId_Buy(int id_Buy) {
        this.id_Buy = id_Buy;
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
        return id_Client == that.id_Client && id_Buy == that.id_Buy && Objects.equals(details, that.details) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Client, id_Buy, details, date);
    }

    @Override
    public String toString() {
        return "Contract_Buy{" +
                "id_Client=" + id_Client +
                ", id_Buy=" + id_Buy +
                ", details='" + details + '\'' +
                ", date=" + date +
                '}';
    }
}
