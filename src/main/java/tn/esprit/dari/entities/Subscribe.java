package tn.esprit.dari.entities;

import tn.esprit.entities.Customer;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
public class Subscribe implements Serializable {



    private Subscription subscription;



    //private Customer Customer ;

    private Date DateD;
    private Date DateF ;
    @Id
    private Long id;


    @ManyToOne
    @JoinColumn(name = "id_sub", referencedColumnName = "id_sub", insertable = false, nullable = false)
    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

   // @ManyToOne
    //@JoinColumn(name = "utilisateurId", referencedColumnName = "utilisateurId", insertable = false, nullable = false)






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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
