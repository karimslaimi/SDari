package tn.esprit.dari.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.dari.entities.*;

import java.util.List;

@Repository
public interface PanierRepository extends JpaRepository<Panier,Integer > {

    @Query("select  p from Panier p where p.cust.utilisateurId=:id")
    public Panier getUserPanier(@Param("id") long id);

    @Query("select f from Panier p, Furniture f, Detail_Panier  d where p.cust.utilisateurId=:id and d.panier=p and d.furs=f")
    public List<Furniture> getPanierFurn(@Param("id")long id);




    @Query(value = "select d from Detail_Panier d where  d.furs.id_fur=:idf and d.panier.cust.utilisateurId=:idc " )
    public List<Detail_Panier> getDetailPanier(@Param("idf")int idf, @Param("idc") long idc, Pageable pageable);


    @Query("select f from Panier p,Detail_Panier d, Furniture f where p.idPanier=:id and d.panier=p and d.furs=f")
    public List<Furniture> getDetail(@Param("id")int id);

}
