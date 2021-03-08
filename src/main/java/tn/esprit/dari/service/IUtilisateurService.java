package tn.esprit.dari.service;

import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.*;
import tn.esprit.dari.repositories.UtilisateurRepository;

import java.util.List;


public interface IUtilisateurService {

    public List<Utilisateur> getallUsers();

    public List<Agent> getAllAgents();
    public List<Customer> getAllCustomers();
    void addModerateur(Admin admin);

}
