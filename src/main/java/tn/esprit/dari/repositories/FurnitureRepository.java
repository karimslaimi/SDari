package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.entities.Furniture;
import tn.esprit.dari.entities.FurnitureType;


import java.util.List;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture,Integer > {

    @Query("select r from Furniture r where r.type like %:type% ")
    public List<Furniture> rechByType(@Param("type") String furtype);
    @Query("select f from  Furniture f where f.cust.utilisateurId =:id")
    public List<Furniture> GetMyFurn(@Param("id") long id);
    @Query("select p.cust from Furniture p where p.id_fur=:id")
    public Customer Customerfurn(@Param("id") int id);
    @Query("select f from Furniture f where f.lc is not null")
    public List<Furniture> getDispo();
    @Query("select f from Furniture f where f.title like %:filter% or f.type like concat('%', :filter,'%') or f.description like concat('%', :filter,'%') ")
    public List<Furniture> filter(@Param("filter")String filter);

}
