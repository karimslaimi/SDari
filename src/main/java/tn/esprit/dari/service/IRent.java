package tn.esprit.dari.service;

import tn.esprit.dari.entities.Buy;
import tn.esprit.dari.entities.Rent;

import java.util.List;

public interface IRent {
    float differenceBetwenPerDayAndMonth(float pricePerMonth,float pricePerDay);
    float estimationForMeter();
    void updateRent(Rent rent);
    List<Integer> findAllRentPropertyId();
    List<Rent> rentTri();
    List<Rent> searchMultiCriteria(String filter,String adress,String state,String city, int id );
}
