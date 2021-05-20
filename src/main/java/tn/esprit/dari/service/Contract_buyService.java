package tn.esprit.dari.service;

import org.apache.http.annotation.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.controllers.UserController;
import tn.esprit.dari.entities.*;
import tn.esprit.dari.repositories.Contract_buyRepository;
import tn.esprit.dari.repositories.PropertyRepository;
import tn.esprit.dari.repositories.UtilisateurRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Contract_buyService implements IContract_buy{

    @Autowired
    private PropertyRepository pr;
    @Autowired
    private UtilisateurRepository ur;
    @Autowired
    private Contract_buyRepository cbr;

    @Override
    public Contract_Buy findByDid(int id_user, int id_property) {

        Contract_Buy cb=new Contract_Buy();

        List<Contract_Buy> lst = cbr.findAll();

        for(int i=0;i<lst.size();i++){
            if ((lst.get(i).getId_user()==id_user) && (lst.get(i).getId_property()==id_property)){
                System.out.println(lst.get(i));
                cb= lst.get(i);
            }
        }

        return cb;
    }

    @Override
    public boolean deleteByDid(int id_user, int id_property) {

        List<Contract_Buy> lst = cbr.findAll();
        int before = lst.size();
        for(int i=0;i<lst.size();i++){
            if ((lst.get(i).getId_user()==id_user) && (lst.get(i).getId_property()==id_property)){
                cbr.deleteById(id_property);
            }
        }
        if(before!=cbr.findAll().size())
        {
            return true;
        }else
        {
            return false;
        }
    }



    @Override
    public void saved(Contract_Buy contractBuy) {
        Optional<Utilisateur> u = ur.findById((long) contractBuy.getId_user());
        Optional<Property> p = pr.findById(contractBuy.getId_property());
        if ((u.get().getUtilisateurId()>0) && (p.get().getId_prop()>0)){
            cbr.save(contractBuy);
        }
    }


    @Override
    public void updateContractBuy(Contract_Buy cb) {
        Contract_Buy f= this.findByDid(cb.getId_user(),cb.getId_property());
        f.setId_user(cb.getId_user());
        f.setId_property(cb.getId_property());
        f.setDate(cb.getDate());
        f.setDetails(cb.getDetails());
        cbr.save(cb);
    }
}


