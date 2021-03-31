package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.entities.Furniture;
import tn.esprit.dari.entities.Orders;
import tn.esprit.dari.repositories.CustomerRepository;
import tn.esprit.dari.repositories.FurnitureRepository;
import tn.esprit.dari.repositories.OrdersRepository;

import java.util.List;

@Service
public class OrdersService implements IOrdersService{
   @Autowired
   private CustomerRepository custrep ;

    @Autowired
    private OrdersRepository ordrep ;
    @Autowired
    private FurnitureRepository furrep ;

    @Override
    public void addOrder(Orders ord) {
        ordrep.save(ord);
    }

    @Override
    public void deleteOrder(int id) {
        ordrep.deleteById(id);
    }

    @Override
    public List<Orders> AllOrders() {
        List<Orders> ords = (List<Orders>) ordrep.findAll();
        return ords;

    }

    @Override
    public Orders getorder(int id) {
        return ordrep.findById(id).orElse(null);
    }

    @Override
    public void commander(Long idCustomer, int idFur) {
        Customer customer= custrep.findById(idCustomer).orElse(null);
        Furniture furniture= furrep.findById(idFur).orElse(null);



    }






}
