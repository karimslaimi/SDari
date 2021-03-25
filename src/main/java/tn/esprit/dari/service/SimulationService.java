package tn.esprit.dari.service;


import org.springframework.stereotype.Service;

@Service
public class SimulationService implements ISimulation{

    @Override
    public double CalculMensualiteSA(double montantCredit, float taux_period, long duree) {

        double m ;
        double sup;
        long dur = duree * 12 ;

      //  double pui = Math.pow( (1+taux_period),dur) ;
        sup = (montantCredit * taux_period) / 12 ;
        double inf2 = ( 1 - Math.pow((1+(taux_period/12)),-dur));
       // double inf = Math.pow((1+taux_period), (dur - 1));
        m = sup / inf2 ;
        return m;
    }

    @Override
    public double MontantAssurance(double taux, double montantCredit) {
        double Assurance =( taux * montantCredit)/ 12 ;
        return Assurance;
    }

    @Override
    public double CalculMensualiteAA(double montantCredit, float taux_period, long duree, float assurance) {



        double ma = CalculMensualiteSA(montantCredit, taux_period, duree) + MontantAssurance(taux_period,montantCredit) ;
        return ma;
    }

    @Override
    public double CreditTotal(double montantCredit, long duree ,float interet, double assurance, double frais) {

        double taux = (montantCredit* interet) / 12 ;
        //double montant_interet =(( CalculMensualiteSA(montantCredit,taux_period,duree) * (duree * 12 ) ) - montantCredit ) ;
      //  double montant_assurance = (assurance * montantCredit) / 12 ;
        double total = montantCredit + taux + MontantAssurance(assurance,montantCredit)+ frais ;
        return total;
    }
}
