package game;

import java.awt.Graphics;
import java.awt.geom.Point2D;

import game.element.BasicInvader;
import game.element.BasicSpaceShip;
import game.element.Invader;
import game.element.SpaceShip;

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
    
    public final static int WIDTH = 500;
    public final static int HEIGHT = 600;
    
    public Invader invader;
    public SpaceShip spaceShip; 
    
    public World() {
        this.invader = new BasicInvader(new Point2D.Double(10, 10));
        this.spaceShip = new BasicSpaceShip(new Point2D.Double(WIDTH/2-15, HEIGHT-100));
    }
    
	public Invader getInvader() {
		return invader;
	}

	public SpaceShip getSpaceShip() {
		return spaceShip;
	}
	
	public void update(double delta) {
	    spaceShip.update(delta);
	    invader.update(delta);
	}
	
	public void render(Graphics g) {
	    spaceShip.render(g);
	    invader.render(g);
	}
	

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("INVADER :\n");
        sb.append(invader.toString());
        sb.append("\n-------------------------\n");
        sb.append("SPACE SHIP :\n");
        sb.append(spaceShip.toString());
        
        return sb.toString();
    }
}
