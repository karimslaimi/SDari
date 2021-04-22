package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Contract_Buy;
import tn.esprit.dari.entities.Property;
import tn.esprit.dari.entities.Utilisateur;
import tn.esprit.dari.repositories.Contract_buyRepository;
import tn.esprit.dari.repositories.PropertyRepository;
import tn.esprit.dari.repositories.UtilisateurRepository;

import java.util.List;

@Service
public class Contract_buyService implements IContract_buy{

    @Autowired
    private PropertyRepository pr;
    @Autowired
    private UtilisateurRepository ur;
    @Autowired
    private Contract_buyRepository cbr;

    @Override
    public Contract_Buy findByDid(long id_user, int id_property) {

        Contract_Buy cb=new Contract_Buy();
        Utilisateur u=ur.findById((long)id_user).orElse(null);
        Property p=pr.findById(id_property).orElse(null);

        List<Contract_Buy> lst = cbr.findAll();

        for(int i=0;i<lst.size();i++){
            if ((lst.get(i).getId_user()==u.getUtilisateurId()) && (lst.get(i).getId_property()==p.getId_prop())){
                cb= lst.get(i);
            }
        }

        return cb;
    }

    @Override
    public boolean deleteByDid(long id_user, int id_property) {
        Utilisateur u=ur.findById((long)id_user).orElse(null);
        Property p=pr.findById(id_property).orElse(null);

        List<Contract_Buy> lst = cbr.findAll();
        int before = lst.size();
        for(int i=0;i<lst.size();i++){
            if ((lst.get(i).getId_user()==u.getUtilisateurId()) && (lst.get(i).getId_property()==p.getId_prop())){
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


}
