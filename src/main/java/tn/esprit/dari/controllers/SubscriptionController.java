package tn.esprit.dari.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Subscription;
import tn.esprit.dari.service.ISubscription;

@Controller
@RequestMapping("/Subscription")
public class SubscriptionController {

    @Autowired
    ISubscription subscription;

    @GetMapping("/GetAll")
    public void getAll(){
        subscription.AllSubs();
    }
    @GetMapping("/getOne/{id}")
    public void getSub(String id){
        subscription.getSub(id);
    }


    @PostMapping("/addsub")
    @ResponseBody
    public Subscription Add(@RequestBody Subscription s){
        Subscription sub = subscription.Add(s);
        return (sub) ;

    }

    @DeleteMapping("/delete/{id]")
    @ResponseBody
    public void DeleteSub(@PathVariable("id") String id){
        subscription.DeleteSub(id);
    }

    @PutMapping("/Modify")
    @ResponseBody
    public Subscription modify(@RequestBody Subscription su){
        return subscription.Modify(su);
    }



}
