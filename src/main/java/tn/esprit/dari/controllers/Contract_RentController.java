package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Contract_Buy;
import tn.esprit.dari.entities.Contract_Rent;
import tn.esprit.dari.repositories.Contract_buyRepository;
import tn.esprit.dari.repositories.Contract_rentRepository;
import tn.esprit.dari.service.Contract_rentService;
import tn.esprit.dari.service.RentService;
import tn.esprit.dari.service.UtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/Contract_Rent")
public class Contract_RentController {

    @Autowired
    private UtilisateurService us;
    @Autowired
    private Contract_rentRepository crr;
    @Autowired
    private Contract_rentService crs;
    @Autowired
    private RentService rs;

    @GetMapping("/get")
    public List<Contract_Rent> All() { return crr.findAll(); }

    @PostMapping("/Add")
    public void newBuy(@RequestBody Contract_Rent newBuy)
    {
        crr.save(newBuy);
    }

    @GetMapping("/getOne/{id_user}/{id_property}")
    public Contract_Rent getRent(@PathVariable int id_user,@PathVariable int id_property) { return crs.findByDid(id_user, id_property); }

    @DeleteMapping("/Delete/{id_user}/{id_property}")
    public void deleteBuy(@PathVariable int id_user,@PathVariable int id_property) {
        crr.delete(crs.findByDid(id_user,id_property));
    }
    @PutMapping("/put")
    @ResponseBody
    public void modify(@RequestBody Contract_Rent contract_rent) {crs.updateContractRent(contract_rent);}





    @GetMapping("/getIdUser")
    public List<Long> AllUserId() { return us.findAllUserId(); }

    @GetMapping("/getIdPropertyRent")
    public List<Integer> AllRentPropertyId() { return rs.findAllRentPropertyId(); }


}
