package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.Contract_Rent;

@Repository
public interface Contract_rentRepository extends JpaRepository<Contract_Rent,Integer> {
}
