package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Appointment;
import tn.esprit.dari.entities.AppointmentType;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.entities.State;
import tn.esprit.dari.repositories.AppointmentRepository;
import tn.esprit.dari.repositories.CustomerRepository;

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
    public void acceptAppointment(int id, String date,int appType,String address) throws ParseException {

        Appointment appointment= ar.getOne(id);
        appointment.setAddress(address);
        appointment.setAppointmentDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        appointment.setState(State.ACCEPTED);
        if (appType==1)
        appointment.setAppointmentType(AppointmentType.FACE_TO_FACE);
        else
            appointment.setAppointmentType(AppointmentType.ONLINE);

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
        List<Appointment> ls=ar.findAppointmentsByOwner(c);
       for( Appointment ap : ls)
       {
           ap.setOwnerId(ap.getOwner().getUtilisateurId());
           ap.setCustomerId(ap.getCustomer().getUtilisateurId());
           if(ap.getAgent()!=null)
               ap.setAgentId(ap.getAgent().getUtilisateurId());
       }

        return ls;
    }

    @Override
    public List<Appointment> customerAppointments(Long id) {
        Customer c=ut.getOne(id);
        List<Appointment> ls=ar.findAppointmentsByCustomer(c);
        for( Appointment ap : ls)
        {
            ap.setOwnerId(ap.getOwner().getUtilisateurId());
            ap.setCustomerId(ap.getCustomer().getUtilisateurId());
            if(ap.getAgent()!=null)
                ap.setAgentId(ap.getAgent().getUtilisateurId());
        }
        return ls;
    }
}
