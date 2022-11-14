package emplyesAvecHeritage;

import java.util.List;

public class Directeur extends EmployeQuelconque{

    private static Directeur instance;
    private double somme_fixe, taux, chiffre_affaire_total;
    private List<Commercial> commerciaux;

    public static Directeur getDirecteur(){
        if (instance == null){
            instance = new Directeur();
        }
        return instance;
    }

    private Directeur(){
        super("Le directeur");
        somme_fixe = 5000;
        taux = 0.004;
        chiffre_affaire_total = 0;
    }

    public void addCommercial(Commercial commercial){
        commerciaux.add(commercial);
    }

    public double salaireHebdo(){
        for (Commercial commercial : commerciaux){
            chiffre_affaire_total+=commercial.getChiffre_affaire();
        }
        return somme_fixe+(chiffre_affaire_total*taux);
    }
}
