package tn.esprit.dari.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.dari.entities.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
}
