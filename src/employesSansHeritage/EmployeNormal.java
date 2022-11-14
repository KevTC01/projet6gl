package employesSansHeritage;

public class EmployeNormal {

    private double temps_travail, taux_horaire, majoration, heures;
    private String nom;

    public EmployeNormal(String nom){
        temps_travail = 35;
        taux_horaire = 7.5;
        majoration = 1.25;
        this.nom = nom;
    }

    public void setTravail(double heures){
        this.heures = heures;
    }


}
