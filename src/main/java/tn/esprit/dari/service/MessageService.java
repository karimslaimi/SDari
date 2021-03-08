package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Message;
import tn.esprit.dari.repositories.MessageRepository;
import tn.esprit.dari.entities.Utilisateur;
import tn.esprit.dari.repositories.UtilisateurRepository;

import java.util.List;

@Service
public class MessageService implements IMessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UtilisateurRepository userRepository;

    @Override
    public Boolean AddMessage(Message message, int by, int to) {

        Utilisateur sentTo=userRepository.findById((long)to).orElse(null);
        Utilisateur sentBy=userRepository.findById((long)by).orElse(null);
        if(sentBy==null || sentTo==null){
            return false;
        }
        message.setSentBy(sentBy);
        message.setSentTo(sentTo);
        return true;

    }

    @Override
    public List<Message> GetMessage(int sentBy, int sentTo) {

        //so this method will get the message where sentBy is the sender or the received and the same go for sentTo
        //will filter it in the front
        return messageRepository.getMessages(sentBy,sentTo);
    }

    @Override
    public List<Utilisateur> getUsers(int id) {
        //this method must return the list of users that the current user contacted this may be tricky
        //for the moment i don't have a solution for it cause it needs tests will test it later when i have enough data to test on
        return messageRepository.getUsers(id);
    }
}
