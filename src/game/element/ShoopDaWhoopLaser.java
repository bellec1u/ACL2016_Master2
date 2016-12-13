package game.element;

import game.TextureFactory;
import game.World;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class ShoopDaWhoopLaser extends Laser{


	/** Speed of a BasicLaser **/
	private static final double SPEED = 0.0; // 3 pixels every refresh call
	
	/** Dimension (width and height) **/
	private final static int WIDTH = 49;	
	private final static int HEIGHT = World.HEIGHT;

	private long startShoot = -1;
	
	/** Image index **/
	private int index;
	
	/**
	 * Constructs a BasicSpaceShip with given arguments
	 * @param pos the position
	 */
	public ShoopDaWhoopLaser(Point2D pos) {
		super(pos, new Rectangle2D.Double(pos.getX(),  pos.getY(),  0,  0));
		this.index = 0;
		this.startShoot = System.currentTimeMillis();
	}

	/**
	 * Returns Image[] of a BasicLaser
	 */
	@Override
	public Image[] getTexture() {
		return TextureFactory.getInstance().getShoopDaWhoop();
	}

	/**
	 * Updates BasicLaser's position
	 * @param delta lap of time between 2 displays
	 */
	@Override
	public void update(double delta) {
		move(delta);
		
		if (System.currentTimeMillis() - this.startShoot >= 2700) {
			setBoundingBox( new Rectangle2D.Double(this.position.getX(), this.position.getY(), WIDTH, HEIGHT) );
			setRelativePosition(0, (HEIGHT + 490)); // + 490 ?
			index = 1;
		} else {
			setRelativePosition( -15 , 492 ); // 492 ? -15 ? 
			index = 0;
		}
	}

	@Override
	public double getSpeed() {
		return SPEED;
	}

	/**
	 * Returns Image of a ShoopDaWhoopLaser
	 */
	public Image getImage() {
		return getTexture()[index];
	}
	
}
