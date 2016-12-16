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
	
	/** Indicates if the Invader is out of screen,
	 * in order to do so, we check if his current Y position is greater than
	 * the World's HEIGHT, if so that function returns true else false.
	 **/
	public boolean isOutOfScreen() {
		return position.getY() > World.HEIGHT;
	}
	

	/**
	 * Indicates if the Invader has potentials deserters in it.
	 * Every Invaders have a different way to test it.
	 */
	public abstract boolean hasDeserters();

}
