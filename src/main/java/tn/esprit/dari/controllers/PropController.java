package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Property;
import tn.esprit.dari.service.IProperty;
import tn.esprit.dari.service.PropertyService;

import java.util.List;

@RestController
@RequestMapping("/prop")

public class PropController {

    @Autowired
    private IProperty propS;
  //liste des prop
    @GetMapping("/properties")
    public List<Property> All() {
        return propS.Allproperties();
    }

 // ajout
    @PostMapping("/addprop")
    public void newProperty(@RequestBody Property newProperty)
    {
        propS.addProperty(newProperty);
    }

//une prop
    @GetMapping("/propget/{id}")
    public Property getprop(@PathVariable("id") int id) {
        return propS.getprop(id);
    }
//supp
    @DeleteMapping("/propsupp/{id}")
    public void deleteProperty(@PathVariable("id") int id) {
        propS.deleteProperty(id);
    }
//update
    @PostMapping("/propmodif")
    @ResponseBody
    public void modify(@RequestBody Property prop)
    {
        propS.updateProperty(prop);
    }

 //listedespropduuser
 @GetMapping("/userprops/{id}")
 public List<Property> userprops(@PathVariable("id") long id) {
     return propS.userproperties(id);
 }



}
