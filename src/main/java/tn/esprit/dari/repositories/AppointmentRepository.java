package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.dari.entities.Appointment;
import tn.esprit.dari.entities.Customer;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

     List<Appointment> findAppointmentsByOwner(Customer customer);
    List<Appointment> findAppointmentsByCustomer(Customer customer);

}
