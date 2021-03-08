package tn.esprit.dari.controllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Admin;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.entities.Utilisateur;
import tn.esprit.dari.repositories.CustomerRepository;
import tn.esprit.dari.service.IUtilisateurService;
import tn.esprit.dari.service.UtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/UserCrud/")
@AllArgsConstructor
public class UserController {

    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/getallUsers/{user-id}")
    public Utilisateur getallUsers(@PathVariable("user-id") Long id)
    {
        return utilisateurService.getuserbyId(id);

    }
    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    @PostMapping("/addModerateur")
    public void addModerateur(Admin admin){
        utilisateurService.addModerateur(admin);
    }


}
