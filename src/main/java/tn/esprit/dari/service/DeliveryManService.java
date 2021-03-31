package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Delivery;
import tn.esprit.dari.entities.DeliveryMan;
import tn.esprit.dari.entities.DeliveryState;
import tn.esprit.dari.repositories.DeliveryManRepository;
import tn.esprit.dari.repositories.DeliveryRepository;

import java.util.List;
@Service
public class DeliveryManService implements IDeliveryManService {
    @Autowired
    private DeliveryManRepository dms;
    @Autowired
    private DeliveryRepository ds;

    @Override
    public void addDM(DeliveryMan dm) {
        dms.save(dm);
    }

    @Override
    public void deleteDM(Long id) {
dms.delete(dms.getOne(id));
    }

    @Override
    public List<DeliveryMan> listDM() {
        return dms.findAll();
    }

    @Override
    public void changeDeliveryState(int id, DeliveryState state) {
        Delivery delivery=ds.getOne(id);
        delivery.setDeliveryState(state);
        ds.save(delivery);
    }

    @Override
    public List<Delivery> deliveriesPerDM(Long id) {
        return dms.getOne(id).getDeliveryList();
    }


}
