package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Property;

import tn.esprit.dari.repositories.PropertyRepository;

import javax.el.PropertyNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public class PropertyService implements IProperty {

    @Autowired
   private PropertyRepository proprep ;

    @Override
    public void addProperty(Property prop) {
    proprep.save(prop);
    }

    @Override
    public void updateProperty(Property prop) {
        Property p= proprep.findById(prop.getId_prop()).get();
        p.setImage(prop.getImage());



        proprep.save(prop);
    }

    @Override
    public void deleteProperty(int id) {
        proprep.deleteById(id);
    }

    @Override
    public List<Property> Allproperties() {

    List<Property> props = (List<Property>) proprep.findAll();

        return props;

    }

    @Override
    public Property getprop(int id) {
        return proprep.findById(id).orElseThrow(() -> new PropertyNotFoundException(String.valueOf(id)));
    }




}

