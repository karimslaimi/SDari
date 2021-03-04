package tn.esprit.dari.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.dari.service.State;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Appointment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int appointmentId;

    @Temporal(TemporalType.DATE)
    private Date appointmentDate;

    private String address;

    private State state;


    @Transient
    private Long ownerId;
    @Transient
    private Long customerId;
    @Transient
    private Long agentId;


    @ManyToOne
    @JoinColumn(name = "ownerId")
    private Customer owner;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agentId")
    private Agent agent;
@JsonIgnore
    public Customer getOwner() {
        return owner;
    }
 @JsonIgnore
    public Customer getCustomer() {
        return customer;
    }
@JsonIgnore
    public Agent getAgent() {
        return agent;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", appointmentDate=" + appointmentDate +
                ", address='" + address + '\'' +
                ", state=" + state +
                ", ownerId=" + ownerId +
                ", customerId=" + customerId +
                ", agentId=" + agentId +
                ", owner=" + owner +
                ", customer=" + customer +
                ", agent=" + agent +
                '}';
    }
}
