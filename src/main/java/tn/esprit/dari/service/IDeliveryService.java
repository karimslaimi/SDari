package tn.esprit.dari.service;

import tn.esprit.dari.entities.Delivery;

import java.util.List;

public interface IDeliveryService {
    List<Delivery> deliveries();
    void createDelivery(Delivery delivery);
    void cancelDelivery(int id);
    Delivery deliveryById(int id);
    void updateLocation(int id,double latitude,double longitude);
    List<Delivery> deliveriesbycust(Long id);


}
