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
import tn.esprit.dari.entities.*;
import tn.esprit.dari.repositories.CustomerRepository;
import tn.esprit.dari.repositories.SubscribeRepository;
import tn.esprit.dari.repositories.SubscriptionRepository;
import tn.esprit.dari.repositories.UtilisateurRepository;
import tn.esprit.dari.service.Contract_buyService;
import tn.esprit.dari.service.SubscriptionImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories
public class DariApplication {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SubscribeRepository subRepo;

     @Autowired
    private SubscriptionRepository subsRepo;
     @Autowired
     private SubscriptionImpl subscription;
     @Autowired
     private Contract_buyService cbs;


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





     }