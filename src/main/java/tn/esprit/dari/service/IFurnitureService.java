package tn.esprit.dari.service;

import tn.esprit.dari.entities.Furniture;
import tn.esprit.dari.entities.FurnitureType;
import tn.esprit.dari.entities.Property;
import tn.esprit.dari.entities.PropertyType;

import java.util.List;

public interface IFurnitureService {

    public void addFurniture(Furniture fur,long id);
    public void updateFurniture(Furniture fur);
    public void deleteFurniture(int id);
    public List<Furniture> AllFurnitures();
    public Furniture getfur(int id);
    public List<Furniture> rechparType(String furtype);
    public List<Furniture> search(String filter);
    public  List<Furniture> getMyFurn(long id);


}
