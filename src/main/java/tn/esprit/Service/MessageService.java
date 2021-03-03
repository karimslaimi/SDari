package tn.esprit.Service;

import org.springframework.stereotype.Service;
import tn.esprit.entities.Message;

import java.util.List;

@Service
public class MessageService implements IMessageService {
    @Override
    public void AddMessage(Message message, int by, int to) {

    }

    @Override
    public List<Message> GetMessage(int sentBy, int sentTo) {
        return null;
    }
}
