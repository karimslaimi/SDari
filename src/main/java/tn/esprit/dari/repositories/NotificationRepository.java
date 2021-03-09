package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.dari.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {



}
