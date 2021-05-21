package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Detail_Panier;
import tn.esprit.dari.entities.Furniture;
import tn.esprit.dari.entities.Panier;
import tn.esprit.dari.service.IDetailPanierService;
import tn.esprit.dari.service.IFurnitureService;
import tn.esprit.dari.service.IPanierService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pan")

public class PanierController {
     @Autowired
    IDetailPanierService idp;
     @Autowired
     IPanierService panierService;
     @Autowired
     private IFurnitureService furnitureService;

    // ajout fur au panier
    @PostMapping("/addfurp/{idf}/{idc}")
    public void ajoutfurpanier(@PathVariable("idf") int idf, @PathVariable("idc") long idc)
    {
        //get basket by user id if there is not basket create one
        Panier p=panierService.getUserPanier(idc);
        Detail_Panier detail_panier=new Detail_Panier();
        detail_panier.setPanier(p);
        detail_panier.setFurs(furnitureService.getfur(idf));
        detail_panier.setDateAjout(new Date());
            panierService.AddDetailPanier(detail_panier);
    }

    @GetMapping("/getPanier/{idc}")
    public List<Furniture> getPanier(@PathVariable int idc){

        return panierService.getPanier(idc);
    }
    //supp
    @DeleteMapping("/fursupp/{idc}/{idf}")
    public void deletefurdupanier(@PathVariable("idc") int idc,@PathVariable("idf") int idf) {
        panierService.deletefurdupanier(idc,idf);
    }

}
