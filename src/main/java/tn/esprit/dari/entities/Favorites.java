package tn.esprit.dari.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Favorites  {
    @Id
    FavoritesId pk;

    public Property getProperty(){
        return getPk().getProperty();
    }
    public Customer getCustomer(){
        return getPk().getCustomer();
    }
}
