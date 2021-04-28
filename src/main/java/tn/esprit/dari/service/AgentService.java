package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.dari.entities.Agent;
import tn.esprit.dari.repositories.AgentRepository;

public class AgentService {
    @Autowired
    AgentRepository agentRepository;


    public void updateAgent(Agent agent) {
        Agent a= agentRepository.findById(agent.getUtilisateurId()).get();
        a.setPicture(agent.getPicture());
        a.setFirstName(agent.getFirstName());
        a.setLastName(agent.getLastName());

        agentRepository.save(a);
    }
}
