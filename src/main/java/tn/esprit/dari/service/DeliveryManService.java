package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.dari.entities.DeliveryMan;
import tn.esprit.dari.repositories.DeliveryManRepository;

import java.util.List;

public class DeliveryManService implements IDeliveryManService {
    @Autowired
    private DeliveryManRepository dms;

    @Override
    public void addDM(DeliveryMan dm) {
        dms.save(dm);
    }

    @Override
    public void deleteDM(DeliveryMan dm) {
dms.delete(dm);
    }

    @Override
    public List<DeliveryMan> listDM() {
        return dms.findAll();
    }


}
