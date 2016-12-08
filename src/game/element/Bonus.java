package game.element;

import game.World;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public abstract class Bonus extends GameElement {

	public Bonus(Point2D pos, Rectangle2D box) {
		super(pos, box);
	}
	
	/**
	 * Indicates if the Laser is out of screen,
	 * in order to do so,
	 * we will check if the y axis is stricly < 0
	 */
	public boolean isOutOfScreen() {
		return position.getY() > World.HEIGHT;
	}

}
