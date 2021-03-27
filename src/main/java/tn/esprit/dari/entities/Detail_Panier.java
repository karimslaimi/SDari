package tn.esprit.dari.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Detail_Panier implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idDetPanier;

    private Date dateAjout;

    private double prixFuniture;

    private int qte;

    @ManyToOne
    @JoinColumn(name="ID_PANIER")
    private Panier panier;

    @ManyToOne
    private Furniture furs;







}
