package tn.esprit.dari.service;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.*;
import tn.esprit.dari.repositories.*;

import java.util.*;
import java.util.stream.Collectors;

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
   @Autowired
   private IPanierService service;
   @Autowired
   private DetailPRepository detailPRepository;


    @Override
    public void addOrder(int idc)
    {
        Orders ord=new Orders();
        Panier p= service.getUserPanier(idc);
        List<Furniture> detail_panier=service.detailPanier(p.getIdPanier());

        List<LigneCommande> ligneCommandes=new ArrayList<LigneCommande>();

        for (Furniture f: detail_panier) {
            LigneCommande ligneCommande=new LigneCommande();

            ligneCommande.setFur(f);

            ligneCommande.setPrix(f.getPrice());
            ligneCommande.setQuantite(1);


            ligneCommandes.add(ligneCommande);

        }


        ord.setSomme((float) ligneCommandes.stream().mapToDouble(LigneCommande::getPrix).sum());

        ord.setCusto(custrep.getOne((long)idc));
        ord.setDatecommande(new Date());

        ordrep.save(ord);

        for(LigneCommande lc:ligneCommandes){
            lc.setOrd(ord);
            lcrep.save(lc);
        }






       detailPRepository.deleteAll(detailPRepository.getByPanier(p.getIdPanier()));

    }

    @Override
    public void deleteOrder(int id) {
        ordrep.deleteById(id);
    }

    @Override
    public List<Orders> AllOrders(int idc) {
        List<Orders> ords = (List<Orders>) ordrep.myOrders((long)idc);
        return ords;

    }

    @Override
    public Orders getorder(int id) {
        return ordrep.findById(id).orElse(null);
    }

    @Override
    public void commander(Orders ords) {
      /*  Customer customer= custrep.findById(ords.getIdc()).orElse(null);
        ords.setCusto(customer);
        Orders orders=ordrep.save(ords);

        List<Detail_Panier> dp=customer.getPanier();
        for (Detail_Panier d:dp)
        {
            LigneCommande lc=new LigneCommande();
            lc.setFur(d.getFurs());
            lc.setOrd(orders);
            lc.setPrix(d.getFurs().getPrice());
            lc.setQuantite(1);
            lcrep.save(lc);
        }*/


    }

    @Override
    public List<Orders> listecommandesuser(Long idc) {
        Customer c=custrep.findById(idc).orElse(null);
        return c.getOrds();

    }

    @Override
    public List<Furniture> ordFurn(int id) {
        return  ordrep.OrdFurn(id);

        //return lc.stream().map((s)->s.getFur()).collect(Collectors.toList());
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
