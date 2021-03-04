package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.dari.entities.Agent;
import tn.esprit.dari.entities.Appointment;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.repositories.AppointmentRepository;

import java.util.Date;
import java.util.List;

public class AppointmentService implements IAppointmentService {
    @Autowired
    private AppointmentRepository ar;
    @Override
    public void requestAppointment(Appointment appointment) {
        appointment.setState(State.ON_HOLD);
        ar.save(appointment);

    }

    @Override
    public void acceptAppointment(Long id, Date date) {

        Appointment appointment= ar.findById(id).orElse(null);
        appointment.setAppointmentDate(date);
        appointment.setState(State.ACCEPTED);
        ar.save(appointment);
    }

    @Override
    public void cancelAppointment(Long id) {
        ar.deleteById(id);
    }

    @Override
    public void modifyAppointment(Long id,Appointment appointment) {
     ar.save(appointment);

    }

    @Override
    public List<Appointment> ownerAppointments(Customer c) {
        return ar.findAppointmentsByOwner(c);
    }

    @Override
    public List<Appointment> customerAppointments(Customer c) {
        return ar.findAppointmentsByCustomer(c);
    }
}
