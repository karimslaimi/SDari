package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.dari.entities.Appointment;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.entities.Subscription;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

    List<Subscription> findSubscriptionByTitle(String Title);
}
