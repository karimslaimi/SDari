package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Contract_Buy;
import tn.esprit.dari.entities.Contract_Rent;
import tn.esprit.dari.repositories.Contract_buyRepository;
import tn.esprit.dari.repositories.Contract_rentRepository;
import tn.esprit.dari.service.Contract_rentService;

import java.util.List;

@RestController
@RequestMapping("/Contract_Rent")
public class Contract_RentController {

    @Autowired
    private Contract_rentRepository crr;
    @Autowired
    private Contract_rentService crs;

    @GetMapping("/get")
    public List<Contract_Rent> All() { return crr.findAll(); }

    @PostMapping("/Add")
    public void newBuy(@RequestBody Contract_Rent newBuy)
    {
        crr.save(newBuy);
    }

    @GetMapping("/getOne/{id}")
    public Contract_Rent getRent(@PathVariable long id_user,@PathVariable int id_property) { return crs.findByDid(id_user, id_property); }

    @DeleteMapping("/Delete/{id}")
    public void deleteBuy(@PathVariable long id_user,@PathVariable int id_property) {
        crs.deleteByDid(id_user,id_property);
    }

}
