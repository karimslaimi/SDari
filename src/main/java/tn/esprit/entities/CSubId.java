package tn.esprit.entities;

import java.io.Serializable;

public class CSubId implements Serializable {

    private int id_sub;
    private int id_client ;

    public CSubId(int id_sub, int id_client) {
        this.id_sub = id_sub;
        this.id_client = id_client;
    }

    public CSubId() {
    }

    public int getId_sub() {
        return id_sub;
    }

    public void setId_sub(int id_sub) {
        this.id_sub = id_sub;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
}
