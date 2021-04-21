package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.Contract_Buy;

@Repository
public interface Contract_buyRepository extends JpaRepository<Contract_Buy,Integer> {

}
