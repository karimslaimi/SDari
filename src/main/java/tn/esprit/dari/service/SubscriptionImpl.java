package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.entities.Subscribe;
import tn.esprit.dari.entities.Utilisateur;
import tn.esprit.dari.repositories.CustomerRepository;
import tn.esprit.dari.repositories.SubscribeRepository;
import tn.esprit.dari.repositories.SubscriptionRepository;
import tn.esprit.dari.entities.Subscription;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class SubscriptionImpl implements ISubscription {

    @Autowired
    SubscriptionRepository SubRep ;

    @Autowired
    SubscribeRepository subscribeRepository ;


    @Autowired
    CustomerRepository customerRepository ;



    @Override
    public List<Subscription> AllSubs() {

        List<Subscription> subs = (List<Subscription>) SubRep.findAll();
        for(Subscription sub  : subs ){
            System.out.println("subscriptions    : " + sub);

        }
        return subs;
    }

    @Override
    public Optional<Subscription> getSub(int id) {
        return SubRep.findById(id);
    }

    @Override
    public List<Subscription> getSubT(String title) {

        return SubRep.findSubscriptionByTitle(title);
    }

    @Override
    public Subscription Add(Subscription S) {

        return SubRep.save(S);
    }




    @Override
    public Subscription Modify(Subscription S) {


        Subscription sub =SubRep.findById(S.getId_sub()).orElse(null);
        sub.setTitle(S.getTitle());
        sub.setPrice(S.getPrice());
        sub.setDescription(S.getDescription());
        return SubRep.save(sub);
    }

    @Override
    public void DeleteSub(int  id) {
        SubRep.deleteById(id);
    }

    @Override
    public Subscribe AddSubToo(int idS, Long idC, Date dateD, Date dateF) {

        Subscribe s = new Subscribe();
        s.setDateD(new Date());
        s.setDateF(new Date());
        s.setCustomers(customerRepository.getOne(idC));
        s.setSubscription(SubRep.getOne(idS));
        return subscribeRepository.save(s);
    }
}
