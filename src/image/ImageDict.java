package image;

import dictionnaire.*;

/** La classe <code>ImageDict</code> représente une image en niveaux
 *  de gris au moyen d'un dictionnaire dont les clefs sont des coordonnées
 *  (classe <code>Point</code>) et les valeurs les niveaux de gris associés.
 *  Lors de l'instanciation, il suffit de créer un dictionnaire vide puisqu'on
 *  ne stocke que les niveau de gris autres que blanc. L'absence de la clef
 *  (x, y) dans le dictionnaire signifie que le point (x, y) est blanc.
 *  Cette classe utilise <code>TabDict</code>.
 *  @see image.NiveauGris
 *  @see image.Point
 *  @see dictionnaire.TabDict
 */
public class ImageDict extends ImageDictCom implements ImageGrise {

        public ImageDict(int w, int h) {
        super(w,h);
}

        public NiveauGris pointEn(int x, int y) {
                if (points.contientClef(new Point(x, y)))
                        return (NiveauGris) points.valeurPour(new Point(x, y));
                return NiveauGris.BLANC;
        }

        public void definirPoint(int x, int y, NiveauGris gris) {
                if (this.correct(x,y)) {
                        if (gris.equals(NiveauGris.BLANC))
                                points.enleverPour(new Point(x, y));
                        else
                                points.ajouter(new Point(x, y), gris);
                }
        }

        public ImageGrise eclaircir() {
                ImageGrise result = new ImageDict(largeur, hauteur);
                for (int y=0; y<hauteur; y++)
                        for (int x=0; x<largeur; x++)
                                result.definirPoint(x, y, this.pointEn(x,y).eclaircir());
                return result;
        }
        public ImageGrise inverser() {
                ImageGrise result = new ImageDict(largeur, hauteur);
                for (int y=0; y<hauteur; y++)
                        for (int x=0; x<largeur; x++)
                                result.definirPoint(x, y, this.pointEn(x,y).inverser());
                return result;
        }

        public ImageGrise assombrir() {
                ImageGrise result = new ImageDict(largeur, hauteur);
                for (int y=0; y<hauteur; y++)
                        for (int x=0; x<largeur; x++)
                                result.definirPoint(x, y, this.pointEn(x,y).assombrir());
                return result;
        }

        public ImageGrise dupliquer() {
                ImageGrise result = new ImageDict(largeur, hauteur);
                for (int y=0; y<hauteur; y++)
                        for (int x=0; x<largeur; x++)
                                result.definirPoint(x, y, this.pointEn(x,y));
                return result;
        }

        public ImageGrise ajouter(ImageGrise img) throws ImageIncompatiblesException {
                ImageGrise result = new ImageDict(largeur, hauteur);
                if (this.incompatible(img))
                        throw new ImageIncompatiblesException("Image incompatible");
                for (int y=0; y<hauteur; y++)
                        for (int x=0; x<largeur; x++)
                                result.definirPoint(x, y,
                                        this.pointEn(x,y).ajouter(img.pointEn(x,y)));
                return result;
        }

        public ImageGrise soustraire(ImageGrise img) throws ImageIncompatiblesException {
                ImageGrise result = new ImageDict(largeur, hauteur);
                if (this.incompatible(img))
                        throw new ImageIncompatiblesException("Image incompatible");
                for (int y=0; y<hauteur; y++)
                        for (int x=0; x<largeur; x++)
                                result.definirPoint(x, y,
                                        this.pointEn(x,y).soustraire(img.pointEn(x,y)));
                return result;
        }

        public ImageGrise XOR(ImageGrise img) throws ImageIncompatiblesException {
                ImageGrise result = new ImageDict(largeur, hauteur);
                if (this.incompatible(img))
                        throw new ImageIncompatiblesException("Image incompatible");
                for (int y=0; y<hauteur; y++)
                        for (int x=0; x<largeur; x++)
                                result.definirPoint(x, y,
                                        this.pointEn(x,y).XOR(img.pointEn(x,y)));
                return result;
        }

        public ImageGrise intersection(ImageGrise img) throws ImageIncompatiblesException {
                ImageGrise result = new ImageDict(largeur, hauteur);
                if (this.incompatible(img))
                        throw new ImageIncompatiblesException("Image incompatible");
                for (int y=0; y<hauteur; y++)
                        for (int x=0; x<largeur; x++)
                                if (this.pointEn(x,y).equals(img.pointEn(x,y)))
                                        result.definirPoint(x, y, this.pointEn(x,y));
                return result;
        }

        public ImageGrise augmenterContraste() {
                NiveauGris courant, moyen;
                ImageGrise result = new ImageDict(largeur, hauteur);
                moyen = this.niveauMoyen();
                for (int y=0; y<hauteur; y++)
                        for (int x=0; x<largeur; x++) {
                                courant = this.pointEn(x, y);
                                if (courant.compareTo(moyen) > 0)
                                        result.definirPoint(x, y, courant.assombrir());
                                else
                                        result.definirPoint(x, y, courant.eclaircir());
                        }
                return result;
        }
}
