package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer > {

}
