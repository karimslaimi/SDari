package tn.esprit.dari.service;


import org.springframework.stereotype.Service;

@Service
public class SimulationService implements ISimulation{
    @Override
    public double CalculMensualiteSA(double montantCredit, int interet, long duree) {
        double m ;
        double sup;
        double inf ;
        sup = (montantCredit * interet) / 12 ;
        double puissance = Math.pow(1+(interet/12), (duree*12));
        inf = (1- puissance )  ;
        m = sup / inf ; 
        return m;
    }

    @Override
    public double CalculMensualiteAA(double montantCredit, int interet, long duree, double assurance) {
        return 0;
    }

    @Override
    public double CreditTotal(double mensualiteAA, double interet, double assurance, double frais) {
        return 0;
    }
}
