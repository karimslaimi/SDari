package tn.esprit.dari.service;

import tn.esprit.dari.entities.Contract_Rent;

public interface IContract_rent {
    Contract_Rent findByDid(long id_user, int id_property);
    boolean deleteByDid(long id_user, int id_property);
}
