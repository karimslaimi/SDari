package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Property;
import tn.esprit.dari.repositories.PropertyRepository;

import java.util.List;




@Service
public class PropertyService implements IProperty {

    @Autowired
   private PropertyRepository PropRep ;

    @Override
    public void addProperty() {



    }

    @Override
    public void updateProperty(Property prop) {

    }


    @Override
    public void deleteProperty(int id) {

    }

    @Override
    public List<Property> Allproperties() {
        return null;
    }









}