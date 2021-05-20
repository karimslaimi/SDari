package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Contract_Buy;
import tn.esprit.dari.repositories.Contract_buyRepository;
import tn.esprit.dari.service.BuyService;
import tn.esprit.dari.service.Contract_buyService;
import tn.esprit.dari.service.UtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/Contract_Buy")
public class Contract_BuyController {
    @Autowired
    private Contract_buyRepository cbr;
    @Autowired
    private Contract_buyService cbs;
    @Autowired
    private UtilisateurService us;
    @Autowired
    private BuyService bs;

    @GetMapping("/get")
    public List<Contract_Buy> All() { return cbr.findAll(); }

    @PostMapping("/Add")
    public void newBuy(@RequestBody Contract_Buy contractBuy)
    {
        cbr.save(contractBuy);
    }

    @GetMapping("/getOne/{id_user}/{id_property}")
    public Contract_Buy getBuy(@PathVariable int id_user,@PathVariable int id_property) { return cbs.findByDid(id_user,id_property); }

    @DeleteMapping("/Delete/{id_user}/{id_property}")
    public void deleteBuy(@PathVariable int id_user,@PathVariable int id_property) {
        cbr.delete(cbs.findByDid(id_user,id_property));
    }

    @PutMapping("/put")
    @ResponseBody
    public void modify(@RequestBody Contract_Buy contract_buy) {cbs.updateContractBuy(contract_buy);}

    @GetMapping("/getIdUser")
    public List<Long> AllUserId() { return us.findAllUserId(); }

    @GetMapping("/getIdPropertyBuy")
    public List<Integer> AllBuyPropertyId() { return bs.findAllBuyPropertyId(); }


}
