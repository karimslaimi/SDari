package tn.esprit.dari.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Furniture;
import tn.esprit.dari.repositories.FurnitureRepository;

import java.util.List;

@Service
public class FurnitureService implements IFurnitureService{

    @Autowired
    private FurnitureRepository furrep ;


    @Override
    public void addFurniture(Furniture prop) {
        furrep.save(prop);
    }

    @Override
    public void updateFurniture(Furniture fur) {
        Furniture f= furrep.findById(fur.getId_fur()).get();
        f.setPicture(fur.getPicture());
        f.setPrice(fur.getPrice());
        f.setDescription(fur.getDescription());
        f.setDimentions(fur.getDimentions());
        f.setNb(fur.getNb());
        furrep.save(fur);
    }

    @Override
    public void deleteFurniture(int id) {
        furrep.deleteById(id);
    }

    @Override
    public List<Furniture> AllFurnitures() {

        List<Furniture> furs = (List<Furniture>) furrep.findAll();

        return furs;

    }

    @Override
    public Furniture getfur(int id) {
        return furrep.findById(id).orElse(null);
    }

}
