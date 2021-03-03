package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.Property;
import tn.esprit.dari.entities.Reclamation;

import java.util.List;


@Repository
public interface PropertyRepository extends JpaRepository<Property,Integer > {

   //find prop by id
    @Query("select  p from Property p where p.id=:id")
    public List<Property> findOne(@Param("id")int id);






}
