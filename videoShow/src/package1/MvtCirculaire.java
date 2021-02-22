package package1;



public class MvtCirculaire implements IFormeAnimable {

    /**
     * rayon du cercle sur lequel l'animateur déplace la forme
     */
    private final int rayon;
    
    /**
     * abscisse du centre du cercle sur lequel l'animateur déplace la forme
     */
    private final int xc;
    
    /**
     * ordonnée du centre du cercle sur lequel l'animateur déplace la forme
     */
    private final int yc;
    
    /**
     * angle où se situe le point de référence de la forme animée.
     */
    private double angle;
    
    /**
     * variation de l'angle de rotation à chaque pas d'animation
     */
    private final double deltaAngle;

    public MvtCirculaire(int xc, int yc, int r, double angle, double deltaAngle) {
        this.deltaAngle = deltaAngle;
        this.angle = angle;
        this.rayon = r;
        this.xc = xc;
        this.yc = yc;
    }

    @Override
    public void deplacer(Forme f) {
        angle += deltaAngle;
        double angleRadians = Math.toRadians(angle);
        f.placerA((int) (xc + rayon * Math.cos(angleRadians)),
                (int) (yc + rayon * Math.sin(angleRadians)));
    }

	


}
