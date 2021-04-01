package tn.esprit.dari.service;

import tn.esprit.dari.entities.Notification;
import tn.esprit.dari.entities.Utilisateur;

import java.util.Date;
import java.util.List;

public interface INotificationService {
    void Notify(Utilisateur user, Date date,String title,String body);
    List<Notification> userNotifications(Long id);

}
