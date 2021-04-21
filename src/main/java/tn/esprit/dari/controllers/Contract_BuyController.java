package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Buy;
import tn.esprit.dari.entities.Contract_Buy;
import tn.esprit.dari.repositories.Contract_buyRepository;
import tn.esprit.dari.service.Contract_buyService;

import java.util.List;

@RestController
@RequestMapping("/Contract_Buy")
public class Contract_BuyController {
    @Autowired
    private Contract_buyRepository cbr;
    @Autowired
    private Contract_buyService cbs;

    @GetMapping("/get")
    public List<Contract_Buy> All() { return cbr.findAll(); }

    @PostMapping("/Add")
    public void newBuy(@RequestBody Contract_Buy newBuy)
    {
        cbr.save(newBuy);
    }

    @GetMapping("/getOne/{id}")
    public Contract_Buy getBuy(@PathVariable long id_user,@PathVariable int id_property) { return cbs.findByDid(id_user,id_property); }

    @DeleteMapping("/Delete/{id}")
    public void deleteBuy(@PathVariable long id_user,@PathVariable int id_property) { cbs.deleteByDid(id_user,id_property); }

}
