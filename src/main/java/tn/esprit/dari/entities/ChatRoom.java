package tn.esprit.dari.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "ChatRoom")
public class ChatRoom {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="first")
    private Utilisateur first;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="second")
    private Utilisateur second;

    @JsonBackReference
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
