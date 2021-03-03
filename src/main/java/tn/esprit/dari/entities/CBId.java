package tn.esprit.dari.entities;

import java.io.Serializable;
import java.util.Objects;
//Contract Buy Id ( cle composé)
public class CBId implements Serializable {

    private int id_Client;
    private int id_Buy;

    public CBId(){}

    public CBId(int id_Client, int id_Buy) {
        this.id_Client = id_Client;
        this.id_Buy = id_Buy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CBId cbId = (CBId) o;
        return id_Client == cbId.id_Client && id_Buy == cbId.id_Buy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Client, id_Buy);
    }
}
