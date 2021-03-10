package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.Furniture;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture,Integer > {
}
