package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Detail_Panier;
import tn.esprit.dari.entities.Orders;
import tn.esprit.dari.service.IDetailPanierService;

@RestController
@RequestMapping("/pan")

public class PanierController {
     @Autowired
    IDetailPanierService idp;
    // ajout fur au panier
    @PostMapping("/addfurp")
    public void ajoutfurpanier(@RequestBody Detail_Panier dp)
    {
        idp.ajouterfuraupanier(dp);
    }

    //supp
    @DeleteMapping("/fursupp/{id}")
    public void deletefurdupanier(@PathVariable("id") int id) {
        idp.deletefurdupanier(id);
    }

}
