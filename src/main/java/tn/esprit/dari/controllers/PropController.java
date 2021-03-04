package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Property;
import tn.esprit.dari.service.PropertyService;

import java.util.List;

@RestController
@RequestMapping("/prop")

public class PropController {

    @Autowired
    private PropertyService propS;


  //liste des prop
    @GetMapping("/properties")
    public List<Property> All() {
        return propS.Allproperties();
    }

 // ajout
    @PostMapping("/AddProp")
    public void newProperty(@RequestBody Property newProperty)
    {
        propS.addProperty(newProperty);
    }

//une prop
    @GetMapping("/properties/{id}")
    public Property getprop(@PathVariable int id) {
        return propS.getprop(id);

    }
//supp

    @DeleteMapping("/properties/{id}")
    public void deleteProperty(@PathVariable int id) {
        propS.deleteProperty(id);
    }


}
