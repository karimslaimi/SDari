package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.entities.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
}
