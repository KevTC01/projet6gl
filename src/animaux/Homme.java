package animaux ;
public class Homme extends Mammifere {
    public Homme(String nom) { super(nom) ; }
    public Homme() { super("inconnu") ; }
    public String toString() { 
	return "Je suis un homme" + ecrireNom() + ".";
    }
}
