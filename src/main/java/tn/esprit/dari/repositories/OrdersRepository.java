package tn.esprit.dari.repositories;

import com.stripe.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.Furniture;
import tn.esprit.dari.entities.LigneCommande;
import tn.esprit.dari.entities.Orders;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer > {
//behi
    @Query("select o from Orders  o where o.custo.utilisateurId=:id")
    public List<Orders> myOrders(@Param("id")long id);

    @Query("select f from  LigneCommande l, Furniture f where  l.ord.id_o=:id and l.fur=f")
    public List<Furniture> OrdFurn(@Param("id")int id);
    @Query("select o from Orders o , LigneCommande l where l.fur.id_fur=:id and l.ord=o ")
    public  List<Order> furnOrders(@Param("id")int id);
    @Query("select l from LigneCommande l where l.fur.id_fur=:id")
    public List<LigneCommande> lcommfurn(@Param("id") int id);
}
