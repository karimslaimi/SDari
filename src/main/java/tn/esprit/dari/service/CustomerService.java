package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.*;
import tn.esprit.dari.repositories.CustomerRepository;
import tn.esprit.dari.repositories.PropertyRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
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
    public List<Property> getAllfave(Long customerId){
        Customer customer = customerRepository.findById(customerId).get();
        return customer.getFavorites();
    }

    @Override
    public void deleteFave(int propId, Long customerId) {
        Customer c = customerRepository.findById(customerId).get();

        c.getFavorites().removeIf((Property p) -> p.getId_prop()==propId);


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

    public void createUtilisateurAfterOAuthLoginSuccess(String name, String email, AuthenticationProvider provider){
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setFirstName(name);
        customer.setEnabled(true);
        customer.setCreated(Instant.now());
        customer.setAuthenticationProvider(provider);
        List<Role> lr = new ArrayList<Role>();
        Role role = new Role();
        role.setName("CUSTOMER");
        lr.add(role);
        customer.setRoles(lr);
        System.out.println("here " +email +" "+ name);

        customerRepository.save(customer);

    }
    public void updateUtilisateurAfterOAuthLoginSuccess(Customer customer,  AuthenticationProvider provider, Role role){

        customer.setAuthenticationProvider(provider);
        List<Role> lr = new ArrayList<>();
        lr.add(role);
        customer.setRoles(lr);
        customerRepository.save(customer);

    }
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }


}
