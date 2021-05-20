package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Contract_Buy;
import tn.esprit.dari.entities.Contract_Rent;
import tn.esprit.dari.entities.Property;
import tn.esprit.dari.entities.Utilisateur;
import tn.esprit.dari.repositories.Contract_rentRepository;
import tn.esprit.dari.repositories.PropertyRepository;
import tn.esprit.dari.repositories.UtilisateurRepository;

import java.util.Date;
import java.util.List;

@Service
public class Contract_rentService implements IContract_rent {
    @Autowired
    private PropertyRepository pr;
    @Autowired
    private UtilisateurRepository ur;
    @Autowired
    private Contract_rentRepository crr;

    @Override
    public Contract_Rent findByDid(int id_user, int id_property) {

        Contract_Rent cr=new Contract_Rent();

        List<Contract_Rent> lst = crr.findAll();

        for(int i=0;i<lst.size();i++){
            if ((lst.get(i).getId_user()==id_user) && (lst.get(i).getId_property()==id_property)){
                System.out.println(lst.get(i));
                cr= lst.get(i);
            }
        }

        return cr;
    }
    @Override
    public boolean deleteByDid(int id_user, int id_property) {

        List<Contract_Rent> lst = crr.findAll();
        int before = lst.size();
        for(int i=0;i<lst.size();i++){
            if ((lst.get(i).getId_user()==id_user) && (lst.get(i).getId_property()==id_property)){
                crr.deleteById(id_property);
            }
        }
        if(before!=crr.findAll().size())
        {
            return true;
        }else
        {
            return false;
        }
    }
    @Override
    public void updateContractRent(Contract_Rent cr) {
        Contract_Rent f= this.findByDid(cr.getId_user(),cr.getId_property());
        f.setId_user(cr.getId_user());
        f.setId_property(cr.getId_property());
        f.setDateDebut(cr.getDateDebut());
        f.setDateFin(cr.getDateFin());
        f.setDetails(cr.getDetails());
        f.setRented(true);
        crr.save(cr);
    }
}
