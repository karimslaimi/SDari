package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.Panier;
import tn.esprit.dari.entities.Property;

@Repository
public interface PanierRepository extends JpaRepository<Panier,Integer > {

}
