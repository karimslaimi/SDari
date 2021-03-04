package tn.esprit.dari.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Reclamation;
import tn.esprit.dari.service.IReclamationService;
import tn.esprit.dari.service.ReclamationService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("reclamation")
public class ReclamationController {

    @Autowired
    private IReclamationService reclamationService;



    @PostMapping("/add/{id}")
    public ResponseEntity<?> AddReclam(@RequestBody Reclamation reclamation, @PathVariable int id){

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
        //u have to check the way you are calling this method becayse the id is in the path and the treat
        //is in the body of the request don't make a mistake in this one

        reclamationService.treat(id,treat);
        return new ResponseEntity<>("treated", HttpStatus.OK);

    }

    @GetMapping("/{id]")
    public ResponseEntity<?> getOne(@PathVariable int id){
        Reclamation reclam=reclamationService.getOne(id);
        if(reclam!=null){
            return new ResponseEntity<>(reclam,HttpStatus.OK);
        }
        return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){

        return new ResponseEntity<>(reclamationService.findAll(),HttpStatus.OK);

    }

    @GetMapping("/notTreated")
    public ResponseEntity<?> findNotTreated(){
        return new ResponseEntity<>(reclamationService.findNotTreated(),HttpStatus.OK);
    }


    @GetMapping("/myReclam")
    public ResponseEntity<?> MyReclam(int id){
        return  new ResponseEntity<>(reclamationService.findMyReclam(id),HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> FilterReclam(@RequestBody String filter){

        return new ResponseEntity<>(reclamationService.filter(filter),HttpStatus.OK);

    }

    @GetMapping("/between")
    public ResponseEntity<?> findBetweenDate(@RequestBody LocalDateTime start,@RequestBody LocalDateTime end){
        return new ResponseEntity<>(reclamationService.findBetweenDate(start,end),HttpStatus.OK);
    }

    @GetMapping("/type")
    public ResponseEntity<?> findByType(@RequestBody String type){

        return new ResponseEntity<>(reclamationService.findByType(type),HttpStatus.OK);

    }

}
