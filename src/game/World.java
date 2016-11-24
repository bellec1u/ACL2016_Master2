package game;

import game.element.BasicInvader;
import game.element.BasicSpaceShip;
import game.element.GameElement;
import game.element.Invader;
import game.element.SpaceShip;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Project "Space Invader"
 * M1 Informatique 2016/2017
 * @author BELLEC Leopold
 * @author DAUZVARDIS Juozas
 * @author JUNGES Pierre-Marie
 * @author LIPSKI Guillaume
 *
 */
public class World {
    
	/** World dimensions **/
    public final static int WIDTH = 500;
    public final static int HEIGHT = 600;
    
    
    /** Invaders and SpaceShip(Player) **/
    private List<Invader> invaders;
    private SpaceShip spaceShip; 
    
    public World() {
    	invaders = new LinkedList<Invader>();
    	int nbInvaders = 1;
    	for (int i = 1; i < (nbInvaders + 1); i++) {
    		invaders.add(new BasicInvader(new Point2D.Double((24+5) * i, 16)));
    	}
        this.spaceShip = new BasicSpaceShip(new Point2D.Double(WIDTH/2, HEIGHT-100));
        this.spaceShip.setRelativePosition(-spaceShip.getBoundingBox().getWidth()/2, 0);
    }
    
	public Invader getInvader() {
		return invaders.get(0);
	}

	public SpaceShip getSpaceShip() {
		return spaceShip;
	}
	
	public void deleteInvader(Iterator<Invader> it) {
	    it.remove();
	}
	
	public void update(double delta) {
	    spaceShip.update(delta);
	    
	    Iterator<Invader> it = invaders.iterator();
	    while (it.hasNext()) {
	        Invader invader = it.next();
	    	invader.update(delta);
	    	
	    	if (invader.isOutOfScreen()) {
                deleteInvader(it);
            }
	    }
	}
	
	public void render(Graphics g) {
	    spaceShip.render(g);
	    for (Invader invader : invaders) {
	    	invader.render(g);
	    }
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("INVADER :\n");
        for (Invader invader : invaders) {
        	sb.append(invader.toString());
        }
        sb.append("\n-------------------------\n");
        sb.append("SPACE SHIP :\n");
        sb.append(spaceShip.toString());
        
        return sb.toString();
    }
}
