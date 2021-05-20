package tn.esprit.dari.service;

import tn.esprit.dari.entities.Admin;
import tn.esprit.dari.entities.Agent;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.entities.Utilisateur;

import java.util.List;


public interface IUtilisateurService {

    public List<Utilisateur> getallUsers();

    public List<Agent> getAllAgents();
    void deleteModerateur(Admin admin);
    void addModerateur(Admin admin);
   // public void updateAgent(Agent agent);
    void deleteCustomer(Customer customer);
    List<Long> findAllUserId() ;

}
