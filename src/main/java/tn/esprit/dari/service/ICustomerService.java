package tn.esprit.dari.service;

import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.entities.Property;

import java.util.List;

public interface ICustomerService {
    public List<Customer> getAllCustomers();
    void addFave(int propId, Long customerId);
    public List<Property> getAllfave(Long customerId);
    void deleteFave(int propId, Long customerId);
    void updateProfile(Customer customer);
    void updateProfilePicture(Customer customer);
}
