package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Agent;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.entities.Utilisateur;
import tn.esprit.dari.repositories.UtilisateurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService implements IUtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;


    public Utilisateur getuserbyId(Long id) {
        Optional<Utilisateur> user = utilisateurRepository.findById(id);
        return  user.get();
    }

    @Override
    public List<Utilisateur> getallUsers() {
        return null;
    }

    @Override
    public List<Agent> getAllAgents() {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }
}
