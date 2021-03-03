package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Message;
import tn.esprit.dari.repositories.MessageRepository;
import tn.esprit.dari.entities.Utilisateur;

import java.util.List;

@Service
public class MessageService implements IMessageService {

    @Autowired
    private MessageRepository messageRepository;


    @Override
    public void AddMessage(Message message, int by, int to) {

        Utilisateur sentTo=new Utilisateur();
        Utilisateur sentBy=new Utilisateur();
        message.setSentBy(sentBy);
        message.setSentBy(sentBy);


    }

    @Override
    public List<Message> GetMessage(int sentBy, int sentTo) {
        return null;
    }

    @Override
    public List<Utilisateur> getUsers(int id) {
        return null;
    }
}
