package tn.esprit.dari.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
@Entity
@Table(name = "Message")
public class Message implements Serializable{



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  int id;
        private String content;
        private LocalDateTime dateTime;
        private int sender;



        //if you want to get the chat room for every message and the users who participate in this chatroom
    //remove the comment in jsonManagedReference
    //with json ignore u will get only the message content, date and sender id

         @JsonIgnore
        //@JsonManagedReference
         @ManyToOne
        @JoinColumn(name="chatid")
        private ChatRoom chatRoom;



        public Message(String content) {
            this.content=content;
            this.dateTime=LocalDateTime.now();

        }

        public Message() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public LocalDateTime getDateTime() {
            return dateTime;
        }

        public void setDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
        }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }
}
