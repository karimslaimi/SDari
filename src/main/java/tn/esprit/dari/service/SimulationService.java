package tn.esprit.dari.service;


import org.springframework.stereotype.Service;

@Service
public class SimulationService implements ISimulation{

    @Override
    public double CalculMensualiteSA(double montantCredit, float taux_period, long duree) {

        double m ;
        double sup;

        double pui = Math.pow( (1+taux_period),(duree * 12)) ;
        sup = (montantCredit * taux_period) *  pui ;
        double inf = Math.pow((1+taux_period), ((duree * 12) - 1));
        m = sup / inf ;
        return m;
    }

    @Override
    public double CalculMensualiteAA(double montantCredit, float taux_period, long duree, int assurance) {

        double montant_assurance = (assurance * montantCredit) / 12 ;
        double ma = CalculMensualiteSA(montantCredit, taux_period, duree) + montant_assurance ;
        return ma;
    }

    @Override
    public double CreditTotal(double montantCredit, long duree ,float taux_period, double assurance, double frais) {

        double montant_interet =(( CalculMensualiteSA(montantCredit,taux_period,duree) * (duree * 12 ) ) - montantCredit ) ;
        double montant_assurance = (assurance * montantCredit) / 12 ;
        double total = CalculMensualiteSA(montantCredit,taux_period,duree) + montant_interet + montant_assurance + frais ;
        return total;
    }
}
