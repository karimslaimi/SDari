package tn.esprit.dari.service;

import tn.esprit.dari.entities.ChatRoom;
import tn.esprit.dari.entities.Message;
import tn.esprit.dari.entities.Utilisateur;

import java.util.List;

public interface IMessageService {

    public Boolean AddMessage(String message, Long by, Long to);
    public List<Message> GetMessage(int sentBy, int sentTo);
    public List<Utilisateur> getUsers(int id);

}
