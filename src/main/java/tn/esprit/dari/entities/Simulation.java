package tn.esprit.dari.entities;

import java.io.Serializable;


public class Simulation implements Serializable {

    private int taux_interet ;
    private double montant_credit ;
    private long duree;
    private int taux_assurance ;
    private double frais_dossier ;

    public int getTaux_interet() {
        return taux_interet;
    }

    public void setTaux_interet(int taux_interet) {
        this.taux_interet = taux_interet;
    }

    public double getMontant_credit() {
        return montant_credit;
    }

    public void setMontant_credit(double montant_credit) {
        this.montant_credit = montant_credit;
    }

    public long getDuree() {
        return duree;
    }

    public void setDuree(long duree) {
        this.duree = duree;
    }

    public int getTaux_assurance() {
        return taux_assurance;
    }

    public void setTaux_assurance(int taux_assurance) {
        this.taux_assurance = taux_assurance;
    }

    public double getFrais_dossier() {
        return frais_dossier;
    }

    public void setFrais_dossier(double frais_dossier) {
        this.frais_dossier = frais_dossier;
    }
}
