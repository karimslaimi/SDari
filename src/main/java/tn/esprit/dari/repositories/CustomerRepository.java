package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.entities.Property;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer getCustomerByEmail(String email);
}
