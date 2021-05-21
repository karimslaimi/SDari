package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Property;
import tn.esprit.dari.entities.PropertyType;
import tn.esprit.dari.service.IProperty;
import tn.esprit.dari.service.PropertyService;

import java.util.List;

@RestController
@RequestMapping("/prop")

public class PropController {

    @Autowired
    private IProperty propS;
    @Autowired
    private PropertyService propser;
  //liste des prop
    @GetMapping("/properties")
    public List<Property> All() {
        return propS.Allproperties();
    }

 // ajout
    @PostMapping("/addprop/{id}")
    public void newProperty(@RequestBody Property newProperty,@PathVariable int id)
    {

        propS.addProperty(newProperty,id);
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
    @PutMapping("/propmodif")
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

//recherche par type
@GetMapping("/type")
public List<Property> rechparType(@RequestParam String proptype){

    return propser.rechByType(proptype);

}
    @PostMapping("/search")
    public List<Property> search(@RequestBody String filter){

        return propser.search(filter);

    }
}
