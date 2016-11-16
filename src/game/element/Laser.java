package game.element;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Project "Space Invader"
 * M1 Informatique 2016/2017
 * @author BELLEC Leopold
 * @author DAUZVARDIS Juozas
 * @author JUNGES Pierre-Marie
 * @author LIPSKI Guillaume
 *
 */
public abstract class Laser extends GameMoveableElement{

	/**
	 * 
	 * Constructs a Laser with the given parameter(s)
	 * @param pos the Laser's position
	 * @param box the Laser's bounding box
	 * @param spd the current speed
	 */
	public Laser(Point2D pos, Rectangle2D box,  double spd) {
		super(pos, box, spd);
		// TODO Auto-generated constructor stub
	}

}
