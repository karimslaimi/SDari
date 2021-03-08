package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.entities.Property;
import tn.esprit.dari.repositories.CustomerRepository;
import tn.esprit.dari.repositories.PropertyRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PropertyRepository propertyRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void addFave(int propId, Long customerId) {

        Property p = propertyRepository.findById(propId).get();
        Customer c = customerRepository.findById(customerId).get();
        List<Property> lp = new ArrayList<Property>();
        lp.add(p);
        c.setFavorites(lp);
        customerRepository.save(c);
    }

    @Override
    public void deleteFave(int propId, Long customerId) {
        Customer c = customerRepository.findById(customerId).get();
        List<Property> lp = c.getFavorites();
        for (Property p : lp){
            if (p.getId_prop()==propId)
                lp.remove(p);
        }
        c.setFavorites(lp);
        customerRepository.save(c);
    }

    @Override
    public void updateProfile(Customer customer) {
        Customer c = customerRepository.findById(customer.getUtilisateurId()).get();
        c.setFirstName(customer.getFirstName());
        c.setLastName(customer.getLastName());
        c.setUsername(customer.getUsername());
        c.setPhone(customer.getPhone());
        c.setRegion(customer.getRegion());

        customerRepository.save(c);
    }
    @Override
    public void updateProfilePicture(Customer customer){
        Customer c = customerRepository.findById(customer.getUtilisateurId()).get();
        c.setPicture(customer.getPicture());
        customerRepository.save(c);

    }

}
