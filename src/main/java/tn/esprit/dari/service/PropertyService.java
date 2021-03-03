package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Property;

import tn.esprit.dari.repositories.PropertyRepository;

import java.util.List;
import java.util.Optional;


@Service
public class PropertyService implements IProperty {

    @Autowired
   private PropertyRepository proprep ;

    @Override
    public void addProperty(Property prop) {



    }

    @Override
    public void updateProperty(Property prop) {

    }


    @Override
    public void deleteProperty(int id) {
        proprep.deleteById(id);
    }


    @Override
    public List<Property> Allproperties() {


    List<Property> props = (List<Property>) proprep.findAll();
        props.stream().map(prop -> "properties    : " + prop).forEach(System.out::println);

        return props;

    }

    @Override
    public Optional<Property> getprop(String id) {
        return proprep.findById(Integer.valueOf(id));
    }




}

