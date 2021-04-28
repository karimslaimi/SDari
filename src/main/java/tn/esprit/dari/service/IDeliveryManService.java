package tn.esprit.dari.service;

import tn.esprit.dari.entities.Delivery;
import tn.esprit.dari.entities.DeliveryMan;
import tn.esprit.dari.entities.DeliveryState;

import java.util.List;

public interface IDeliveryManService {
    void addDM(DeliveryMan dm);
    void deleteDM(Long id);
    List<DeliveryMan> listDM();
    void changeDeliveryState(int id, int state);
    List<Delivery> deliveriesPerDM(Long id);

}
