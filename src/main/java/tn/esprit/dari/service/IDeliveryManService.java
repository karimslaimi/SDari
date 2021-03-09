package tn.esprit.dari.service;

import tn.esprit.dari.entities.DeliveryMan;

import java.util.List;

public interface IDeliveryManService {
    void addDM(DeliveryMan dm);
    void deleteDM(DeliveryMan dm);
    List<DeliveryMan> listDM();

}
