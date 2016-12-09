package game.element;

import game.TextureFactory;

import java.awt.Image;
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
public class BasicLaser extends Laser{


	/** Speed of a BasicLaser **/
	private static final double SPEED = 180.0; // 3 pixels every refresh call
	
	/** Dimension (width and height) **/
	private final static int WIDTH = 4;	
	private final static int HEIGHT = 16;
	
	/**
	 * Constructs a BasicSpaceShip with given arguments
	 * @param pos the position
	 */
	public BasicLaser(Point2D pos) {
		super(pos, new Rectangle2D.Double(pos.getX(),  pos.getY(),  WIDTH,  HEIGHT));
		turnUp();
	}

	/**
	 * Returns Image[] of a BasicLaser
	 */
	@Override
	public Image[] getTexture() {
		return TextureFactory.getInstance().getShootImg();
	}

	/**
	 * Updates BasicLaser's position
	 * @param delta lap of time between 2 displays
	 */
	@Override
	public void update(double delta) {
		move(delta);
	}

	@Override
	public double getSpeed() {
		return SPEED;
	}

	/**
	 * Returns Image of a BasicLaser
	 */
	public Image getImage() {
		return getTexture()[0];
	}

}
