package tn.esprit.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tn.esprit.dari.repositories.BuyRepository;

@Controller
public class BuyController {

    @Autowired
    private BuyRepository br;

    public float pricePerMeter(float price, float surface)
    {
        return surface/price;
    }

}
