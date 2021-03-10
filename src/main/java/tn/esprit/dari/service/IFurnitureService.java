package tn.esprit.dari.service;

import tn.esprit.dari.entities.Furniture;

import java.util.List;

public interface IFurnitureService {

    public void addFurniture(Furniture fur);
    public void updateFurniture(Furniture fur);
    public void deleteFurniture(int id);
    public List<Furniture> AllFurnitures();
    public Furniture getfur(int id);


}
