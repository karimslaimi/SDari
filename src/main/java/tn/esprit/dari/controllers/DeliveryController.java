package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Delivery;
import tn.esprit.dari.entities.DeliveryMan;
import tn.esprit.dari.entities.DeliveryState;
import tn.esprit.dari.service.IDeliveryManService;
import tn.esprit.dari.service.IDeliveryService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private IDeliveryService deliveryService;

    @Autowired
    private IDeliveryManService deliveryManService;
//post requests

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<String> addDelivery(@RequestBody Delivery delivery) throws ParseException {
        delivery.setDeliveryState(DeliveryState.NOT_PICKED);
        delivery.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(delivery.getDateJson()));
        deliveryService.createDelivery(delivery);
        return new ResponseEntity<>("delivery added", HttpStatus.OK);

    }
    @PostMapping("/locate/{id}")
    @ResponseBody
    public ResponseEntity<String> updateDeliveryLocation(@PathVariable int id,@RequestParam double latitude,@RequestParam double longitude) {

        deliveryService.updateLocation(id,latitude,longitude);
        return new ResponseEntity<>("location updated!", HttpStatus.OK);

    }
    @PostMapping("/createdm")
    @ResponseBody
    public ResponseEntity<String> addDeliveryMan(@RequestBody DeliveryMan deliveryman){

        deliveryManService.addDM(deliveryman);
        return new ResponseEntity<>("delivery man created", HttpStatus.OK);

    }
    @GetMapping("/deletedm/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteDeliveryMan(@PathVariable Long id){

        deliveryManService.deleteDM(id);
        return new ResponseEntity<>("delivery man deleted", HttpStatus.OK);

    }

    @PostMapping("/deliverystate/{id}")
    @ResponseBody
    public ResponseEntity<String> changeDeliveryState(@PathVariable int id, @RequestParam int deliveryState){
         deliveryManService.changeDeliveryState(id,deliveryState);
        return new ResponseEntity<>("delivery state updated", HttpStatus.OK);
    }


    //get requests
    @GetMapping("/cancel/{id}")
    public ResponseEntity<String> cancelDelivery(@PathVariable int id){

        deliveryService.cancelDelivery(id);
        return new ResponseEntity<>("delivery canceled", HttpStatus.OK);
    }
    @GetMapping("/")
    public List<Delivery> deliveries(){

        return  deliveryService.deliveries();
    }
    @GetMapping("/deliveriescust/{id}")
    public List<Delivery> deliveriespercust(@PathVariable Long id){

        return  deliveryService.deliveriesbycust(id);
    }
    @GetMapping("/{id}")
    public Delivery deliverybyid(@PathVariable int id){

        return  deliveryService.deliveryById(id);
    }
    @GetMapping("/listdm")
    public List<DeliveryMan> listdm(){

        return  deliveryManService.listDM();
    }
    @GetMapping("/listperdm/{id}")
    public List<Delivery> deliveriesPerDM(@PathVariable Long id){

        return  deliveryManService.deliveriesPerDM(id);
    }


}
