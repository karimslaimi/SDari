package tn.esprit.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(CSubId.class)
public class Subscribe implements Serializable {

    @Id
    private int Id_sub;
    @Id
    private int Id_client;

    private Date DateD;
    private Date DateF;

    public Subscribe(int id_sub, int id_client, Date dateD, Date dateF) {
        Id_sub = id_sub;
        Id_client = id_client;
        DateD = dateD;
        DateF = dateF;
    }

    public Subscribe() {

    }

    public int getId_sub() {
        return Id_sub;
    }

    public void setId_sub(int id_sub) {
        Id_sub = id_sub;
    }

    public int getId_client() {
        return Id_client;
    }

    public void setId_client(int id_client) {
        Id_client = id_client;
    }

    public Date getDateD() {
        return DateD;
    }

    public void setDateD(Date dateD) {
        DateD = dateD;
    }

    public Date getDateF() {
        return DateF;
    }

    public void setDateF(Date dateF) {
        DateF = dateF;
    }
}
