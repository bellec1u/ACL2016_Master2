package game.element;

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
public class BasicInvader extends Invader{

	/** Speed of a BasicInvader **/
	private static final double spd = 3.0;
	
	/**
	 * Constructs a BasicSpaceShip with given arguments
	 * @param pos the position
	 */
	public BasicInvader(Point2D pos) {
		super(pos, spd);
		turnDown();
		isMoving = true;
	}

	@Override
	public void update(double delta) {
		move(delta);
	}
}
