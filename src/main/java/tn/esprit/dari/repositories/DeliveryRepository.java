package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.dari.entities.Delivery;
import tn.esprit.dari.entities.DeliveryMan;
import tn.esprit.dari.entities.Utilisateur;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery,Integer> {

    @Query("select d from Delivery d where d.deliveryMan.utilisateurId=:id ")
    public List<Delivery> deliveriesBydm(@Param("id")Long id);
    @Query("select d from Delivery d,Orders o where o.custo.utilisateurId=:id and d.order.id_o=o.id_o ")
    public List<Delivery> deliveriesBycust(@Param("id")Long id);

}
