package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.dari.entities.Buy;
import tn.esprit.dari.entities.Rent;
import tn.esprit.dari.repositories.BuyRepository;

import java.util.List;

public class BuyService implements IBuy {

    @Autowired
    private BuyRepository br;

    @Override
    public float pricePerMeter(float price, float surface)
    {
        return surface/price;
    }
    @Override
    public float EstimationForMeter() {
        List<Buy> lst=br.findAll();
        float sum=0;
        for(int i=0; i<lst.size();i++)
        {
            float one =lst.get(i).getPrix()/ lst.get(i).getSurface();
            sum+=one;
        }
        return sum/lst.size();
    }
}
