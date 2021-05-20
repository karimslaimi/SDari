package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Buy;
import tn.esprit.dari.entities.Property;
import tn.esprit.dari.entities.Rent;
import tn.esprit.dari.repositories.RentRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentService implements IRent{

    @Autowired
    private RentRepository rr;

    @Override
    public float differenceBetwenPerDayAndMonth(float pricePerMonth,float pricePerDay)
    {
        return pricePerDay-(pricePerMonth/30);
    }

    @Override
    public float estimationForMeter() {
        List<Rent> lst = rr.findAll();
        float sum = 0;
        for (int i = 0; i < lst.size(); i++) {
            float one = lst.get(i).getPrix() / lst.get(i).getSurface();
            sum += one;
        }
        return sum / lst.size();
    }

    @Override
    public void updateRent(Rent rent) {
        Rent f= rr.findById(rent.getId_prop()).get();
        f.setPricePerDay(rent.getPricePerDay());
        f.setPricePerMonth(rent.getPricePerMonth());
        f.setAdress(rent.getAdress());
        f.setCity(rent.getCity());
        f.setNbrooms(rent.getNbrooms());
        f.setLoyer(rent.getLoyer());
        f.setPrix(rent.getPrix());
        f.setState(rent.getState());
        f.setStatus(rent.getStatus());
        f.setSuperficie(rent.getSuperficie());
        f.setSurface(rent.getSurface());
        f.setType(rent.getType());
        f.setZipCode(rent.getZipCode());
        rr.save(rent);
        }

    @Override
    public List<Integer> findAllRentPropertyId() {
        List<Rent> lsta = rr.findAll();
        List<Integer> lstPropertyidr = new ArrayList<>();
        for(int i=0;i<lsta.size();i++){
            lstPropertyidr.add(lsta.get(i).getId_prop());
        }
        return lstPropertyidr;
    }

    @Override
    public List<Rent> rentTri() {
        List<Rent> lstr=rr.findAll();
        Collections.sort(lstr);
        return lstr;
    }

    @Override
    public List<Rent> searchMultiCriteria(String filter, String adress,String state,String city,int id ){
        List<Rent> rents= rr.findAll();

        if(!filter.isEmpty()){
            rents=rents.stream().filter(x->x.getAdress().toLowerCase().contains(filter.toLowerCase())||
                    x.getState().toLowerCase().contains(filter.toLowerCase())||
                    x.getCity().toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
        }

        return rents;

    }

}



