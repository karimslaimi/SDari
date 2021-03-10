package tn.esprit.dari.service;

public interface ISimulation {

    double CalculMensualiteSA(double montantCredit, float taux_period , long duree);
    double CalculMensualiteAA(double montantCredit, float taux_period, long duree, int assurance);
    double CreditTotal (double montantCredit, long duree ,float taux_period, double assurance, double frais);
}
