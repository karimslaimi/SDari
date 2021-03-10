package tn.esprit.dari.entities;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;


@Entity
@DiscriminatorValue("C")
public class Customer extends Utilisateur implements Serializable {



    @OneToMany(mappedBy = "customer")
    private List<Subscribe> subscribes ;


    @OneToMany(mappedBy = "owner")
    List<Appointment> ownerAppointments;
    @OneToMany(mappedBy = "customer")
    List<Appointment> customerAppointments;

    @OneToMany(mappedBy = "customer")
    private List<Property> props ;
    @OneToMany(mappedBy = "cust")
    private List<Furniture> furs ;

}
