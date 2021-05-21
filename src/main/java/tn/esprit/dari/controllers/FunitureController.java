package tn.esprit.dari.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Furniture;


import tn.esprit.dari.entities.Property;
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
    @PostMapping("/addfur/{id}")
    public void newFurniture(@RequestBody Furniture newFurniture,@PathVariable int id)
    {
        furS.addFurniture(newFurniture,id);
    }

    //un meuble
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
    @PutMapping("/furmodif")
    @ResponseBody
    public void modify(@RequestBody Furniture fur)
    {
        furS.updateFurniture(fur);
    }

    //recherche par type
    @GetMapping("/type")
    public List<Furniture> rechparType(@RequestBody String furtype){

        return furS.rechparType(furtype);


    }
    @GetMapping("/myfurn/{id}")
    public  List<Furniture> myfurn(@PathVariable long id){

        return  furS.getMyFurn(id);

    }
    @PostMapping("/search")
    public List<Furniture> search(@RequestBody String filter){

        return furS.search(filter);

    }


}
