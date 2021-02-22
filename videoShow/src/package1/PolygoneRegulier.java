package package1;

import java.awt.Color;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

/**
 * Un polygone régulier inscrit dans un cercle
 *
 */
public class PolygoneRegulier extends FormeCirculaireReguliere {

    /**
     * @param nbSommets le nombre de sommets du polygone regulier
     * @param x abscisse du centre
     * @param y ordonnée du centre
     * @param r rayon
     * @param epTrait l'epaisseur du trait
     * @param cTrait couleur du trait
     * @param cRemp couleur remplissage
     */
    public PolygoneRegulier(int nbSommets, int x, int y, int r,
            float epTrait, Color cTrait, Color cRemp) {
        super(nbSommets, x, y, r, epTrait, cTrait, cRemp);
    }

    /**
     * calcule le chemin contour de la forme polygonale. Les sommets répartis
     * sur le cercle sont réliés de manière consécutive.
     * @param tabSommets le tableau des sommets.
     * @return le contour de la forme.
     */
    @Override
    protected Path2D construireContour(Point2D.Float[] tabSommets) {

        // Etape 2
        // construction du chemin reliant les points sur le cercle
        Path2D leContour = new Path2D.Float();

        leContour.moveTo(tabSommets[0].getX(), tabSommets[0].getY());
        for (int i = 1; i < tabSommets.length; i++) {
            leContour.lineTo(tabSommets[i].getX(), tabSommets[i].getY());
        }
        leContour.closePath();
        return leContour;
    }

	@Override
	public void deplacer() {
		// TODO Auto-generated method stub
		
	}

}
