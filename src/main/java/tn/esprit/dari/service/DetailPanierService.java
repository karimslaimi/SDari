package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Detail_Panier;
import tn.esprit.dari.entities.Furniture;
import tn.esprit.dari.entities.Panier;
import tn.esprit.dari.repositories.DetailPRepository;
import tn.esprit.dari.repositories.FurnitureRepository;
import tn.esprit.dari.repositories.PanierRepository;

@Service
public class DetailPanierService implements IDetailPanierService{


    @Autowired
    private PanierRepository panprep ;

    @Autowired
    private FurnitureRepository furrep ;


    @Autowired
    private DetailPRepository dpprep ;
    @Override
    public void ajouterfuraupanier(Detail_Panier detail_panier) {
        Furniture fr= furrep.findById(detail_panier.getIdf()).orElse(null);
        Panier p= panprep.findById(detail_panier.getIdp()).orElse(null);
       detail_panier.setPanier(p);
       detail_panier.setFurs(fr);
       dpprep.save(detail_panier);

    }

    @Override
    public void deletefurdupanier(int idp) {

        dpprep.delete(dpprep.findById(idp).orElse(null));

    }
}
