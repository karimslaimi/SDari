package tn.esprit.dari.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import tn.esprit.dari.entities.Message;
import tn.esprit.dari.entities.Utilisateur;

import java.util.List;

public interface IMessageService {

    public Boolean AddMessage(Message message, int by, int to);
    public List<Message> GetMessage(int sentBy, int sentTo);
    public List<Utilisateur> getUsers(int id);
}
