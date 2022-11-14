package animaux ;
public class Animal {
    private String nom ;
    public Animal(String nom) { this.nom = nom ; }
    public Animal() { nom = null ; }
    public String toString() { 
	return "Je suis un animal" + ecrireNom() + "." ;
    }    
    protected String ecrireNom() {
	if (nom != null) return " de nom "+nom ;
	else return "" ;
    }
}
