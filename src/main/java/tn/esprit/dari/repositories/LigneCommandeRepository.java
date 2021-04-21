package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.Furniture;
import tn.esprit.dari.entities.LigneCommande;

@Repository

public interface LigneCommandeRepository extends JpaRepository<LigneCommande,Integer > {
}
