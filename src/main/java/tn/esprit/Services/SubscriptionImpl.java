package tn.esprit.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Respository.SubscriptionRepository;
import tn.esprit.entities.Subscribe;
import tn.esprit.entities.Subscription;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;


@Service
public class SubscriptionImpl implements ISubscription {

    @Autowired
    SubscriptionRepository SubRep ;



    @Override
    public List<Subscription> AllSubs() {

        List<Subscription> subs = (List<Subscription>) SubRep.findAll();
        for(Subscription sub  : subs ){
            System.out.println("subscriptions    : " + sub);

        }
        return subs;
    }

    @Override
    public Subscribe Add(Subscription S) {
        return null;
    }

    @Override
    public Subscription Modify(Subscription S) {
        return null;
    }

    @Override
    public void DeleteSub(Long id) {

    }
}
