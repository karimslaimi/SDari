package tn.esprit.dari.service;

import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.entities.Orders;

import java.util.List;

public interface IOrdersService {


    public void addOrder(Orders ord);
    public void deleteOrder(int id);
    public List<Orders> AllOrders();
    public Orders getorder(int id);
    public void commander(Long idCustomer,int idFur);
}
