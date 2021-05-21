package tn.esprit.dari.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Furniture;
import tn.esprit.dari.entities.Orders;
import tn.esprit.dari.service.IOrdersService;
import tn.esprit.dari.service.SubscriptionImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {


    @Autowired
    private IOrdersService ordS;
    //liste des ordres
    @GetMapping("/allorders/{idc}")
    public List<Orders> All(@PathVariable int idc) {
        return ordS.AllOrders(idc);
    }

    @GetMapping("/FurnOrd/{id}")
    public List<Furniture> orderFurn(@PathVariable int id){
        return  ordS.ordFurn(id);
    }


    // commander ajout fi ligne commande
    @PostMapping("/commander/{idc}")
    public void newOrder(@PathVariable int idc)
    {
        ordS.addOrder(idc);
    }

    //une commande
    @GetMapping("/ordget/{id}")
    public Orders getord(@PathVariable("id") int id) {
        return ordS.getorder(id);
    }
    //annuler
    @DeleteMapping("/ordsupp/{id}")
    public void deleteOrder(@PathVariable("id") int id) {
        ordS.deleteOrder(id);
    }

 //listedescommandesuser
 @GetMapping("/usercomm/{id}")
 public List<Orders> getordu(@PathVariable("id") Long id) {
     return ordS.listecommandesuser(id);
 }


    //--------------------------------paiement--------------------------------------//

    // Reading the value from the application.properties file
    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;
/*
    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("amount", 50 * 100); // In cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        return "index";
    }*/

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
