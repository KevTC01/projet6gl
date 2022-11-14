package animaux ;
public class Chien extends Mammifere {
    public Chien(String nom) { super(nom) ; }
    public Chien() { super() ; }
    public String toString() { 
	return super.toString() + " Je suis un chien." ;
    }
}
