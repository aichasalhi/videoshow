package package1;

import java.awt.Color;

/**
 * Une forme géométrique pouvant être affichée dans une zone de dessin.
 */
public abstract class Forme implements IObjetDessinable {

    /**
     * coordonnées du point de référence de la forme
     */
    protected int x, y;

    /**
     * l'épaisseur du trait pour le contour.
     */
    protected float epaisseurTrait = 1.0f;

    /**
     * La couleur utilisée pour dessiner le contour la forme. si cette couleur
     * est nulle, La couleur utilisée sera celle du contexte graphique (l'objet
     * Graphics passé en paramètre de la méthode dessiner).
     */
    protected Color couleurTrait = null;

    /**
     * La couleur de remplissage de la forme. Si cette couleur est nulle seul le
     * contour de la forme sera dessiné (par exemple pour un Cercle), ou si il
     * s'agit d'une forme pleine (par exemple un Disque), la couleur utilisée
     * sera la couleur courante du contexte graphique.
     */
    protected Color couleurRemplissage;

    /**
     * Constructeur
     *
     * @param x abscisse du point de référence de la forme
     * @param y ordonnée du point de référence de la forme
     * @param epaisseurTrait l'epaisseur du trait pour le contour de la forme
     * @param couleurTrait la couleur du trait de contour
     * @param couleurRemplissage la couleur de remplissage
     */
    protected Forme(int x, int y, float epaisseurTrait,
            Color couleurTrait,
            Color couleurRemplissage) {
        this.x = x;
        this.y = y;
        this.couleurRemplissage = couleurRemplissage;
        this.couleurTrait = couleurTrait;
        this.epaisseurTrait = epaisseurTrait;
    }

    /**
     * @return abscisse du point de référence de la forme
     */
    public int getX() {
        return x;
    }

    /**
     * @return ordonnée du point de référence de la forme
     */
    public int getY() {
        return y;
    }

    /**
     * change la position du point de référence de la forme
     * @param x nouvelle abscisse du point de référence de la forme
     * @param y nouvelle ordonnée du point de référence de la forme
     */
    public void placerA(int x, int y) {
        this.x = x;
        this.y = y;
    }

    
}
