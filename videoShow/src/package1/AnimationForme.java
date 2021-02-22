package package1;

import java.awt.Graphics;

public class AnimationForme implements IObjetAnimable {
    
    private Forme forme;
    private IFormeAnimable formeAnimable;

    public AnimationForme(Forme forme, IFormeAnimable formeAnimable) {
        this.forme = forme;
        this.formeAnimable = formeAnimable;
    }

  
    public void deplacer() {
        this.formeAnimable.deplacer(this.forme);
    }

    @Override
    public void dessiner(Graphics g) {
        this.forme.dessiner(g);
    }


	
    
    
    

}
