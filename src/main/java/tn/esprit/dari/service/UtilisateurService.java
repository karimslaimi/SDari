package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.dari.Exceptions.DariException;
import tn.esprit.dari.entities.*;
import tn.esprit.dari.repositories.AgentRepository;
import tn.esprit.dari.repositories.CustomerRepository;
import tn.esprit.dari.repositories.UtilisateurRepository;

import java.util.ArrayList;
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
        return (List<Utilisateur>) utilisateurRepository.findAll();
    }

    @Override
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
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
    public void deleteAgent(Long id) {
        utilisateurRepository.deleteById(id);
    }

    public List<Customer> getAllCustomers() {
            return customerRepository.findAll();
        }


    public void updateResetPasswordToken(String token, String email) throws DariException  {
        Utilisateur utilisateur = utilisateurRepository.getUtilisateurByEmail(email);
        if (utilisateur != null) {
            utilisateur.setResetPasswordToken(token);
            utilisateurRepository.save(utilisateur);
        } else {
            throw new DariException("Could not find any customer with the email " + email);
        }
    }
    public Utilisateur getByResetPasswordToken(String token) {
        return utilisateurRepository.getUtilisateurByResetPasswordToken(token);
    }
    public void updatePassword(Utilisateur utilisateur, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        utilisateur.setPassword(encodedPassword);

        utilisateur.setResetPasswordToken(null);
        utilisateurRepository.save(utilisateur);
    }
    @Override
    public List<Long> findAllUserId() {
        List<Utilisateur> lst = (List<Utilisateur>) utilisateurRepository.findAll();
        List<Long> lstuserid = new ArrayList<>();
        for(int i=0;i<lst.size();i++){ lstuserid.add(lst.get(i).getUtilisateurId());
        }
        return lstuserid;
    }

}
