package game.element;

import game.TextureFactory;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

/**
 * Project "Space Invader"
 * M1 Informatique 2016/2017
 * @author BELLEC Leopold
 * @author DAUZVARDIS Juozas
 * @author JUNGES Pierre-Marie
 * @author LIPSKI Guillaume
 *
 */
public class BasicSpaceShip extends SpaceShip{

	/** Speed of a BasicSpaceShip **/
	private static final double spd = 3.0;
	
	/**
	 * Constructs a BasicSpaceShip with given arguments
	 * @param pos the position
	 */
	public BasicSpaceShip(Point2D pos) {
		super(pos, spd);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(double delta) {
		// TODO Auto-generated method stub
		move(delta);
	}

	@Override
	public BufferedImage getTexture() {
		return TextureFactory.getInstance().getSpaceShipImg();
	}

}
