package package1;

import java.awt.Graphics;

public class CercleDebut extends Cercle{
	 //------- variables d'instance (attributs) --------------------------
    /**
     * pointe du d�but du train Cercle; Exprim� en degr�s
     */
    protected double pointe;

    //-------- Constructeurs ---------------------------------------------
    /**
     * cr�er le d�but du train Cercle en fixant sa position initiale, son rayon et sa pointe
     *
     * @param xInit abscisse du centre u cercle
     * @param yInit ordonn�e du centre du cercle
     * @param rInit rayon du cercle
     * @param cInit la pointe intial (en degr�s)
     */
    public CercleDebut(int xInit, int yInit, int rInit, double cInit) {
        super(xInit, yInit, rInit);
        pointe = cInit;
    }

    /**
     * cr�e un d�but de train Cercle en fixant sa position initiale. Son rayon et sa pointe sont
     * fix�s avec les valeurs par d�faut.
     *
     * @param xInit abscisse du centre du cercle
     * @param yInit ordonn�e du centre du cerclce
     */
    public CercleDebut(int xInit, int yInit) {
        this(xInit, yInit, R, 0.0);
    }

    //-------- M�thodes ---------------------------------------------  
    /**
     * affiche le d�but du train Cercle en la mat�rialisant par un disque noir
     *
     * @param g cet objet de classe Graphics pass� en param�tre est l'objet qui
     * prend en charge la gestion de l'affichage dans la fen�tre de dessin.
     * C'est cet objet qui g�re le contexte graphique" pour cette fen�tre.
     */
    @Override
    public void dessiner(Graphics g) {
        g.fillOval(x - r, y - r, 2 * r, 2 * r);
    }

    private double normalize(double d) {
        double res = Math.abs(d) % 360;
        if (d < 0) {
            if (res > 180) {
                res = 360 - res;
            } else {
                res = -res;
            }
        } else {
            if (res > 180) {
                res = -(360 - res);
            }
        }
        return res;
    }

    /**
     * Modifie la pointe du train Cercle. La pointe courante du train cercle est modifi�
     * en lui ajoutant une variation de la pointe pass�e en param�tre.
     *
     * @param deltaC la variation &� appliquer � la pointe de la chenille (en degr�s).
     */
    public void devierPointe(double deltaC) {
        pointe += deltaC;
        pointe = normalize(pointe);
    }

    /**
     * deplace le centre du train cercle de mani�re à ce que le d�placement
     * effectu� corresponde à un d�placement d'une distance egale au rayon du
     *  d�but du train  dans la direction indiqu�e par la pointe.
     */
    public void deplacerSelonPointe() {
        x = (int) (x + r * Math.cos(Math.PI * pointe / 180));
        y = (int) (y + r * Math.sin(Math.PI * pointe / 180));
    }

    /**
     * teste si la pointe actuel garantit que prochain déplacement du d�but du train Cercle selon
     * sa pointe maintiendra celle-ci entièrement dans la zone de dessin.
     *
     * @param xMax la taille en x de la zone de dessin
     * @param yMax la taille en y de la zone de dessin
     *
     * @return true la point (x',y') défini par x' = x + R * cos(pointe) et 
     *         y' = y + R * sin(pointe) est à une distance >= R de chacun des
     *         bords de la zone.
     */ 
    public boolean pointeOK(int xMax, int yMax) {
        int x1 = (int) (x + r * Math.cos(Math.PI * pointe / 180));
        int y1 = (int) (y + r * Math.sin(Math.PI * pointe / 180));

        return x1 >= r && x1 <= (xMax - r) && y1 >= r & y1 <= (yMax - r);
    }
}
