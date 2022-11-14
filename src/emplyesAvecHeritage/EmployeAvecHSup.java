package emplyesAvecHeritage;

public class EmployeAvecHSup extends EmployeQuelconque{

    protected double temps_travail, taux_horaire, majoration, heures;

    public EmployeAvecHSup(String nom){
        super(nom);
        temps_travail = 35;
        taux_horaire = 7.5;
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
}
