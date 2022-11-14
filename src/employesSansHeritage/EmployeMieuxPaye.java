package employesSansHeritage;

public class EmployeMieuxPaye {

    private double temps_travail, taux_horaire, majoration, heures;
    private String nom;

    public EmployeMieuxPaye(String nom){
        temps_travail = 35;
        taux_horaire = 7.5;
        majoration = 1.4;
        this.nom = nom;
    }

    public void setTravail(double heures){
        this.heures = heures;
    }

    public double salaireHebdo(){
        if (heures > temps_travail){
            return temps_travail*taux_horaire+(heures - temps_travail)*taux_horaire*majoration;
        }
        return heures*taux_horaire;
    }

    public String toString(){
        return nom;
    }
}
