package tn.esprit.dari.service;

import tn.esprit.dari.entities.Furniture;
import tn.esprit.dari.entities.Orders;

import java.util.List;

public interface IOrdersService {


    public void addOrder(int idp);
    public void deleteOrder(int id);
    public List<Orders> AllOrders(int idc);
    public Orders getorder(int id);
    public void commander(Orders ords);
    public List<Orders> listecommandesuser(Long idc);
    public  List<Furniture> ordFurn(int id);


}
