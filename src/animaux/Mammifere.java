package animaux ;
public class Mammifere extends Animal {
    public Mammifere(String nom) { super(nom) ; }
    public Mammifere() {}
    public String toString() { 
	return super.toString() + " Je suis un mammifere." ;
    }
}
