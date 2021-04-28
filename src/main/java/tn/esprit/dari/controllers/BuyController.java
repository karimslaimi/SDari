package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.dari.entities.Buy;
import tn.esprit.dari.entities.Property;
import tn.esprit.dari.entities.Rent;
import tn.esprit.dari.repositories.BuyRepository;
import tn.esprit.dari.repositories.DocRepository;
import tn.esprit.dari.service.BuyService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/buy")
public class BuyController {

    @Autowired
    private BuyRepository br;
    @Autowired
    private BuyService bs;

    @GetMapping("/get")
    public List<Buy> All() {
        return br.findAll();
    }

    @PostMapping(value="/AddBuy",consumes={"application/json"})

    public void newBuy(@RequestBody Buy newRent)
    {
        br.save(newRent);
    }

    @GetMapping("/getOne/{id}")
    public Buy getBuy(@PathVariable int id) {
        return br.findById(id).get();
    }

    @DeleteMapping("/Delete/{id}")
    public void deleteBuy(@PathVariable int id) {
        br.deleteById(id);
    }

    @GetMapping("/Estimate")
    public float  est(){return bs.EstimationForMeter();}





}
