package tn.esprit.dari.entities;

import java.io.Serializable;
import java.util.Objects;
//Contract Buy Id ( cle composé)
public class CBId implements Serializable {

    private int id_user;
    private int id_property;

    public CBId(){}

    public CBId(int id_user, int id_property) {
        this.id_user = id_user;
        this.id_property = id_property;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CBId cbId = (CBId) o;
        return id_user == cbId.id_user && id_property == cbId.id_property;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_user, id_property);
    }
}
