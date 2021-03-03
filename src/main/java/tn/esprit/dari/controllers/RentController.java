package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tn.esprit.dari.entities.Contract_Rent;
import tn.esprit.dari.entities.Rent;
import tn.esprit.dari.repositories.RentRepository;

import java.time.LocalDate;
import java.util.Date;

@Controller
public class RentController {

    @Autowired
    private RentRepository rr;

    public float DifferenceBetwenPerDayAndMonth(float pricePerMonth,float pricePerDay)
    {
        return pricePerDay-(pricePerMonth/30);
    }


}
