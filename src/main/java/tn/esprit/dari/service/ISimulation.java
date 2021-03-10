package tn.esprit.dari.service;

public interface ISimulation {

    double CalculMensualiteSA(double montantCredit, int interet , long duree);
    double CalculMensualiteAA(double montantCredit, int interet , long duree, double assurance);
    double CreditTotal ( double mensualiteAA , double interet, double assurance, double frais);
}
