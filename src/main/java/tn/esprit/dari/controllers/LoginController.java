package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.esprit.dari.Config.MyUserDetails;
import tn.esprit.dari.entities.AuthenticationProvider;
import tn.esprit.dari.entities.Role;
import tn.esprit.dari.entities.Utilisateur;
import tn.esprit.dari.oauth.UtilisateurOauth;
import tn.esprit.dari.repositories.UtilisateurRepository;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @GetMapping("/login")
    public String login(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }

        return "redirect:/";


    }

  @GetMapping("/login_success_handler")
  public String loginSuccessHandler() {
      System.out.println("Logging user login success...");

      return "welcome";
  }
    @GetMapping("/getLoggedInUser")
    public String loggedInUser( Model model,Authentication authentication){
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
        model.addAttribute("message","hi " + n +" role "+ r);
        // return "Hi "+ n +" "+r;
        return "welcome";
    }
    @GetMapping("/getLocalLoggedInUser")
    public String loggedInUser(@AuthenticationPrincipal MyUserDetails userDetails, Model model){
        Utilisateur u = utilisateurRepository.getUtilisateurByEmail(userDetails.getEmail());
        String r ="";
        List<Role> roles = u.getRoles();
        for (Role role : roles){
            r= role.getName();
        }
        String n = u.getFirstName();
        model.addAttribute("message","hi " + n + " role "+ r);
        return "welcome";}

}

