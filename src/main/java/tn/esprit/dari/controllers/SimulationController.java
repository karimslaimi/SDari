package tn.esprit.dari.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.service.ISimulation;

@RestController
@RequestMapping("/Simulation")
public class SimulationController {

    @Autowired
    ISimulation simulation ;

    @GetMapping("/mensualiteSA/{montantCredit}/{taux_period}/{duree}")
    public double MensualiteSA(@PathVariable double montantCredit,@PathVariable float taux_period,@PathVariable long duree){
        return (simulation.CalculMensualiteSA(montantCredit,taux_period,duree));


    }

    @GetMapping("/assurance/{taux}/{montant}")
    public double Assurance(@PathVariable double taux ,@PathVariable double montant){
        return ( simulation.MontantAssurance(taux, montant));
    }
    @GetMapping("/mensualiteAA/{montantCredit}/{taux_period}/{duree}/{assurance}")
    public double MensualiteAA(@PathVariable double montantCredit,@PathVariable float taux_period,@PathVariable long duree, @PathVariable float assurance){
        return (simulation.CalculMensualiteAA(montantCredit , taux_period , duree ,assurance));

    }

    @GetMapping("/Total/{montantCredit}/{duree}/{interet}/{assurance}/{frais}")
    public double Total (@PathVariable double montantCredit,@PathVariable long duree , @PathVariable  float interet,@PathVariable double assurance, @PathVariable double frais){
        return ( simulation.CreditTotal(montantCredit, duree, interet, assurance, frais));


    }








}
