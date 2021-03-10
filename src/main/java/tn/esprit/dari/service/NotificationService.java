package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Notification;
import tn.esprit.dari.entities.Utilisateur;
import tn.esprit.dari.repositories.NotificationRepository;
import tn.esprit.dari.repositories.UtilisateurRepository;

import java.util.Date;
import java.util.List;
@Service
public class NotificationService implements INotificationService {
   @Autowired
  private UtilisateurRepository ur;
    @Autowired
    private NotificationRepository nr;

    @Override
    public void Notify(Utilisateur user, Date date, String title, String body) {
        Notification notification=new Notification(0,date,title,body,user);
        nr.save(notification);
    }

    @Override
    public List<Notification> userNotifications(Long id) {
        return nr.findAllByUser(ur.findById(id).orElse(null));
    }


}
