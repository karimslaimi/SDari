package tn.esprit.entities;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
@Entity
@Table(name = "Reclamation")
public class Reclamation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;
    private String title;
    private String explication;
    private LocalDateTime dateTime;
    private String treatement;
    private Boolean state;//by default false when it will be treated it will be true


    @ManyToOne
    @JoinColumn(name = "utilisateurId")
    private Utilisateur user;


    public Reclamation(String type, String title,String explication,  LocalDateTime dateTime) {
        this.type=type;
        this.explication=explication;
        this.title=title;

        this.dateTime=dateTime;
    }

    public Reclamation() {
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getExplication() {
        return explication;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setExplication(String explication) {
        this.explication = explication;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
}
