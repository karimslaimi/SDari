package tn.esprit.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Buy;
import tn.esprit.dari.repositories.BuyRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuyService implements IBuy {

    @Autowired
    private BuyRepository br;

    @Override
    public float pricePerMeter(float price, float surface)
    {
        return surface/price;
    }
    @Override
    public float EstimationForMeter(String state) {
        List<Buy> lst=br.findAll();
        float sum=0;
        int nb=0;
        for(int i=0; i<lst.size();i++)
        {
            if(lst.get(i).getState().equals(state))
            { nb+=1;
            float one =lst.get(i).getPrice()/lst.get(i).getSurface();
            sum+=one;
            }
        }
        return sum/nb;
    }



    @Override
    public void updateBuy(Buy buy) {
        Buy f= br.findById(buy.getId_prop()).get();
        f.setPrice(buy.getPrice());
        f.setAdress(buy.getAdress());
        f.setCity(buy.getCity());
        f.setNbrooms(buy.getNbrooms());
        f.setLoyer(buy.getLoyer());
        f.setPrix(buy.getPrix());
        f.setState(buy.getState());
        f.setStatus(buy.getStatus());
        f.setSuperficie(buy.getSuperficie());
        f.setSurface(buy.getSurface());
        f.setType(buy.getType());
        f.setZipCode(buy.getZipCode());
        br.save(buy);
    }

    @Override
    public List<Integer> findAllBuyPropertyId() {
        List<Buy> lsta = br.findAll();
        List<Integer> lstPropertyid = new ArrayList<>();
        for(int i=0;i<lsta.size();i++){
            lstPropertyid.add(lsta.get(i).getId_prop());
        }
        return lstPropertyid;
    }

    @Override
    public List<Buy> buyTri() {
        List<Buy> lst=br.findAll();
        Collections.sort(lst);
        return lst;
    }

    @Override
    public List<Buy> searchMultiCriteria(String filter, String adress,String state,String city,int id ){
        List<Buy> buys= br.findAll();

        if(!filter.isEmpty()){
            buys=buys.stream().filter(x->x.getAdress().toLowerCase().contains(filter.toLowerCase())||
                    x.getState().toLowerCase().contains(filter.toLowerCase())||
                    x.getCity().toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
        }

        return buys;

    }


}
