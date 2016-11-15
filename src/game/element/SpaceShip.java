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
	
	public SpaceShip(Point2D pos, Rectangle2D box,  double spd) {
		super(pos, box, spd);
		lasers = new ArrayList<Laser>();
	}

	/** Shot a Laser **/
	public abstract void shoot();
}
