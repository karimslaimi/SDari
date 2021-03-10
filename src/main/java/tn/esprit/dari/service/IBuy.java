package tn.esprit.dari.service;

import tn.esprit.dari.entities.Rent;

import java.util.List;

public interface IBuy {
    float pricePerMeter(float price, float surface);
    float EstimationForMeter();

}
