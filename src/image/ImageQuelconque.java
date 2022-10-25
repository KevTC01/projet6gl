package image;

public abstract class ImageQuelconque {

    protected int largeur, hauteur;

    public ImageQuelconque(int w, int h){
        largeur = w;
        hauteur = h;
        initialiserPoints();
    }

    public boolean correct(int x, int y){
        return ((x >= 0) && (x < largeur) && (y >= 0) && (y < hauteur));
    }

    protected abstract void initialiserPoints();

    public boolean incompatible(ImageGrise img) {
        return (largeur != img.largeur()) || (hauteur != img.hauteur());
    }

    public int largeur() {
        return largeur;
    }

    public int hauteur() {
        return hauteur;
    }

    protected abstract NiveauGris pointEn(int x, int y);

    abstract void definirPoint(int x, int y, NiveauGris gris);

    public void randomize() {
        for (int y=0; y<hauteur(); y++)
            for (int x=0; x<largeur(); x++)
                this.definirPoint(x, y, this.pointEn(x,y).randomizeNB());
    }

    public void allumer(int x, int y) {
        if (this.correct(x,y))
            this.definirPoint(x, y, NiveauGris.NOIR);
    }

    public void eteindre(int x, int y) {
        if (this.correct(x,y))
            this.definirPoint(x, y, NiveauGris.BLANC);
    }

    public int compterPoints(NiveauGris gris) {
        int nombre = 0;
        for (int y=0; y<hauteur; y++)
            for (int x=0; x<largeur; x++)
                if (this.pointEn(x,y).equals(gris))
                    nombre++;
        return nombre;
    }

    public abstract ImageGrise inverser();

    public abstract ImageGrise eclaircir();

    public abstract ImageGrise assombrir();

    public abstract ImageGrise dupliquer();

    public abstract ImageGrise ajouter(ImageGrise img);

    public abstract ImageGrise soustraire(ImageGrise img);

    public abstract ImageGrise XOR(ImageGrise img);

    public abstract ImageGrise intersection(ImageGrise img);

    public String toString() {
        String s = largeur + "x" + hauteur;
        for (int y=0; y<hauteur; y++) {
            s += "\n";
            for (int x=0; x<largeur; x++)
                s += this.pointEn(x, y);
        }
        return s;
    }

    public NiveauGris niveauMoyen() {
        int s = 0;
        //for (int n=NiveauGris.BLANC; n<=NiveauGris.NOIR; n++)
        for (int n=0; n<=NiveauGris.values().length; n++)
            s += n * this.compterPoints(NiveauGris.deNiveau(n));
        return NiveauGris.deNiveau((int)(((double) s) / (largeur * hauteur)));
    }

    public abstract ImageGrise augmenterContraste();





}
