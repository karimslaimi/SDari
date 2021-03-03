package tn.esprit.dari.service;

import tn.esprit.dari.entities.Property;

import java.util.List;

public interface IProperty {

   public void addProperty(Property prop);
   public void updateProperty(Property prop);
   public void deleteProperty(int id);
   public List<Property> Allproperties();




}
