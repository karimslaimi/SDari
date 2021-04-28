package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.repositories.PanierRepository;


@Service
public class PanierService implements IPanierService{

    @Autowired
    private PanierRepository panprep ;
    @Autowired
    private PanierService panser ;

    public void ajouteraupanier(int idf, Long idc) {

    }


}
