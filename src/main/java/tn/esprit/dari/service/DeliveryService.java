package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Delivery;
import tn.esprit.dari.entities.Notification;
import tn.esprit.dari.repositories.DeliveryManRepository;
import tn.esprit.dari.repositories.DeliveryRepository;
import tn.esprit.dari.repositories.OrdersRepository;

import java.util.Date;
import java.util.List;
@Service
public class DeliveryService implements IDeliveryService {

    @Autowired
    private DeliveryManRepository dmr;
    @Autowired
    private DeliveryRepository dr;
    @Autowired
    private INotificationService ns;
    @Autowired
    private OrdersRepository ordrep ;
    @Override
    public List<Delivery> deliveries() {
        return dr.findAll();
    }
    @Override
    public List<Delivery> deliveriesbycust(Long id) {
        return dr.deliveriesBycust(id);
    }

    @Override
    public void createDelivery(Delivery delivery) {
delivery.setOrder(ordrep.getOne(delivery.getOrderId()));
 delivery.setDeliveryMan(dmr.getOne(delivery.getDeliverymanId()));
        dr.save(delivery);
        //delivery man notification
        ns.Notify(delivery.getDeliveryMan(),new Date(),"New delivery assigned!","You have a new delivery assigned for "+delivery.getDate()+", check your deliveries for more information.");
            //customer notification to do
    }

    @Override
    public void cancelDelivery(int id) {

   Delivery delivery=dr.getOne(id);
    dr.delete(delivery);
    //delivery man notification
        ns.Notify(delivery.getDeliveryMan(),new Date(),"Delivery canceled!","Your delivery for "+delivery.getDate()+" has been canceled, check your deliveries for more information.");
//customer notification

    }

    @Override
    public Delivery deliveryById(int id) {
        return dr.getOne(id);
    }

    @Override
    public void updateLocation(int id, double latitude, double longitude) {

        Delivery delivery=dr.getOne(id);
        delivery.setLatitude(latitude);
        delivery.setLongitude(longitude);
        dr.save(delivery);
        //possible notification control for later
    }

}
