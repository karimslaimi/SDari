package tn.esprit.dari.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Appointment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long AppointmentId;

    @Temporal(TemporalType.DATE)
    private Date appointmentDate;
    private String address;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    private Customer owner;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agentId")
    private Agent agent;


}
