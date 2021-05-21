package tn.esprit.dari.service;


import tn.esprit.dari.entities.Subscribe;
import tn.esprit.dari.entities.Subscription;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public  interface ISubscription {

    List<Subscription> AllSubs();
    Optional<Subscription> getSub(int id);
    List<Subscription>getSubT(String title);
    Subscription Add(Subscription S);
    Subscription Modify(Subscription S);
    void DeleteSub(int id );
    Subscribe AddSubToo(int idS, long idC, Date dateD, Date dateF);
    Subscribe EndAbo(int idS);

    List <Subscribe> GetSubs();



}
