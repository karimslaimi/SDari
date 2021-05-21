package tn.esprit.dari.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.*;
import tn.esprit.dari.repositories.CustomerRepository;
import tn.esprit.dari.repositories.DetailPRepository;
import tn.esprit.dari.repositories.FurnitureRepository;
import tn.esprit.dari.repositories.PanierRepository;

import java.util.List;

@Service
public class FurnitureService implements IFurnitureService{
    @Autowired
    private PanierRepository panprep ;
    @Autowired
    private FurnitureRepository furrep ;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DetailPRepository detailPRepository;


    @Override
    public void addFurniture(Furniture prop,long id) {
        prop.setCust(customerRepository.getOne(id));
        furrep.save(prop);
    }

    @Override
    public void updateFurniture(Furniture fur) {
        Furniture f= furrep.findById(fur.getId_fur()).get();
        f.setPicture(fur.getPicture());
        f.setPrice(fur.getPrice());
        f.setDescription(fur.getDescription());
        Customer customer=furrep.Customerfurn(fur.getId_fur());
        f.setCust(customer);
        furrep.save(f);
    }

    @Override
    public void deleteFurniture(int id) {
        furrep.deleteById(id);



    }

    @Override
    public List<Furniture> AllFurnitures() {

        return furrep.getDispo();



    }

    @Override
    public Furniture getfur(int id) {
        return furrep.findById(id).orElse(null);
    }

    @Override
    public List<Furniture> rechparType(String furtype) {
        return furrep.rechByType(furtype);
    }

    @Override
    public List<Furniture> search(String filter) {
        return furrep.filter(filter);
    }


    public  List<Furniture> getMyFurn(long id){
        return furrep.GetMyFurn(id);
    }

}


