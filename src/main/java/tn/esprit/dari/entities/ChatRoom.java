package tn.esprit.dari.entities;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "ChatRoom")
public class ChatRoom {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //@JsonManagedReference(value = "sent")
    @ManyToOne
    @JoinColumn(name="first")
    private Utilisateur first;
    //@JsonManagedReference(value = "received")
    @ManyToOne
    @JoinColumn(name="second")
    private Utilisateur second;

   // @JsonBackReference(value = "mess")
    @OneToMany(mappedBy = "chatRoom")
    private List<Message> messageList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilisateur getFirst() {
        return first;
    }

    public void setFirst(Utilisateur first) {
        this.first = first;
    }

    public Utilisateur getSecond() {
        return second;
    }

    public void setSecond(Utilisateur second) {
        this.second = second;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
