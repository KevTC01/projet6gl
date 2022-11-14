package image;

/** La classe <code>ImageTab</code> représente une image en niveaux
 *  de gris au moyen d'un tableau à deux dimensions de <code>NiveauGris</code>.
 *  Le tableau de départ doit donc être initialisé lors de l'instanciation
 *  en plaçant partout des points blancs.
 *  @see image.NiveauGris
 */
public class ImageTab extends ImageQuelconque implements ImageGrise {
        private NiveauGris [][] points;

        public ImageTab(int w, int h) {
                super(w,h);
        }

        protected void initialiserPoints() {
                points = new NiveauGris[largeur][hauteur];
                for (int y=0; y<hauteur; y++)
                        for (int x=0; x<largeur; x++)
                                this.definirPoint(x, y, NiveauGris.BLANC);
                // this.definirPoint(x, y, new NiveauGris(NiveauGris.BLANC));
        }

        public NiveauGris pointEn(int x, int y) {
                if (this.correct(x,y))
                        return points[x][y];
                return NiveauGris.BLANC;
        }

        public void definirPoint(int x, int y, NiveauGris gris) {
                if (this.correct(x,y))
                        points[x][y] = gris;
        }

        public ImageGrise inverser() {
                ImageGrise result = new ImageTab(largeur, hauteur);
                for (int y=0; y<hauteur; y++)
                        for (int x=0; x<largeur; x++)
                                result.definirPoint(x, y, this.pointEn(x,y).inverser());
                return result;
        }

        public ImageGrise eclaircir() {
                ImageGrise result = new ImageTab(largeur, hauteur);
                for (int y=0; y<hauteur; y++)
                        for (int x=0; x<largeur; x++)
                                result.definirPoint(x, y, this.pointEn(x,y).eclaircir());
                return result;
        }

        public ImageGrise assombrir() {
                ImageGrise result = new ImageTab(largeur, hauteur);
                for (int y=0; y<hauteur; y++)
                        for (int x=0; x<largeur; x++)
                                result.definirPoint(x, y, this.pointEn(x,y).assombrir());
                return result;
        }

        public ImageGrise dupliquer() {
                ImageGrise result = new ImageTab(largeur, hauteur);
                for (int y=0; y<hauteur; y++)
                        for (int x=0; x<largeur; x++)
                                result.definirPoint(x, y, this.pointEn(x,y));
                return result;
        }

        public ImageGrise ajouter(ImageGrise img) throws ImageIncompatiblesException {
                ImageGrise result = new ImageTab(largeur, hauteur);
                if (this.incompatible(img))
                        throw new ImageIncompatiblesException("Image incompatible");
                for (int y=0; y<hauteur; y++)
                        for (int x=0; x<largeur; x++)
                                result.definirPoint(x, y,
                                        this.pointEn(x,y).ajouter(img.pointEn(x,y)));
                return result;
        }

        public ImageGrise soustraire(ImageGrise img) throws ImageIncompatiblesException {
                ImageGrise result = new ImageTab(largeur, hauteur);
                if (this.incompatible(img))
                        throw new ImageIncompatiblesException("Image incompatible");
                for (int y=0; y<hauteur; y++)
                        for (int x=0; x<largeur; x++)
                                result.definirPoint(x, y,
                                        this.pointEn(x,y).soustraire(img.pointEn(x,y)));
                return result;
        }

        public ImageGrise XOR(ImageGrise img) throws ImageIncompatiblesException {
                ImageGrise result = new ImageTab(largeur, hauteur);
                if (this.incompatible(img))
                        throw new ImageIncompatiblesException("Image incompatible");
                for (int y=0; y<hauteur; y++)
                        for (int x=0; x<largeur; x++)
                                result.definirPoint(x, y,
                                        this.pointEn(x,y).XOR(img.pointEn(x,y)));
                return result;
        }

        public ImageGrise intersection(ImageGrise img) throws ImageIncompatiblesException {
                ImageGrise result = new ImageTab(largeur, hauteur);
                if (this.incompatible(img))
                        throw new ImageIncompatiblesException("Image incompatible");
                for (int y=0; y<hauteur; y++)
                        for (int x=0; x<largeur; x++)
                                if (this.pointEn(x,y).equals(img.pointEn(x,y)))
                                        result.definirPoint(x, y, this.pointEn(x,y));
                return result;
        }

        public ImageGrise masquer(ImageGrise img) throws ImageIncompatiblesException {
                ImageGrise result = new ImageTab(largeur, hauteur);
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
                ImageGrise result = new ImageTab(largeur, hauteur);
                moyen = this.niveauMoyen();
                for (int y=0; y<hauteur; y++)
                        for (int x=0; x<largeur; x++)
                        {
                                courant = this.pointEn(x, y);
                                if (courant.compareTo(moyen) > 0)
                                        result.definirPoint(x, y, courant.assombrir());
                                else
                                        result.definirPoint(x, y, courant.eclaircir());
                        }
                return result;
        }

}
