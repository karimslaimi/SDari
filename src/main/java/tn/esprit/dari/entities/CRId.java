package tn.esprit.dari.entities;

import java.io.Serializable;
import java.util.Objects;
//Contract rent id ( clé composé)
public class CRId implements Serializable {

    private int id_Client;
    private int id_Rent;

    public CRId(){}

    public CRId(int id_Client, int id_Rent) {
        this.id_Client = id_Client;
        this.id_Rent = id_Rent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CRId crId = (CRId) o;
        return id_Client == crId.id_Client && id_Rent == crId.id_Rent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Client, id_Rent);
    }
}
