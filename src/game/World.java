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
    public final static int HEIGHT = 200;
    
    private Invader invader;
    private SpaceShip spaceShip; 
    
    public World() {
        this.invader = new BasicInvader(new Point2D.Double(10, 10));
        this.spaceShip = new BasicSpaceShip(new Point2D.Double(150, 100));
    }
    
    public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}

	public Invader getInvader() {
		return invader;
	}

	public SpaceShip getSpaceShip() {
		return spaceShip;
	}

	@Override
    public String toString() {
    
        return "";
    }
}
