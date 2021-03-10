package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.dari.entities.Buy;
import tn.esprit.dari.entities.Property;
import tn.esprit.dari.repositories.BuyRepository;
import tn.esprit.dari.repositories.DocRepository;

import java.util.List;

@RestController
@RequestMapping("/buy")
public class BuyController {

    @Autowired
    private BuyRepository br;
    @Autowired
    private DocRepository dr;

    @GetMapping("/get")
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
