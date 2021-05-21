package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.entities.Property;
import tn.esprit.dari.entities.PropertyType;

import java.util.List;


@Repository
public interface PropertyRepository extends JpaRepository<Property,Integer > {

    @Query("select r from Property r where r.type like %:type% ")
    public  List<Property> rechByType(@Param("type") String proptype);
    @Query("select  p from Property p where p.customer.utilisateurId=:id")
    public  List<Property> userProp(@Param("id") long id);
    @Query("select p.customer from Property p where p.id_prop=:id")
    public Customer CustomerProps(@Param("id") int id);

    @Query("select p from Property p where p.title like %:filter% or p.adress like concat('%', :filter,'%') or p.city like concat('%', :filter,'%') or" +
            " p.description like concat('%', :filter,'%') or  p.type like concat('%', :filter,'%')")
    public List<Property> filter(@Param("filter")String filter);
}
