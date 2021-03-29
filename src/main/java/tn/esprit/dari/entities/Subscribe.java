package tn.esprit.dari.entities;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
public class Subscribe implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_sub",  nullable = false)
    private Subscription subscription;


    @ManyToOne
    @JoinColumn(name = "UtilisateurId",   nullable = false)
    private Customer customers ;

    private Date DateD;
    private Date DateF ;

    private boolean paid ;

    public Subscribe(int id, Subscription subscription, Customer customers, Date dateD, Date dateF, Boolean paid) {
        this.id = id;
        this.subscription = subscription;
        this.customers = customers;
        DateD = dateD;
        DateF = dateF;
        this.paid = paid;
    }

    public Subscribe() {

    }


    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    public Date getDateD() {
        return DateD;
    }

    public void setDateD(Date dateD) {
        DateD = dateD;
    }

    public Date getDateF() {
        return DateF;
    }

    public void setDateF(Date dateF) {
        DateF = dateF;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
