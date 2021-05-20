package tn.esprit.dari.service;

import tn.esprit.dari.entities.Buy;
import tn.esprit.dari.entities.Furniture;
import tn.esprit.dari.entities.Rent;

import java.util.List;

public interface IBuy {
    float pricePerMeter(float price, float surface);
    float EstimationForMeter(String state);
    void updateBuy(Buy buy);
    List<Integer> findAllBuyPropertyId();
    List<Buy> buyTri();
    List<Buy> searchMultiCriteria(String filter,String adress,String state,String city, int id );
}
