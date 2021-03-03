package tn.esprit.Service;

import tn.esprit.entities.Message;
import tn.esprit.entities.Utilisateur;

import java.util.List;

public interface IMessageService {

    public void AddMessage(Message message,int by, int to);
    public List<Message> GetMessage(int sentBy, int sentTo);
    public List<Utilisateur> getUsers(int id);
}
