package emplyesAvecHeritage;

public class Commercial extends EmployeQuelconque{

    private double somme_fixe, chiffre_affaire;

    public Commercial(String nom) {
        super(nom);
        somme_fixe = 2000;
        chiffre_affaire = 0;
    }

    public void setTravail(double ca){
        this.chiffre_affaire = ca;
    }

    public double salaireHebdo(){
        return somme_fixe+(chiffre_affaire/100);
    }

    public double getChiffre_affaire() {
        return chiffre_affaire;
    }
}
