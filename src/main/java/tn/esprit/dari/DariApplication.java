package tn.esprit.dari;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import tn.esprit.dari.entities.Appointment;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.entities.Utilisateur;
import tn.esprit.dari.repositories.UtilisateurRepository;

@SpringBootApplication

public class DariApplication {

    @Autowired
    private UtilisateurRepository userRepo;

    public static void main(String[] args) {

        SpringApplication.run(DariApplication.class, args);

    }

/*    @Bean
    public CommandLineRunner init() {

        return (args -> {
            Utilisateur user=new Utilisateur();
            user.setEmail("user1@user.com");
            user.setEnabled(true);
            user.setFirstName("user1");
            user.setLastName("user11");
            user.setPassword("user1");
            user.setPhone("51887898");
            user.setPicture("whatever.jpg");
            user.setRegion(null);
            userRepo.save(user);

            Utilisateur user1=new Utilisateur();
            user1.setEmail("user2@user.com");
            user1.setEnabled(true);
            user1.setFirstName("user2");
            user1.setLastName("user22");
            user1.setPassword("user2");
            user1.setPhone("51887898");
            user1.setPicture("whatever.jpg");
            user1.setRegion(null);
            userRepo.save(user1);
        });}*/
}
