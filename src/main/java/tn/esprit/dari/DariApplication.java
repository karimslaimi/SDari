package tn.esprit.dari;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
//import sun.tools.jar.CommandLine;
import tn.esprit.dari.entities.Appointment;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.entities.Region;
import tn.esprit.dari.entities.Utilisateur;
import tn.esprit.dari.repositories.CustomerRepository;
import tn.esprit.dari.repositories.UtilisateurRepository;

@SpringBootApplication
@EnableJpaRepositories
public class DariApplication {

    @Autowired
    private CustomerRepository customerRepository;
    public static void main(String[] args) {

        SpringApplication.run(DariApplication.class, args);

    }
    @Bean
    public ClassLoaderTemplateResolver secondaryTemplateResolver() {
        ClassLoaderTemplateResolver secondaryTemplateResolver = new ClassLoaderTemplateResolver();
        secondaryTemplateResolver.setPrefix("templates-2/");
        secondaryTemplateResolver.setSuffix(".html");
        secondaryTemplateResolver.setTemplateMode(TemplateMode.HTML);
        secondaryTemplateResolver.setCharacterEncoding("UTF-8");
        secondaryTemplateResolver.setOrder(1);
        secondaryTemplateResolver.setCheckExistence(true);

        return secondaryTemplateResolver;
    }



 /*   @Bean
    public CommandLineRunner  init(){
        return (args -> {
            Customer user=new Customer();
            user.setEmail("user1@user.com");
            user.setEnabled(true);
            user.setFirstName("user1");
            user.setLastName("user11");
            user.setPassword("user1");
            user.setPhone("51887898");
            user.setPicture("whatever.jpg");
            user.setRegion(Region.Bizerte);





            customerRepository.save(user);

        });*/




}
