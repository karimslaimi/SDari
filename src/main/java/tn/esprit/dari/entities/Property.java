package tn.esprit.dari.entities;

import ch.qos.logback.core.net.server.Client;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Property implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String type;
    private int nbrooms;
    private float surface;
    private float superficie;
    private String image;
    private String video;
    private float loyer;

   // @ManyToOne
   // @JoinColumn(name = "id")
    //private Client client;


    public Property() {
    }

    public Property(String type, int nbrooms, float surface, float superficie, String image, String video, float loyer) {
        this.type = type;
        this.nbrooms = nbrooms;
        this.surface = surface;
        this.superficie = superficie;
        this.image = image;
        this.video = video;
        this.loyer = loyer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNbrooms() {
        return nbrooms;
    }

    public void setNbrooms(int nbrooms) {
        this.nbrooms = nbrooms;
    }

    public float getSurface() {
        return surface;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    public float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public float getLoyer() {
        return loyer;
    }

    public void setLoyer(float loyer) {
        this.loyer = loyer;
    }


    @Override
    public String toString() {
        return "Property{" +
                "type='" + type + '\'' +
                ", nbrooms=" + nbrooms +
                ", surface=" + surface +
                ", superficie=" + superficie +
                ", image='" + image + '\'' +
                ", video='" + video + '\'' +
                ", loyer=" + loyer +
                '}';
    }




}
