package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.Property;

import java.util.List;


@Repository
public interface PropertyRepository extends JpaRepository<Property,Integer > {






}
