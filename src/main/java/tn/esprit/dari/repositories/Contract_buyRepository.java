package tn.esprit.dari.repositories;

import org.apache.http.annotation.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.Buy;
import tn.esprit.dari.entities.Contract_Buy;

import java.util.List;

@Repository
public interface Contract_buyRepository extends JpaRepository<Contract_Buy,Integer> {

    @Query("select cb from Contract_Buy cb where cb.id_user =:x and cb.id_property =:y")
    Contract_Buy find( @Param("y") int p2,@Param("x")long p1);
}
