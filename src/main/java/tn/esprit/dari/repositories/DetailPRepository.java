package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.Detail_Panier;

@Repository

public interface DetailPRepository extends JpaRepository<Detail_Panier,Integer > {

}
