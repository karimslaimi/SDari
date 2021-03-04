package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.dari.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
