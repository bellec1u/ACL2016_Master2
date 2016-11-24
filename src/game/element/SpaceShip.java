package game.element;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
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
public abstract class SpaceShip extends GameElement{

	/** Laser's list **/
	protected List<Laser> lasers;
	
	/**
	 * 
	 * Constructs a SpaceShip with the given parameter(s)
	 * @param pos the SpaceShip's position
	 * @param box the SpaceShip's bounding box
	 * @param spd the current speed
	 */
	public SpaceShip(Point2D pos, Rectangle2D box) {
		super(pos, box);
		lasers = new LinkedList<Laser>();
	}

	/** Shoot a Laser **/
	public abstract void shoot();

	public boolean manageLaserCollision(Invader invader) {
		// gestion collision
		//V 2.1
		Boolean hasCollision = false;
		//
		
		Iterator<Laser> l = this.lasers.iterator();
	    while (l.hasNext()) {
	    	Laser laser = l.next();
	    	
	    	if (hasCollision) {
	    		//this.deleteLaser(laser);
	    		return true;
	    	}
	    	
	    }
	    
	    return false;
		
	}
	
	/**
	 * Deletes the Laser laser whom is out of screen
	 * @param laser The Laser to remove from the List
	 */
	public void deleteLaser(Laser laser) {
		lasers.remove(laser);
	}

}
