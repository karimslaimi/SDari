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
    public Contract_Rent findByDid(long id_user, int id_property) {

        Contract_Rent cr=new Contract_Rent();
        Utilisateur u=ur.findById((long)id_user).orElse(null);
        Property p=pr.findById(id_property).orElse(null);

        List<Contract_Rent> lst = crr.findAll();

        for(int i=0;i<lst.size();i++){
            if ((lst.get(i).getId_Client()==u.getUtilisateurId()) && (lst.get(i).getId_Rent()==p.getId_prop())){
                cr= lst.get(i);
            }
        }

        return cr;
    }
    @Override
    public boolean deleteByDid(long id_user, int id_property) {
        Utilisateur u=ur.findById((long)id_user).orElse(null);
        Property p=pr.findById(id_property).orElse(null);

        List<Contract_Rent> lst = crr.findAll();
        int before = lst.size();
        for(int i=0;i<lst.size();i++){
            if ((lst.get(i).getId_Client()==u.getUtilisateurId()) && (lst.get(i).getId_Rent()==p.getId_prop())){
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
}
