package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.*;
import tn.esprit.dari.repositories.AppointmentRepository;
import tn.esprit.dari.repositories.CustomerRepository;
import tn.esprit.dari.repositories.NotificationRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class AppointmentService implements IAppointmentService {
    @Autowired
    private AppointmentRepository ar;

    @Autowired
    private CustomerRepository ut;

    @Autowired
    private INotificationService nr;

    @Override
    public void requestAppointment(Appointment appointment) {

        appointment.setState(State.ON_HOLD);
        appointment.setOwner(ut.getOne(appointment.getOwnerId()));
        appointment.setCustomer(ut.getOne(appointment.getCustomerId()));
        ar.save(appointment);
        //notification sending
        nr.Notify(ut.getOne(appointment.getOwner().getUtilisateurId()),new Date(),"Appointment request","You have a new appointment request! Check your appointments for more information.");
    }

    @Override
    public void acceptAppointment(int id, String date,int appType) throws ParseException {

        Appointment appointment= ar.getOne(id);
        appointment.setAppointmentDate(new SimpleDateFormat("dd/MM/yyyy").parse(date));
        appointment.setState(State.ACCEPTED);
        if (appType==1)
        appointment.setAppointmentType(AppointmentType.FACE_TO_FACE);
        else
            appointment.setAppointmentType(AppointmentType.FACE_TO_FACE);

        ar.save(appointment);
        //notification control
        nr.Notify(ut.getOne(appointment.getCustomer().getUtilisateurId()),new Date(),"Appointment accepted","Your appointment has been accepted");

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
appointment1.setAppointmentType(appointment.getAppointmentType());
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
