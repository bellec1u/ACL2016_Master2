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
public abstract class Bonus extends GameElement {

	public Bonus(Point2D pos, Rectangle2D box) {
		super(pos, box);
	}
	
	/**
	 * Indicates if the Laser is out of screen,
	 * in order to do so,
	 * we will check if the y axis is stricly > World.HEIGHT
	 */
	public boolean isOutOfScreen() {
		return position.getY() > World.HEIGHT;
	}

}
