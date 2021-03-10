package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Appointment;
import tn.esprit.dari.entities.Delivery;
import tn.esprit.dari.entities.DeliveryMan;
import tn.esprit.dari.service.AppointmentService;
import tn.esprit.dari.service.DeliveryService;
import tn.esprit.dari.service.IDeliveryManService;
import tn.esprit.dari.service.IDeliveryService;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private IDeliveryService deliveryService;

    @Autowired
    private IDeliveryManService deliveryManService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<String> addDelivery(@RequestBody Delivery delivery){

        deliveryService.createDelivery(delivery);
        return new ResponseEntity<>("delivery added", HttpStatus.OK);

    }


    @PostMapping("/createdm")
    @ResponseBody
    public ResponseEntity<String> addDeliveryMan(@RequestBody DeliveryMan deliveryman){

        deliveryManService.addDM(deliveryman);
        return new ResponseEntity<>("delivery man created", HttpStatus.OK);

    }
    @PostMapping("/cancel/{id}")
    @ResponseBody
    public ResponseEntity<String> cancelDelivery(@PathVariable int id){

        deliveryService.cancelDelivery(id);
        return new ResponseEntity<>("delivery canceled", HttpStatus.OK);
    }

    @GetMapping("/")
    public List<Delivery> deliveries(){

        return  deliveryService.deliveries();
    }

    @GetMapping("/{id}")
    public Delivery deliverybyid(@PathVariable int id){

        return  deliveryService.deliveryById(id);
    }

}
