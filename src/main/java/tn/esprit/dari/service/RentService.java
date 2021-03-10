package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.dari.entities.Property;
import tn.esprit.dari.entities.Rent;
import tn.esprit.dari.repositories.RentRepository;

import java.util.List;

public class RentService implements IRent{

    @Autowired
    private RentRepository rr;

    @Override
    public float DifferenceBetwenPerDayAndMonth(float pricePerMonth,float pricePerDay)
    {
        return pricePerDay-(pricePerMonth/30);
    }

    @Override
    public float EstimationForMeter() {
        List<Rent> lst=rr.findAll();
        float sum=0;
        for(int i=0; i<lst.size();i++)
      {
          float one =lst.get(i).getPrix()/ lst.get(i).getSurface();
          sum+=one;
      }
      return sum/lst.size();
    }


}
