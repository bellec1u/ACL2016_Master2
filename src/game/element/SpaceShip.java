package game.element;

import game.SoundFactory;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.sound.sampled.Clip;

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
	protected int lives;
	protected boolean shootShoopDaWhoop = false;
	
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
	
	/** Retursn laser list **/
	public List<Laser> getListLasers() {
		return lasers;
	}
	
	public int getLives() {
	    return lives;
	}
	
	public boolean isWrecked() {
	    return lives <= 0;
	}
	
	public void decrementLives() {
		if(lives>0){
			--lives;
		}
	}

	/** Shoot a Laser **/
	public abstract void shoot();

	public boolean manageLaserCollision(Invader invader) {

		Iterator<Laser> l = this.lasers.iterator();
	    while (l.hasNext()) {
	    	Laser laser = l.next();
	    	
	    	if (this.hasCollision(invader, laser)) {
	    		if (!(laser instanceof ShoopDaWhoopLaser)) {
	    			this.deleteLaser(laser);
	    		}
	    		return true;
	    	}
	    	
	    }
	    
	    return false;
		
	}
	
	private boolean hasCollision(Invader invader, Laser laser) {
		if (invader.getBoundingBox().intersects(laser.getBoundingBox())) {
			return true;
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
	
	public void deleteLaserShoopDaWhoop() {
		ShoopDaWhoopLaser laser = (ShoopDaWhoopLaser) lasers.get( this.lasers.size()-1 );
		laser.stopSound();
		lasers.remove( laser );
	}

	/**
	 * Returns the number of Laser in the Laser list
	 */
	public int getNbLaser() {
		return lasers.size();
	}
	
	/**
	 * Returns Laser i, use for test
	 */
	public Laser getLaser(int i) {
		if(i >= 0 && i < lasers.size()) {
			return lasers.get(i);
		}
		
		return null; // unreachable
	}

	public void startShootShoopDaWhoop() {
		this.shootShoopDaWhoop = true;
	}
	
	public void endShootShoopDaWhoop() {
		this.shootShoopDaWhoop = false;
		this.deleteLaserShoopDaWhoop();
	}

}
