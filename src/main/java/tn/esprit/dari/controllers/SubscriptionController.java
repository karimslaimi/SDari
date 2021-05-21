package tn.esprit.dari.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Subscribe;
import tn.esprit.dari.entities.Subscription;
import tn.esprit.dari.service.ISubscription;
import tn.esprit.dari.service.SubscriptionImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
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

    @GetMapping("/getSubByTitle/{title}")
    public ResponseEntity<?> SubByTitle(@PathVariable String title){

        return new ResponseEntity<>( subscription.getSubT(title), HttpStatus.OK);
    }

    @PostMapping("/addsub")
    @ResponseBody
    public ResponseEntity<?> Add(@RequestBody Subscription s){
        Subscription sub = subscription.Add(s);
        return new ResponseEntity<>( " Subscription added. ",  HttpStatus.OK);

    }
    @PostMapping("/addsubscribe/{idC}")
    @ResponseBody
    public ResponseEntity<?> AddS(@RequestBody Subscribe s, @PathVariable("idC") long idC){
        Subscribe su = subscription.AddSubToo(s.getSubscription().getId_sub(),idC ,s.getDateD(),s.getDateF());
        return new ResponseEntity<>("subscribe added too",HttpStatus.OK);

    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void DeleteSub(@PathVariable("id") int id){
        subscription.DeleteSub(id);
    }

    @PostMapping ("/Modify")
    @ResponseBody
    public Subscription modify(@RequestBody Subscription su){

        return subscription.Modify(su);
    }


    @GetMapping("/GetAllS")
    public ResponseEntity<?> getAllSubsribes(){
        return new ResponseEntity<>(subscription.GetSubs(),  HttpStatus.OK);


    }


    @GetMapping("/End/{idS}")
    public Subscribe End(@PathVariable int idS){
        return subscription.EndAbo(idS);
    }


    //--------------------------------paiement--------------------------------------//

    // Reading the value from the application.properties file
    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("amount", 50 * 100); // In cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        return "index";
    }

    @Autowired
    private SubscriptionImpl stripeService;

    @RequestMapping(value = "/charge", method = RequestMethod.POST)
    public String chargeCard(HttpServletRequest request) throws Exception {
        String token = request.getParameter("stripeToken");
        Double amount = Double.parseDouble(request.getParameter("amount"));
        stripeService.chargeNewCard(token, amount);
        return "result";
    }


}
