package tn.esprit.Service;


import tn.esprit.entities.Subscribe;
import tn.esprit.entities.Subscription;

import java.util.List;

public  interface ISubscription {

    List<Subscription> AllSubs();
    Subscribe Add(Subscription S);
    Subscription Modify(Subscription S);
    void DeleteSub(Long id );



}
