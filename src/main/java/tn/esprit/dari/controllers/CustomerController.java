package tn.esprit.dari.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.Config.MyUserDetails;
import tn.esprit.dari.dto.RegisterRequest;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.entities.Property;
import tn.esprit.dari.entities.Role;
import tn.esprit.dari.entities.Utilisateur;
import tn.esprit.dari.repositories.CustomerRepository;
import tn.esprit.dari.repositories.UtilisateurRepository;
import tn.esprit.dari.service.AuthService;
import tn.esprit.dari.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    private  AuthService authService;


    @Autowired
    UtilisateurRepository utilisateurRepository;


    @PostMapping("/addFave/{propId}/{customerId}")
    public void addFave(@PathVariable("propId") int propId, @PathVariable("customerId") Long customerId ){
        customerService.addFave(propId,customerId);
    }
    @GetMapping("/getAllFave/{customerId}")
    public List<Property> getAllFave(@PathVariable("customerId") Long customerId)
    {
        return customerService.getAllfave(customerId);
    }
    @PutMapping ("/deleteFave/{propId}/{customerId}")
    public void deleteFave(@PathVariable("propId") int propId, @PathVariable("customerId") Long customerId){
        customerService.deleteFave(propId,customerId);
    }
    @PutMapping("/updateProfile")
    public void updateProfile(@RequestBody Customer customer){
        customerService.updateProfile(customer);
    }


}
