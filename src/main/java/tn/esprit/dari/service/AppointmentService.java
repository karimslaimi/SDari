package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Agent;
import tn.esprit.dari.entities.Appointment;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.repositories.AppointmentRepository;
import tn.esprit.dari.repositories.CustomerRepository;
import tn.esprit.dari.repositories.UtilisateurRepository;
import java.util.Date;
import java.util.List;


@Service
public class AppointmentService implements IAppointmentService {
    @Autowired
    private AppointmentRepository ar;

    @Autowired
    private CustomerRepository ut;

    @Override
    public void requestAppointment(Appointment appointment) {
        appointment.setState(State.ON_HOLD);
        ar.save(appointment);
    }

    @Override
    public void acceptAppointment(int id, Date date) {

        Appointment appointment= ar.getOne(id);
        appointment.setAppointmentDate(date);
        appointment.setState(State.ACCEPTED);
        ar.save(appointment);
        //notification control
    }

    @Override
    public void cancelAppointment(int id) {
        ar.deleteById(id);
    }

    @Override
    public void modifyAppointment(int id,Appointment appointment) {
Appointment appointment1=ar.getOne(id);
appointment1.setAddress(appointment.getAddress());
appointment1.setAppointmentDate(appointment.getAppointmentDate());
//i will add here notification control later
ar.save(appointment1);

    }

    @Override
    public List<Appointment> ownerAppointments(Long id) {
Customer c=ut.getOne(id);
        return ar.findAppointmentsByOwner(c);
    }

    @Override
    public List<Appointment> customerAppointments(Long id) {
        Customer c=ut.getOne(id);
        return ar.findAppointmentsByCustomer(c);
    }
}
