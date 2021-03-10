package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.dari.entities.Notification;
import tn.esprit.dari.entities.Utilisateur;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {

List<Notification> findAllByUser(Utilisateur user);

}
