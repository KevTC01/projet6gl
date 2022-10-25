package dictionnaire;
/** Cette classe réalise un dictionnaire au moyen d'un tableau de
 * couples (objet/objet). Lorsque le tableau devient trop petit, il
 * est automatiquement redimensionné. Le choix fait ici est de
 * travailler avec un tableau toujours compact, donc : <UL><LI>on
 * mémorise le nombre d'éléments réellement présents dans le tableau
 * (à ne pas confondre avec la taille physique du tableau :
 * <code>length</code>)</LI> <LI>lorsqu'on retire un élément, on le
 * remplace par le dernier élément (celui d'indice
 * <code>nbAssoc-1</code>) (plus rapide qu'un décalage, et ici l'ordre
 * des éléments n'importe pas)</LI> <LI> l'ajout se fait toujours à
 * l'indice <code>nbAssoc</code></LI></UL>  */

public class TabDict implements Dictionnaire
{
private static final int INIT_SIZE = 100;            // taille initiale du tableau
private Couple [] associations;      // tableau contenant les associations
private int nbAssoc;      // nombre d'elements effectivement presents dans le dictionnaire

/** Crée une instance de dictionnaire vide */
public TabDict() {
        nbAssoc = 0;
        associations = new Couple[INIT_SIZE];
}

/** Chaîne de caractères représentant le dictionnaire */
public String toString() {
        String s = "";
        for (int i=0; i<nbAssoc; i++)
                s += associations[i] + "\n";
        return s;
}

// redimensionnement automatique du tableau en une taille double
private void resize() {
        Couple [] tmp = new Couple[2*associations.length];
        for (int i=0; i<associations.length; i++)
                tmp[i] = associations[i];
        associations = tmp;
}

// indique si le tableau est plein
private boolean estPlein() {
        return (nbAssoc == associations.length);
}

// ajoute une association à la première position libre (après avoir
// redimensionné le tableau si nécessaire)
private void add(Couple assoc) {
        if (estPlein()) resize();
        associations[nbAssoc] = assoc;
        nbAssoc++;
}

// enlève l'association à l'indice spécifié
private void remove(int index) {
        // 1e méthode : décalage de tous les éléments
        //	for (int i=index; i<nbAssoc-1; i++)
        //	    associations[i] = associations[i+1] ;
        // -> le nombre d'operations a faire est variable !
        // 2e méthode : on place le dernier élément à la place de
        // celui qu'on supprime
        associations[index] = associations[nbAssoc-1];
        nbAssoc--;
}

// indice de l'association assoc ; -1 si elle est absente
private int indexOf(Couple assoc) {
        for (int i=0; i<nbAssoc; i++)
                if (associations[i].equals(assoc))
                        return i;
        return -1;
}

// indice de l'association de clef c ; -1 si elle est absente
private int indexOfClef(Object c) {
        for (int i=0; i<nbAssoc; i++)
                if (associations[i].premier().equals(c))
                        return i;
        return -1;
}

// IMPLÉMENTATION DE L'INTERFACE Dictionnaire

/** Teste si le dictionnaire ne contient aucune association */
public boolean estVide() {
        return (nbAssoc == 0);
}

/** Teste si le dictionnaire contient l'association assoc */
public boolean contient(Couple assoc) {
        for (int i=0; i<nbAssoc; i++)
                if (associations[i].equals(assoc))
                        return true;
        return false;
}

/** Teste si le dictionnaire possède une association de clef c */
public boolean contientClef(Object c) {
        for (int i=0; i<nbAssoc; i++)
                if (associations[i].premier().equals(c))
                        return true;
        return false;
}

/** Teste si le dictionnaire possède une association de valeur v */
public boolean contientValeur(Object v) {
        for (int i=0; i<nbAssoc; i++)
                if (associations[i].second().equals(v))
                        return true;
        return false;
}

/** Retourne le nombre d'associations du dictionnaire */
public int nbElements() {
        return nbAssoc;
}

/** Retourne l'association correspondant à la clef spécifiée */
public Couple assocPour(Object c) {
        for (int i=0; i<nbAssoc; i++)
                if (associations[i].premier().equals(c))
                        return associations[i];
        return null;
}

/** Retourne la valeur associee à la clef c */
public Object valeurPour(Object c) {
        for (int i=0; i<nbAssoc; i++)
                if (associations[i].premier().equals(c))
                        return associations[i].second();
        return null;
}

/** Ajoute une association au dictionnaire */
public void ajouter(Couple assoc) {
        if (!contientClef(assoc.premier()))
                add(assoc);
        else
                associations[indexOfClef(assoc.premier())] = assoc;
}

/** Définit la valeur associée à la clef c */
public void ajouter(Object c, Object v) {
        if (!contientClef(c))
                add(new CoupleObj(c, v));
        else
                associations[indexOfClef(c)] = new CoupleObj(c, v);
}

/** Enlève une association du dictionnaire */
public void enlever(Couple assoc)
{
        if (contientClef(assoc.premier()))
                remove(indexOf(assoc));
}

/** Enlève l'association de clef c */
public void enleverPour(Object c)
{
        if (contientClef(c))
                remove(indexOfClef(c));
}
}
