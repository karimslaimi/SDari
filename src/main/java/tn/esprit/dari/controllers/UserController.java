package tn.esprit.dari.controllers;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.Config.MyUserDetails;
import tn.esprit.dari.entities.*;
import tn.esprit.dari.oauth.UtilisateurOauth;
import tn.esprit.dari.repositories.CustomerRepository;
import tn.esprit.dari.repositories.UtilisateurRepository;
import tn.esprit.dari.service.CustomerService;
import tn.esprit.dari.service.IUtilisateurService;
import tn.esprit.dari.service.NotificationService;
import tn.esprit.dari.service.UtilisateurService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/UserCrud")
@AllArgsConstructor
@NoArgsConstructor
public class UserController {

    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    CustomerService customerService;
    @Autowired
     NotificationService notificationService;

    String role1="";
    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/getAllAgents")
    public List<Agent> getAllAgents(){ return utilisateurService.getAllAgents();}
    @DeleteMapping("/customerDelete/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
    }

    @DeleteMapping("/agentDelete/{id}")
    public void deleteAgent(@PathVariable("id") Long id) {
        utilisateurService.deleteAgent(id);
    }


    @GetMapping("/getUserById/{user-id}")
    public Utilisateur getUserById(@PathVariable("user-id") Long id)
    {
        return utilisateurService.getuserbyId(id);

    }

    @GetMapping("/getAllUsers")
    public List<Utilisateur> getAllUsers(){
        return utilisateurService.getallUsers();
    }


    @PostMapping("/addModerateur")
    public void addModerateur(Admin admin){
        utilisateurService.addModerateur(admin);
    }


  @GetMapping("/getLoggedInRole")
  public String getLoggedInRole(){
      role1.replaceAll("\"","");
      return role1;
  }
   @RequestMapping(value="/getLocalLoggedInUser", method = { RequestMethod.GET, RequestMethod.POST })
   public Utilisateur loggedInUser(@AuthenticationPrincipal MyUserDetails userDetails){
       Utilisateur u = utilisateurRepository.getUtilisateurByEmail(userDetails.getEmail());

       List<Role> roles = u.getRoles();
       for (Role role : roles){
           role1= role.getName();
       }
       String n = u.getFirstName();
       System.out.println("logged in");
       // model.addAttribute("message","hi " + n + " role "+ r);
       return u;}
    @GetMapping("/getLoggedInUser")
    public String loggedInUser( Authentication authentication){
        UtilisateurOauth utilisateurOauth = (UtilisateurOauth) authentication.getPrincipal();
        String m = utilisateurOauth.getEmail();
        //utilisateurRepository.getUtProviderByEmail(m).equals(AuthenticationProvider.EXTERNAL)
        Utilisateur u = utilisateurRepository.getUtilisateurByEmail(utilisateurOauth.getEmail());
        String r = "";
        List<Role> roles = u.getRoles();
        for (Role role : roles){
            r= role.getName();
        }
        String n = u.getFirstName();

         return "Hi "+ n +" "+r;
        //return "welcome";
    }
    @GetMapping("/loginFailure")
    public ResponseEntity<String> loginFailure(){
        return new ResponseEntity<>("Bad Credentials", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/notifs/{user-id}")
    public List<Notification> myNotifs(@PathVariable("user-id") Long id)
    {
        return notificationService.userNotifications(id);

    }




}
