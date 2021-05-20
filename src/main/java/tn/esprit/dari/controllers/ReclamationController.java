package tn.esprit.dari.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Reclamation;
import tn.esprit.dari.service.IReclamationService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("reclamation")
public class ReclamationController {

    @Autowired
    private IReclamationService reclamationService;



    @PostMapping("/add/{id}")
    public ResponseEntity<?> AddReclam(@RequestBody Reclamation reclamation, @PathVariable Long id){

        if(!reclamationService.Create(reclamation,id)){
            return new ResponseEntity<>("could not create the claim", HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>("claim created",HttpStatus.CREATED);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteReclam(@PathVariable int id){
        reclamationService.Delete(id);
        return new ResponseEntity<>("deleted claim",HttpStatus.OK);
    }

    @PutMapping("/treat/{id}")
    public ResponseEntity<?> treatReclam(@RequestBody String treat,@PathVariable int id){
        //the string represent the response for the claim and the id represent the claim id
        //u have to check the way you are calling this method because the id is in the path and the treat
        //is in the body of the request don't make a mistake in this one

        if(reclamationService.treat(id,treat))
        return new ResponseEntity<>("treated", HttpStatus.OK);

        else
            return new ResponseEntity<>("error occured", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable int id){
        Reclamation reclam=reclamationService.getOne(id);
        if(reclam!=null){
            return new ResponseEntity<>(reclam,HttpStatus.OK);
        }
        return new ResponseEntity<>("not found",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){

        return new ResponseEntity<>(reclamationService.findAll(),HttpStatus.OK);

    }

    @GetMapping("/notTreated")
    public ResponseEntity<?> findNotTreated(){
        return new ResponseEntity<>(reclamationService.findNotTreated(),HttpStatus.OK);
    }


    @GetMapping("/myReclam/{id}")
    public ResponseEntity<?> MyReclam(@PathVariable int id){
        List<Reclamation> reclams=reclamationService.findMyReclam(id);
        return  new ResponseEntity<>(reclams,HttpStatus.OK);
    }

    @PostMapping("/filter")
    public ResponseEntity<?> FilterReclam(@RequestBody String filter){

        return new ResponseEntity<>(reclamationService.filter(filter),HttpStatus.OK);

    }

    @GetMapping("/between")
    public ResponseEntity<?> findBetweenDate(@RequestParam String start,@RequestParam String end){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime s = LocalDateTime.parse(start, formatter);
        LocalDateTime e = LocalDateTime.parse(end, formatter);


        List<Reclamation> reclamations=reclamationService.findBetweenDate(s,e);
        return new ResponseEntity<>(reclamations,HttpStatus.OK);
    }

    @GetMapping("/type")
    public ResponseEntity<?> findByType(@RequestParam String type){

        return new ResponseEntity<>(reclamationService.findByType(type),HttpStatus.OK);

    }

    @GetMapping("/searchmulti")
    public ResponseEntity<?> searchMulti(HttpServletRequest request){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        String filter="";
        String type="";
        boolean mine=false;
        LocalDateTime start=LocalDateTime.parse("2013-12-31 00:00",formatter);
        LocalDateTime end=LocalDateTime.parse("2030-12-31 00:00",formatter);;
        boolean treated=false;
        int id=0;
        if(request.getParameter("filter")!=null){
            filter=request.getParameter("filter");

        }
        if(request.getParameter("type")!=null){
            type=request.getParameter("type");

        }if(request.getParameter("mine")!=null && request.getParameter("id")!=null){
            mine=Boolean.parseBoolean(request.getParameter("mine"));
            id=Integer.parseInt(request.getParameter("id"));

        }
        if(request.getParameter("start")!=null){
            start = LocalDateTime.parse(request.getParameter("start"), formatter);



        }
        if(request.getParameter("end")!=null){
            end = LocalDateTime.parse(request.getParameter("end"), formatter);
        }

        if(request.getParameter("treated")!=null){
            treated=Boolean.parseBoolean(request.getParameter("treated"));

        }

        return new ResponseEntity<> (reclamationService.searchMultiCriteria(filter,type,mine,start,end,treated,id),HttpStatus.OK);


    }

}
