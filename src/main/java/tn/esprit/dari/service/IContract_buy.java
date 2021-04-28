package tn.esprit.dari.service;

import tn.esprit.dari.entities.Contract_Buy;

public interface IContract_buy {
    Contract_Buy findByDid(long id_user, int id_property);
    boolean deleteByDid(long id_user, int id_property);
}
