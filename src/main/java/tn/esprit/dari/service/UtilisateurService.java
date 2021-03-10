package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.*;
import tn.esprit.dari.repositories.AgentRepository;
import tn.esprit.dari.repositories.CustomerRepository;
import tn.esprit.dari.repositories.UtilisateurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService implements IUtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AgentRepository agentRepository;

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
        return agentRepository.findAll();
    }
    @Override
    public void updateAgent(Agent agent) {
        Agent a= agentRepository.findById(agent.getUtilisateurId()).get();
        a.setPicture(agent.getPicture());
        a.setFirstName(agent.getFirstName());
        a.setLastName(agent.getLastName());

        agentRepository.save(a);
    }



    public void addModerateur(Admin admin){
        admin.setAdminType(AdminType.MODERATEUR);
        admin.setEmail(admin.getEmail());
        admin.setEnabled(true);
        utilisateurRepository.save(admin);
    }

    public void deleteModerateur(Admin admin){
        utilisateurRepository.delete(admin);
    }
    public void deleteCustomer(Customer customer){
        utilisateurRepository.delete(customer);
    }

}
