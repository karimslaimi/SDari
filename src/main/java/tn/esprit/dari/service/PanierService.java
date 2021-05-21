package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Detail_Panier;
import tn.esprit.dari.entities.Furniture;
import tn.esprit.dari.entities.Panier;
import tn.esprit.dari.repositories.CustomerRepository;
import tn.esprit.dari.repositories.DetailPRepository;
import tn.esprit.dari.repositories.PanierRepository;

import java.util.Date;
import java.util.List;


@Service
public class PanierService implements IPanierService{

    @Autowired
    private PanierRepository panprep ;
    @Autowired
    private PanierService panser ;
    @Autowired
    private CustomerRepository customerRepo;
    @Autowired
    private DetailPRepository detailPRepository;

    public Panier getUserPanier(long id){

        Panier p=panprep.getUserPanier(id);
        if(p==null){
            p=new Panier();
            p.setDateMajPanier(new Date());
            p.setCust(customerRepo.getOne((long)id));
            panprep.save(p);
        }
        return p;


    }

    @Override
    public void AddDetailPanier(Detail_Panier detail_panier) {
        detailPRepository.save(detail_panier);
    }

    @Override
    public List<Furniture> getPanier(int id) {
       return panprep.getPanierFurn((long)id);
    }

    @Override
    public void deletefurdupanier(int idc, int idf) {

        Detail_Panier d=panprep.getDetailPanier(idf,(long) idc, PageRequest.of(0,1)).get(0);
        detailPRepository.delete(d);

    }

    @Override
    public List<Furniture> detailPanier(int id) {
        return panprep.getDetail(id);
    }


    public void ajouteraupanier(int idf, Long idc) {

    }


}
