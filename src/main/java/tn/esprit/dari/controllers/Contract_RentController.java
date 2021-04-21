package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Contract_Buy;
import tn.esprit.dari.entities.Contract_Rent;
import tn.esprit.dari.repositories.Contract_buyRepository;
import tn.esprit.dari.repositories.Contract_rentRepository;

import java.util.List;

@RestController
@RequestMapping("/Contract_Rent")
public class Contract_RentController {

    @Autowired
    private Contract_rentRepository crr;

    @GetMapping("/get")
    public List<Contract_Rent> All() { return crr.findAll(); }

    @PostMapping("/Add")
    public void newBuy(@RequestBody Contract_Rent newBuy)
    {
        crr.save(newBuy);
    }

    @GetMapping("/getOne/{id}")
    public Contract_Rent getBuy(@PathVariable int id) {
        return crr.findById(id).get();
    }

    @DeleteMapping("/Delete/{id}")
    public void deleteBuy(@PathVariable int id) {
        crr.deleteById(id);
    }

}
