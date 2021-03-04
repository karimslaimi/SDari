package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.Appointment;
import tn.esprit.dari.entities.Customer;

import java.util.List;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

     List<Appointment> findAppointmentsByOwner(Customer customer);
    List<Appointment> findAppointmentsByCustomer(Customer customer);

}
