package tn.esprit.dari.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Furniture;

import tn.esprit.dari.service.IFurnitureService;

import java.util.List;

@RestController
@RequestMapping("/fur")
public class FunitureController {


    @Autowired
    private IFurnitureService furS;
    //liste des fur
    @GetMapping("/furniturs")
    public List<Furniture> All() {
        return furS.AllFurnitures();
    }

    // ajout
    @PostMapping("/addfur")
    public void newFurniture(@RequestBody Furniture newFurniture)
    {
        furS.addFurniture(newFurniture);
    }

    //une prop
    @GetMapping("/furget/{id}")
    public Furniture furget(@PathVariable("id") int id) {
        return furS.getfur(id);
    }
    //supp
    @DeleteMapping("/fursupp/{id}")
    public void deleteFurniture(@PathVariable("id") int id) {
        furS.deleteFurniture(id);
    }
    //update
    @PostMapping("/furmodif")
    @ResponseBody
    public void modify(@RequestBody Furniture fur)
    {
        furS.updateFurniture(fur);
    }






}
