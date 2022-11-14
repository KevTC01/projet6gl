package animaux ;
public class HommeBavard extends Homme {
    public HommeBavard(String nom) { super(nom) ; }
    public HommeBavard() { super(null) ; }
    protected String ecrireNom() { 
	if (super.ecrireNom().equals("")) 
	    return " mais je ne sais plus comment je m'appelle" ;
	return super.ecrireNom()+" et je vous salue" ;
    }
}
