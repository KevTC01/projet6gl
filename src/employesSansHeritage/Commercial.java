package employesSansHeritage;

public class Commercial {

    private double somme_fixe, chiffre_affaire;
    private String nom;

    public Commercial(String nom){
        somme_fixe = 2000;
        chiffre_affaire = 0;
        this.nom = nom;
    }

    public void setTravail(double ca){
        this.chiffre_affaire = ca;
    }

    public double salaireHebdo(){
        return somme_fixe+(chiffre_affaire/100);
    }

    public String toString(){
        return nom;
    }
}
