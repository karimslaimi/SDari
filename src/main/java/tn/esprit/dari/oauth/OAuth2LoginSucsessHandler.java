package tn.esprit.dari.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import tn.esprit.dari.entities.AuthenticationProvider;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.entities.Role;
import tn.esprit.dari.entities.Utilisateur;
import tn.esprit.dari.repositories.CustomerRepository;
import tn.esprit.dari.repositories.UtilisateurRepository;
import tn.esprit.dari.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class OAuth2LoginSucsessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        UtilisateurOauth utilisateurOauth = (UtilisateurOauth) authentication.getPrincipal();
    String email = utilisateurOauth.getEmail();
    String name = utilisateurOauth.getName();
        Customer customer = customerRepository.getCustomerByEmail(utilisateurOauth.getEmail());
        System.out.println("user's email: " + email);
        if (customer == null)
        {
            customerService.createUtilisateurAfterOAuthLoginSuccess(name,email, AuthenticationProvider.EXTERNAL);

        }
        else {
            Role role = new Role();
            role.setName("USER");
            customerService.updateUtilisateurAfterOAuthLoginSuccess(customer, AuthenticationProvider.EXTERNAL,role);
        }




    super.onAuthenticationSuccess(request,response,authentication);
    }
}
