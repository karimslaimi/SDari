package tn.esprit.dari.service;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.*;
import tn.esprit.dari.repositories.CustomerRepository;
import tn.esprit.dari.repositories.FurnitureRepository;
import tn.esprit.dari.repositories.LigneCommandeRepository;
import tn.esprit.dari.repositories.OrdersRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrdersService implements IOrdersService{
   @Autowired
   private CustomerRepository custrep ;

    @Autowired
    private OrdersRepository ordrep ;
    @Autowired
    private FurnitureRepository furrep ;
   @Autowired
   private LigneCommandeRepository lcrep;
    @Override
    public void addOrder(Orders ord) {
        ordrep.save(ord);
    }

    @Override
    public void deleteOrder(int id) {
        ordrep.deleteById(id);
    }

    @Override
    public List<Orders> AllOrders() {
        List<Orders> ords = (List<Orders>) ordrep.findAll();
        return ords;

    }

    @Override
    public Orders getorder(int id) {
        return ordrep.findById(id).orElse(null);
    }

    @Override
    public void commander(Orders ords) {
        Customer customer= custrep.findById(ords.getIdc()).orElse(null);
        ords.setCusto(customer);
        Orders orders=ordrep.save(ords);

        List<Detail_Panier> dp=customer.getPanier().getDetail_paniers();
        for (Detail_Panier d:dp)
        {
            LigneCommande lc=new LigneCommande();
            lc.setFur(d.getFurs());
            lc.setOrd(orders);
            lc.setPrix(d.getFurs().getPrice());
            lc.setQuantite(1);
            lcrep.save(lc);
        }

    }

    @Override
    public List<Orders> listecommandesuser(Long idc) {
        Customer c=custrep.findById(idc).orElse(null);
        return c.getOrds();

    }

    //-----------------------------paiement-----------------------------------//


    @Value("${STRIPE_SECRET_KEY}")
    private String API_SECRET_KEY;

    @Autowired
    public void SubscriptionRepository() {
        Stripe.apiKey = API_SECRET_KEY;
    }

    public Charge chargeNewCard(String token, double amount) throws Exception {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", (int)(amount * 100));
        chargeParams.put("currency", "USD");
        chargeParams.put("source", token);
        Charge charge = Charge.create(chargeParams);
        return charge;
    }








}
