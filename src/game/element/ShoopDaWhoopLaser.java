package game.element;

import game.TextureFactory;
import game.World;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class ShoopDaWhoopLaser extends Laser{


	/** Speed of a BasicLaser **/
	private static final double SPEED = 0.0; // 0 pixel every refresh call
	
	/** Dimension (width and height) **/
	private final static int WIDTH = 49;
	private final static int HEIGHT = ( World.HEIGHT - 100 );

	private long startShoot;

	/**
	 * Attached SpaceShip
	 */
	private SpaceShip ship;
	
	/**
	 * Constructs a BasicSpaceShip with given arguments
	 * @param pos the position
	 */
	public ShoopDaWhoopLaser(SpaceShip spaceShip, Point2D pos) {
		super(pos, new Rectangle2D.Double(pos.getX(),  pos.getY(),  WIDTH,  HEIGHT));
		this.ship = spaceShip;
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
		Point2D shipPosition = ship.getPosition();
		// if the all Laser has to be display then
		setPosition((int)shipPosition.getX() - (int)(ship.getWidth() / 4) - 2, (int)shipPosition.getY() - HEIGHT);
	}

	@Override
	public double getSpeed() {
		return SPEED;
	}
	
	public long getStartShoot() {
		return this.startShoot;
	}

	@Override
	public Image getImage() {
		return getTexture()[0];
	}	
	
    /**
     * Returns WIDTH of the GameElement
     */
    public int getWidth() {
    	return WIDTH;
    }
    
    /**
     * Returns HEIGHT of the GameElement;
     */
    public int getHeight() {
    	return HEIGHT;
    }
    
	/**
	 * Indicates if the Laser is out of screen,
	 * in order to do so,
	 * we will check if the y axis is stricly < 0
	 */
	@Override
	public boolean isOutOfScreen() {
		return (startShoot + 2000 < System.currentTimeMillis());
	}
	
}
