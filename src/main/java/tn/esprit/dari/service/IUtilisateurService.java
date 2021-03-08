package tn.esprit.dari.service;

import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Agent;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.entities.Property;
import tn.esprit.dari.entities.Utilisateur;
import tn.esprit.dari.repositories.UtilisateurRepository;

import java.util.List;


public interface IUtilisateurService {

    public List<Utilisateur> getallUsers();

    public List<Agent> getAllAgents();
    public List<Customer> getAllCustomers();
    void addFave(int propId);

}
