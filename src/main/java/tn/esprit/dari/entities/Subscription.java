package tn.esprit.dari.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Subscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_sub;
    private String title;
    private float price;
    private String description ;


    @OneToMany(mappedBy = "subscription")
    private List<Subscribe> subscribes ;



    public Subscription( String title, float price, String description) {

        this.title = title;
        this.price = price;
        this.description = description;

    }



    public Subscription() {

    }


    public int getId_sub() {
        return id_sub;
    }

    public void setId_sub(int id_sub) {
        this.id_sub = id_sub;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<Subscribe> getSubscribes() {
        return subscribes;
    }

    public void setSubscribes(List<Subscribe> subscribes) {
        this.subscribes = subscribes;
    }
}
