package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.dari.entities.Agent;
import tn.esprit.dari.entities.Customer;

public interface AgentRepository extends JpaRepository<Agent, Long> {
}
