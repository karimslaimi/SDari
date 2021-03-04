package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.dto.RegisterRequest;
import tn.esprit.dari.entities.Agent;
import tn.esprit.dari.entities.Appointment;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.repositories.AppointmentRepository;
import tn.esprit.dari.repositories.UtilisateurRepository;
import tn.esprit.dari.service.AppointmentService;
import tn.esprit.dari.service.State;

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

        return new ResponseEntity<>("Customer Registration succeed", HttpStatus.OK);

    }

    @GetMapping("/listApp/{id}")
    public List<Appointment> ownerAppointments(@PathVariable("id") Long id){

          return  app_service.ownerAppointments(id);
    }

}
