package game;

import game.element.BasicInvader;
import game.element.BasicSpaceShip;
import game.element.Invader;
import game.element.SpaceShip;

import java.awt.geom.Point2D;

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
    
    public final static int WIDTH = 200;
    public final static int HEIGHT = 400;
    
    public Invader invader;
    public SpaceShip spaceShip; 
    
    public World() {
        this.invader = new BasicInvader(new Point2D.Double(10, 10));
        this.spaceShip = new BasicSpaceShip(new Point2D.Double(150, 100));
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
