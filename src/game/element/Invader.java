package game.element;

import game.World;

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
public abstract class Invader extends GameElement{

	/**
	 * 
	 * Constructs a Invader with the given parameter(s)
	 * @param pos the Invader's position
	 * @param box the Invader's bounding box
	 * @param spd the current speed
	 */
	public Invader(Point2D pos, Rectangle2D box) {
		super(pos, box);
	}

	/** Returns Invader's score value **/
	public abstract int getScore() ;
	
	public boolean isOutOfScreen() {
		return position.getY() > World.HEIGHT;
	}
	
	public abstract boolean canShot();

}
