package tn.esprit.dari.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import tn.esprit.dari.service.UtilisateurService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    UtilisateurService utilisateurService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        UtilisateurOauth utilisateurOauth = (UtilisateurOauth) authentication.getPrincipal();
        String email = utilisateurOauth.getEmail();
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
