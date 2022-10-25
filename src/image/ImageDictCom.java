package image;

import dictionnaire.Dictionnaire;
import dictionnaire.TabDict;

public abstract class ImageDictCom extends ImageQuelconque{
    protected Dictionnaire points;

    public ImageDictCom(int w, int h){
        super(w,h);
    }
    @Override
    protected void initialiserPoints() {
        points = new TabDict();
    }


    @Override
    public NiveauGris pointEn(int x, int y) {
        return null;
    }

    @Override
    public void definirPoint(int x, int y, NiveauGris gris){

    }


    @Override
    public abstract ImageGrise eclaircir();

    @Override
    public abstract ImageGrise inverser();

    @Override
    public abstract ImageGrise assombrir();

    @Override
    public abstract ImageGrise dupliquer();

    @Override
    public  abstract ImageGrise ajouter(ImageGrise img);

    @Override
    public abstract ImageGrise soustraire(ImageGrise img);

    @Override
    public abstract ImageGrise XOR(ImageGrise img);

    @Override
    public abstract ImageGrise intersection(ImageGrise img);

    @Override
    public abstract ImageGrise augmenterContraste();
}
