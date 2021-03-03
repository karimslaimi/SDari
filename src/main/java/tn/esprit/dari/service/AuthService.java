package tn.esprit.dari.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.dari.dto.RegisterRequest;
import tn.esprit.dari.repositories.UtilisateurRepository;
import tn.esprit.dari.repositories.VerificationTokenRepository;
import tn.esprit.entities.NotificationEmail;
import tn.esprit.entities.Utilisateur;
import tn.esprit.entities.VerificationToken;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
@Data
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UtilisateurRepository utilisateurRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final MailService mailService;


    @Transactional
    public void signUp( RegisterRequest registerRequest){
        Utilisateur user = new Utilisateur();
        //user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setEnabled(false);

        utilisateurRepository.save(user);
        String token =        generateVerificationToken(user);
        mailService.sendEmail(new NotificationEmail("Please Activate your Account ", user.getEmail(),"Thank you for signing up to Dari.tn "
                + "please click on this link to activate your account, " + "http://localhost:8081/Blog/auth/accountVerification/"+ token));

    }
    private String generateVerificationToken(Utilisateur user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationTokenRepository.save(verificationToken);

        return token;
    }
}
