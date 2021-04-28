package tn.esprit.dari.service;

public interface ISimulation {

    double CalculMensualiteSA(double montantCredit, float taux_period , long duree);
    double MontantAssurance( double taux , double montantCredit );
    double CalculMensualiteAA(double montantCredit, float taux_period, long duree,float assurance);
    double CreditTotal (double montantCredit, long duree ,float taux, double assurance, double frais);
}
