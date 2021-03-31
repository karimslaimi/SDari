package tn.esprit.dari.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Orders;
import tn.esprit.dari.service.IOrdersService;
import tn.esprit.dari.service.OrdersService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {


    @Autowired
    private IOrdersService ordS;
    //liste des ordres
    @GetMapping("/allorders")
    public List<Orders> All() {
        return ordS.AllOrders();
    }

    // ajout
    @PostMapping("/addorder")
    public void newOrder(@RequestBody Orders newOrder)
    {
        ordS.addOrder(newOrder);
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
 //commander
 @PostMapping("/commander")
 public void commander(@RequestBody Orders newOrder)
 {
     ordS.commander(newOrder);
 }

 //listedescommandesuser
 @GetMapping("/usercomm/{id}")
 public List<Orders> getordu(@PathVariable("id") Long id) {
     return ordS.listecommandesuser(id);
 }


}
