package tn.esprit.Service;


import tn.esprit.entities.Subscription;

import java.util.List;
import java.util.Optional;

public  interface ISubscription {

    List<Subscription> AllSubs();
    Optional<Subscription> getSub(String id);
    Optional<Subscription>getSubT(String title);
    Subscription Add(Subscription S);
    Subscription Modify(Subscription S);
    void DeleteSub(String id );



}
