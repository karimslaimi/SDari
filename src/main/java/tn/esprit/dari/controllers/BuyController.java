package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Buy;
import tn.esprit.dari.entities.Property;
import tn.esprit.dari.repositories.BuyRepository;

import java.util.List;

@Controller
public class BuyController {

    @Autowired
    private BuyRepository br;

    public float pricePerMeter(float price, float surface)
    {
        return surface/price;
    }


    @GetMapping("/buy")
    public List<Buy> All() {
        return br.findAll();
    }


    @PostMapping("/AddBuy")
    public void newBuy(@RequestBody Buy newBuy)
    {
        br.save(newBuy);
    }


    @GetMapping("/buy/{id}")
    public Buy getBuy(@PathVariable int id) {
        return br.getOne(id);

    }

    @DeleteMapping("/buy/{id}")
    public void deleteBuy(@PathVariable int id) {
        br.deleteById(id);
    }



}
