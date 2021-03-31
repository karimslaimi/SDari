package tn.esprit.dari;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import tn.esprit.dari.entities.*;
import tn.esprit.dari.repositories.CustomerRepository;
import tn.esprit.dari.repositories.SubscribeRepository;
import tn.esprit.dari.repositories.SubscriptionRepository;
import tn.esprit.dari.repositories.UtilisateurRepository;
import tn.esprit.dari.service.SubscriptionImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@SpringBootApplication

public class DariApplication {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SubscribeRepository subRepo;

     @Autowired
    private SubscriptionRepository subsRepo;
     @Autowired
     private SubscriptionImpl subscription;


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

 /*
     @Bean
    public CommandLineRunner init() {

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

            Customer user1=new Customer();
            user1.setEmail("user2@user.com");
            user1.setEnabled(true);
            user1.setFirstName("user2");
            user1.setLastName("user22");
            user1.setPassword("user2");
            user1.setPhone("51887898");
            user1.setPicture("whatever.jpg");
            user1.setRegion(Region.Bizerte);
            customerRepository.save(user1);
*/
/*
            Subscription su = new Subscription();
            su.setTitle("normal");
            su.setPrice(200);
            su.setDescription("ich fick dish mann");
            subsRepo.save(su);



            /*Subscribe sub = new Subscribe();
            sub.setDateD(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            sub.setDateF(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));

            Subscription su=subsRepo.findById(1).get();
            Customer cu=customerRepository.findById((long)1).get();

            sub.setSubscription(su);
            sub.setCustomers(cu);

            subscription.insertWithQuery(sub);




        });}

 */
}
