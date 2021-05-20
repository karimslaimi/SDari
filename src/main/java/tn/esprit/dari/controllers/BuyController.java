package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Buy;
import tn.esprit.dari.repositories.BuyRepository;
import tn.esprit.dari.service.BuyService;

import javax.servlet.http.HttpServletRequest;
import java.time.format.DateTimeFormatter;
import java.util.List;



@RestController
@RequestMapping( "/buy")
public class BuyController {
    @Autowired
    private BuyRepository br;
    @Autowired
    private BuyService bs;

    @GetMapping("/get")
    public List<Buy> All() {
        return br.findAll();
    }

    @PostMapping("/AddBuy")
    public void newBuy(@RequestBody Buy newBuy)
    {
        br.save(newBuy);
    }

    @GetMapping("/getOne/{id}")
    public Buy getBuy(@PathVariable int id) {
        return br.findById(id).get();
    }

    @DeleteMapping("/Delete/{id}")
    public void deleteBuy(@PathVariable int id) {
        br.deleteById(id);
    }

    @GetMapping("/Estimate/{state}")
    public float  est(@PathVariable String state){return bs.EstimationForMeter(state);}

    @PutMapping("/put")
    @ResponseBody
    public void modify(@RequestBody Buy buy) {bs.updateBuy(buy);}

    @GetMapping("/Tri")
    public List<Buy> Tri(){return bs.buyTri();}


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
        return new ResponseEntity<> (bs.searchMultiCriteria(filter,adress,state,city,id ), HttpStatus.OK);


    }





}
