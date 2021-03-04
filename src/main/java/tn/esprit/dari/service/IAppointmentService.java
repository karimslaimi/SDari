package tn.esprit.dari.service;

import tn.esprit.dari.entities.Agent;
import tn.esprit.dari.entities.Appointment;
import tn.esprit.dari.entities.Customer;

import java.util.Date;
import java.util.List;

public interface IAppointmentService {

    void requestAppointment(Appointment appointment);
    void acceptAppointment(int id,Date date);
    void cancelAppointment(int id);
    void modifyAppointment(int id,Appointment appointment);
    List<Appointment> ownerAppointments(Long id);
    List<Appointment> customerAppointments(Long id);


}
