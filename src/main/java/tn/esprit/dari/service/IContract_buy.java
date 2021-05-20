package tn.esprit.dari.service;

import org.apache.http.annotation.Contract;
import tn.esprit.dari.entities.Contract_Buy;

import java.util.List;

public interface IContract_buy {
    Contract_Buy findByDid(int id_user, int id_property);
    boolean deleteByDid(int id_user, int id_property);


    void saved(Contract_Buy contractBuy);
    void updateContractBuy(Contract_Buy cb);
}
