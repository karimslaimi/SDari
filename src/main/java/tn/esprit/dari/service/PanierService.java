package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Panier;
import tn.esprit.dari.repositories.PanierRepository;

import java.util.List;

@Service
public class PanierService implements IPanierService{

    @Autowired
    private PanierRepository panprep ;

    IPanierService panser;

    public final void setDaoPanier(IPanierService panser) {
        this.panser = panser;
    }


    @Override
    public Panier haveAPanier(int user) {
        return panser.haveAPanier(user);
    }
    @Override
    public void ajouterPanier(Panier pan) {
        panser.ajouterPanier(pan);
    }

    /*@Override
    public List<Detail_Panier> rechercherDetailPanierUser(int idPan) {
        return panser.rechercherDetailPanierClient(idPan);
    }*/



}
