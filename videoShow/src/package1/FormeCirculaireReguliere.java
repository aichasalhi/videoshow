package package1;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

/**
 * Une forme régulière dont les sommets sont répartis de façon uniforme sur le
 * cercle où elle est inscrite.
 *
 */
public abstract class FormeCirculaireReguliere extends FormeCirculaire {

    /**
     * l'objet Path correspondant au contour de la forme régulière, exprimé dans
     * le repère dont l'origine est le centre du cercle où elle est inscrite.
     */
    protected Path2D contour;

    /**
     * Constructeur. Ce constructeur n'effectue que l'étape 1), le calcul des
     * sommets sur le cercle. L'étape 2 devra être réalisée dans les sous-classes
     * concrêtes.
     *
     * @param nbSommets le nombre de sommets du polygone regulier
     * @param x abscisse du centre
     * @param y ordonnée du centre
     * @param r rayon
     * @param epTrait l'epaisseur du trait de contour
     * @param cTrait couleur du trait de contour
     * @param cRemp couleur remplissage
     */
    protected FormeCirculaireReguliere(int nbSommets, int x, int y, int r,
            float epTrait, Color cTrait, Color cRemp) {
        // appel du constructeur de la super classe
        super(x, y, r, epTrait, cTrait, cRemp);

        // Etape 1
        // calcul des sommets répartis régulièrement sur le cercle
        float deltaAngle = 360f / nbSommets;
        float angle = -90;
        Point2D.Float[] sommets = new Point2D.Float[nbSommets];
        for (int i = 0; i < nbSommets; i++) {
            sommets[i] = new Point2D.Float((float) Math.cos(Math.toRadians(angle)) * r,
                    (float) Math.sin(Math.toRadians(angle)) * r);
            angle += deltaAngle;
        }
        // Etape 2, 
        // construction du chemin reliant les sommets devra a être réalisée dans 
        // les constructeurs des sous-classes concrêtes. 
        // Pour obliger les sous-classes à effectuer cette construction, 
        // on invoque ici une méthode abstraite qui devra être
        // redéfinie dans les sous-classes.
        contour = construireContour(sommets);
        // L'appel d'une méthode dans un constructeur n'est pas recommandé 
        // du fait des effets indésirables pouvant exister en cas de redéfinition, 
        // (voir l'exemple de getRectangleEngloabnt dans les transparent du cours.
        // Dans ce cas il est conseillé de définir cette méthode comme étant finale.
        // mais ici, on peut le faire, car la méthode est abstraite.
    }

    /**
     * Méthode abstraite appelée dans le constructeur construit le contour
     * de la forme (Path2D) à partir des sommets calculés sur le cercle. 
     *
     * @param tabSommets le tableau des sommets.
     * @return le contour de la forme.
     */
    protected abstract Path2D construireContour(Point2D.Float[] tabSommets);
    
   
    public void dessiner(Graphics g) {
        // on fait une copie du contexte graphique
        Graphics2D g2 = (Graphics2D) g.create();
        // on applique la transformation de coordonnées pour placer
        // le centre du cercle en (x, y)
        g2.translate(x, y);

        // Etape 3
        // on dessine le contour de la forme
        // avec la couleur de trait spécifiée ou la couleur courante
        // du contexte graphique sinon
        if (couleurTrait != null) {
            g2.setColor(couleurTrait);

        }
        g2.setStroke(new BasicStroke(epaisseurTrait));
        g2.draw(contour);

        // Etape 4
        // remplissage de l'intérieur de la forme 
        if (couleurRemplissage != null) {
            g2.setColor(couleurRemplissage);
            g2.fill(contour);
        }
    }
}
