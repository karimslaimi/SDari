package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.entities.Property;
import tn.esprit.dari.entities.PropertyType;
import tn.esprit.dari.entities.Utilisateur;
import tn.esprit.dari.repositories.CustomerRepository;
import tn.esprit.dari.repositories.PropertyRepository;
import tn.esprit.dari.repositories.UtilisateurRepository;

import javax.el.PropertyNotFoundException;
import java.util.List;


@Service
public class PropertyService implements IProperty {

    @Autowired
   private PropertyRepository proprep ;
    @Autowired
    private CustomerRepository custrep ;

    @Override
    public void addProperty(Property prop,int id) {
        Customer user=custrep.findById((long)id).get();
        prop.setCustomer(user);
        proprep.save(prop);
    }

    @Override
    public void updateProperty(Property prop) {
        Property p= proprep.getOne(prop.getId_prop());
        p.setImage(prop.getImage());
        p.setLoyer(prop.getLoyer());
        p.setNbrooms(prop.getNbrooms());
        p.setVideo(prop.getVideo());
        p.setSuperficie(prop.getSuperficie());
        p.setSurface(prop.getSurface());
        p.setType(prop.getType());
        p.setAdress(prop.getAdress());
        p.setCity(prop.getCity());
        p.setState(prop.getState());
        p.setZipCode(prop.getZipCode());
        prop.setCustomer(proprep.CustomerProps(prop.getId_prop()));

        proprep.save(prop);
    }

    @Override
    public void deleteProperty(int id) {

        proprep.deleteById(id);
    }

    @Override
    public List<Property> Allproperties() {

   return  proprep.findAll();



    }

    @Override
    public Property getprop(int id) {
        return proprep.findById(id).orElseThrow(() -> new PropertyNotFoundException(String.valueOf(id)));
    }

    @Override
    public List<Property> userproperties(Long id) {

        return proprep.userProp(id);


    }

    @Override
    public List<Property> rechByType(String proptype) {
        return proprep.rechByType(proptype);
    }
    public List<Property> search(String filter){

        return proprep.filter(filter);
    }
}

