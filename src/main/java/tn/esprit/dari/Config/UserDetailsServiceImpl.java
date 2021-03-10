package tn.esprit.dari.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import tn.esprit.dari.entities.Utilisateur;
import tn.esprit.dari.repositories.UtilisateurRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.getUtilisateurByUsername(s);
       if(utilisateur == null){
           throw new UsernameNotFoundException("user not found");
       }
        return new MyUserDetails(utilisateur);
    }
}
