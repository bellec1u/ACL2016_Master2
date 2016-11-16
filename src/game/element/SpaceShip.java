package game.element;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
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
public abstract class SpaceShip extends GameMoveableElement{

	/** Laser's list **/
	protected List<Laser> lasers;
	
	/**
	 * 
	 * Constructs a SpaceShip with the given parameter(s)
	 * @param pos the SpaceShip's position
	 * @param box the SpaceShip's bounding box
	 * @param spd the current speed
	 */
	public SpaceShip(Point2D pos, Rectangle2D box,  double spd) {
		super(pos, box, spd);
		lasers = new ArrayList<Laser>();
	}

	/** Shoot a Laser **/
	public abstract void shoot();
}
