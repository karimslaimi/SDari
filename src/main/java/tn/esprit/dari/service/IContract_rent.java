package tn.esprit.dari.service;

import tn.esprit.dari.entities.Contract_Buy;
import tn.esprit.dari.entities.Contract_Rent;

public interface IContract_rent {
    Contract_Rent findByDid(int id_user, int id_property);
    boolean deleteByDid(int id_user, int id_property);
    void updateContractRent(Contract_Rent cr);
}
