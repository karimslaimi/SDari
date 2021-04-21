package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.Buy;

import java.util.List;

@Repository
public interface BuyRepository extends JpaRepository<Buy,Integer> {

    List<Buy> findByPriceAndNbrooms(float price,int nbr);
    List<Buy> findBySuperficieAndPrice(float superficie,float price);
    List<Buy> findByNbroomsAndPrice(int nbr,float price);
    @Query("select b from Buy b where b.price>=:lower and b.price<=:higher")
    List<Buy> findBetweenPrice(@Param("lower")float p1,@Param("higher") float p2);

}
