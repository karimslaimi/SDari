package tn.esprit.dari.entities;


import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
public class FavoritesId implements Serializable {

    @ManyToOne
    @JoinColumn
    private Property property;

    @ManyToOne
    @JoinColumn
    private Customer customer;

}
