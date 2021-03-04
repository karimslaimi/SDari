package tn.esprit.dari.service;

import tn.esprit.dari.entities.Agent;
import tn.esprit.dari.entities.Appointment;
import tn.esprit.dari.entities.Customer;

import java.util.Date;
import java.util.List;

public interface IAppointmentService {

    void requestAppointment(Appointment appointment);
    void acceptAppointment(Long id,Date date);
    void cancelAppointment(Long id);
    void modifyAppointment(Long id,Appointment appointment);
    List<Appointment> ownerAppointments(Customer owner);
    List<Appointment> customerAppointments(Customer customer);


}
