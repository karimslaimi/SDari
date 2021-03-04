package tn.esprit.dari.entities;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
@SpringBootApplication
@Entity
@Table(name = "Message")
public class Message implements Serializable{



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  int id;
        private String content;
        private LocalDateTime dateTime;

        @ManyToOne
        @JoinColumn(name="SentByID")
        private Utilisateur sentBy;

        @ManyToOne
        @JoinColumn(name="sentToID")

        private Utilisateur sentTo;

        public Message(String content, LocalDateTime dateTime,Utilisateur sentBy, Utilisateur sentTo) {
            this.content=content;
            this.dateTime=dateTime;
            this.sentBy=sentBy;
            this.sentTo=sentTo;
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

        public Utilisateur getSentBy() {
            return sentBy;
        }

        public void setSentBy(Utilisateur sentBy) {
            this.sentBy = sentBy;
        }

        public Utilisateur getSentTo() {
            return sentTo;
        }

        public void setSentTo(Utilisateur sentTo) {
            this.sentTo = sentTo;
        }

    }
