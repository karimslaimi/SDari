package tn.esprit.dari.service;

import tn.esprit.dari.entities.Agent;
import tn.esprit.dari.entities.Appointment;
import tn.esprit.dari.entities.Customer;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface IAppointmentService {

    void requestAppointment(Appointment appointment);
    void acceptAppointment(int id,String date,int appType,String address) throws ParseException;
    void cancelAppointment(int id);
    void modifyAppointment(int id,Appointment appointment);
    List<Appointment> ownerAppointments(Long id);
    List<Appointment> customerAppointments(Long id);


}
