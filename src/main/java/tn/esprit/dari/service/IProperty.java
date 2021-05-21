package tn.esprit.dari.service;

import tn.esprit.dari.entities.Property;
import tn.esprit.dari.entities.PropertyType;
import tn.esprit.dari.entities.Reclamation;

import java.util.List;

public interface IProperty {

   public void addProperty(Property prop,int id);
   public void updateProperty(Property prop);
   public void deleteProperty(int id);
   public List<Property> Allproperties();
   public Property getprop(int id);
   public  List<Property> userproperties(Long id);
   public List<Property> rechByType(String proptype);
   public List<Property> search(String filter);




}
