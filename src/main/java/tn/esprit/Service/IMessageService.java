package tn.esprit.Service;

import tn.esprit.entities.Message;

import java.util.List;

public interface IMessageService {

    public void AddMessage(Message message,int by, int to);
    public List<Message> GetMessage(int sentBy, int sentTo);
}
