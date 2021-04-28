package tn.esprit.dari.entities;

import java.io.Serializable;
import java.util.Objects;
//Contract rent id ( clé composé)
public class CRId implements Serializable {

    private int id_user;
    private int id_property;

    public CRId(){}

    public CRId(int id_user, int id_property) {
        this.id_user = id_user;
        this.id_property = id_property;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CRId crId = (CRId) o;
        return id_user == crId.id_user && id_property == crId.id_property;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_user, id_property);
    }
}
