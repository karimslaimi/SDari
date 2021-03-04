package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Buy;
import tn.esprit.dari.entities.Contract_Rent;
import tn.esprit.dari.entities.Rent;
import tn.esprit.dari.repositories.PropertyRepository;
import tn.esprit.dari.repositories.RentRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rent")
public class RentController {

    @Autowired
    private RentRepository rr;

    public float DifferenceBetwenPerDayAndMonth(float pricePerMonth,float pricePerDay)
    {
        return pricePerDay-(pricePerMonth/30);
    }

    @GetMapping("/get")
    public List<Rent> All() {
        return rr.findAll();
    }

    @PostMapping("/AddRent")
    public void newRent(@RequestBody Rent newRent)
    {
        rr.save(newRent);
    }

    @GetMapping("/getone/{id}")
    public Rent getRent(@PathVariable int id) {
        return rr.findById(id).get();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRent(@PathVariable int id) {
        rr.deleteById(id);
    }

}
