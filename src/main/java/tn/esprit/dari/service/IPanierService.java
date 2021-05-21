package tn.esprit.dari.service;

import tn.esprit.dari.entities.Detail_Panier;
import tn.esprit.dari.entities.Furniture;
import tn.esprit.dari.entities.Panier;

import java.util.List;

public interface IPanierService {

    public Panier getUserPanier(long id);
    public void AddDetailPanier(Detail_Panier detail_panier);
    public List<Furniture> getPanier(int id);
    public void deletefurdupanier(int idc,int idf);

    public List<Furniture> detailPanier(int id);

    //public Panier haveAPanier(int user);
    //public void ajouterPanier(Panier pan);
    //public List<Detail_Panier> rechercherDetailPanierUser(int idPan);
}
