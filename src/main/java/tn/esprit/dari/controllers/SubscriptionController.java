package tn.esprit.dari.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(subscription.AllSubs(), HttpStatus.OK);


    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getSub(@PathVariable  int id){

        return new ResponseEntity<>( subscription.getSub(id), HttpStatus.OK);
    }


    @PostMapping("/addsub")
    @ResponseBody
    public Subscription Add(@RequestBody Subscription s){
        Subscription sub = subscription.Add(s);
        return (sub) ;

    }

    @DeleteMapping("/delete/{id]")
    @ResponseBody
    public void DeleteSub(@PathVariable("id") int id){
        subscription.DeleteSub(id);
    }

    @PutMapping("/Modify")
    @ResponseBody
    public Subscription modify(@RequestBody Subscription su){
        return subscription.Modify(su);
    }



}
