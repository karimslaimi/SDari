package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Appointment;
import tn.esprit.dari.service.AppointmentService;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService app_service;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<String> requestAppointment(@RequestBody Appointment appointment){

         app_service.requestAppointment(appointment);

        return new ResponseEntity<>("Request sent", HttpStatus.OK);

    }


    @PostMapping("/accept/{id}")
    @ResponseBody
    public ResponseEntity<String> acceptAppointment(@PathVariable("id") int id,@RequestParam String date,@RequestParam String address,@RequestParam int apptype){

        try {
            app_service.acceptAppointment(id,date,apptype,address);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Appointment accepted", HttpStatus.OK);

    }
    @GetMapping("/listAppOwner/{id}")
    public List<Appointment> ownerAppointments(@PathVariable("id") Long id){

          return  app_service.ownerAppointments(id);
    }
    @GetMapping("/listAppCustomer/{id}")
    public List<Appointment> customerAppointments(@PathVariable("id") Long id){

        return  app_service.customerAppointments(id);
    }
    @GetMapping("/cancelApp/{id}")
    @ResponseBody
    public ResponseEntity<String> cancelAppointments(@PathVariable("id") int id){

        app_service.cancelAppointment(id);
        return new ResponseEntity<>("Appointment canceled", HttpStatus.OK);

    }


    @PostMapping ("/Modify/{id}")
    @ResponseBody
    public ResponseEntity<String> modify( @PathVariable("id")  int id , @RequestBody Appointment su){

        app_service.modifyAppointment(id, su );
        return new ResponseEntity<>("Appointment modified", HttpStatus.OK);
    }


}
