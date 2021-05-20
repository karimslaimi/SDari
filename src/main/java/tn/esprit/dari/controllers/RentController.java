package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Buy;
import tn.esprit.dari.entities.Contract_Rent;
import tn.esprit.dari.entities.Rent;
import tn.esprit.dari.repositories.PropertyRepository;
import tn.esprit.dari.repositories.RentRepository;
import tn.esprit.dari.service.RentService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rent")
public class RentController {

    @Autowired
    private RentRepository rr;
    @Autowired
    private RentService rs;

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

    @GetMapping("/Estimate")
    public float  est(){return rs.estimationForMeter();}

    @PutMapping("/put")
    @ResponseBody
    public void modifyr(@RequestBody Rent rent) {rs.updateRent(rent);}
    @GetMapping("/Tri")
    public List<Rent> Tri(){return rs.rentTri();}

    @GetMapping("/searchmulti")
    public ResponseEntity<?> searchMulti(HttpServletRequest request){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        String filter="";
        String adress="";
        String city="";
        String state="";
        int id=0;
        if(request.getParameter("filter")!=null){
            filter=request.getParameter("filter");

        }
        if(request.getParameter("adress")!=null){
            adress=request.getParameter("adress");

        }

        if(request.getParameter("state")!=null){
            state=request.getParameter("state");

        }

        if(request.getParameter("city")!=null){
            city=request.getParameter("city");

        }
        return new ResponseEntity<> (rs.searchMultiCriteria(filter,adress,state,city,id ), HttpStatus.OK);


    }
}
