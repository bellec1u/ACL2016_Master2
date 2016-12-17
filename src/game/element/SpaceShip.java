package game.element;

import game.World;

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
	protected int lives;
	
	protected int nbSpecialShoot;
	protected int nbMaxSpecialShoot = 3;
	
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
	
	/** Returns laser list **/
	public List<Laser> getListLasers() {
		return lasers;
	}
	
	/** Returns SpaceShip's life **/
	public int getLives() {
	    return lives;
	}
	
	/** Returns true if the SpaceShip's life is lower or equals than 0 **/
	public boolean isWrecked() {
	    return lives <= 0;
	}
	
	/** Decrements the SpaceShip's life by 1 **/
	public void decrementLives() {
		if(lives>0){
			--lives;
		}
	}

	/** Shoot a Laser **/
	public abstract void shoot();
	
	/** Use special Shoot**/
	public abstract void specialShoot();

	/**
	 * Manages the Collision between one Invader and the SpaceShip's lasers
	 * @param invader the Invader to test
	 * @return true if collision else false
	 */
	public boolean manageLaserCollision(Invader invader) {

		Iterator<Laser> l = this.lasers.iterator();
	    while (l.hasNext()) {
	    	Laser laser = l.next();
	    	
	    	if ( invader.hasCollision(laser) ) {
	    		/**
	    		 * We delete every lasers except the ShoopDaWhoopLaser
	    		 * if there is one in the list lasers.
	    		 */
	    		if (!(laser instanceof ShoopDaWhoopLaser)) {
	    			this.deleteLaser(laser);
	    		}
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

	/**
	 * Returns the number of Laser in the Laser list
	 */
	public int getNbLaser() {
		return lasers.size();
	}
	
	/**
	 * Returns Laser i, used for test
	 */
	public Laser getLaser(int i) {
		if(i >= 0 && i < lasers.size()) {
			return lasers.get(i);
		}
		
		return null; // unreachable
	}

	/** Adds 1 to the current variable lives **/
	public void addLife() {
		this.lives++;
	}

	/** Decrements the number of specialShoot available **/
	public void decrementSpecialShoot() {
		this.nbSpecialShoot--;
	}

	/** Returns the variable nbSpecialShoot **/
	public int getNbSpecialShoot() {
		return this.nbSpecialShoot;
	}
	
	/** Returns the variable nbMaxSpecialShoot **/
	public int getNbMaxSpecialShoot() {
		return this.nbMaxSpecialShoot;
	}

	/** Adds 1 to the current variable nbMaxSpecialShoot **/
	public void addSpecialShoot() {
		if ( nbSpecialShoot < nbMaxSpecialShoot ) {
			this.nbSpecialShoot++;
		}
	}

	/**
	 * Indicates if the SpaceShip is out of screen,
	 * in order to do so,
	 * we will check if the x position is greater than World.WIDTH or lower than 0.
	 */
	public boolean isOutOfScreen() {
		Point2D position = getPosition();
		return (position.getX() < 0 || position.getX() > World.WIDTH);
	}
}
