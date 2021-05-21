package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.Detail_Panier;
import tn.esprit.dari.entities.Panier;

import java.util.List;

@Repository

public interface DetailPRepository extends JpaRepository<Detail_Panier,Integer > {

    @Query("select p from Detail_Panier p where p.panier.idPanier=:id ")
    public List<Detail_Panier> getByPanier(@Param("id") int id);
}
