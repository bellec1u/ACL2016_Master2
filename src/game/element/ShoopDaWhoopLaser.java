package game.element;

import game.TextureFactory;
import game.World;

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
	 * Returns Image[] of the ShoopDaWhoopLaser
	 */
	public Image[] getTexture() {
		return TextureFactory.getInstance().getShoopDaWhoop();
	}

	/**
	 * Updates ShoopDaWhoopLaser's position
	 * @param delta lap of time between 2 displays
	 */
	public void update(double delta) {
		Point2D shipPosition = ship.getPosition();
		// if the all Laser has to be display then
		setPosition((int)shipPosition.getX() - (int)(ship.getWidth() / 4) - 2, (int)shipPosition.getY() - HEIGHT);
	}

	/** Returns ShoopDaWhoopLaser's speed **/
	public double getSpeed() {
		return SPEED;
	}
	
	/** Returns the variable startShoot (time when the Laser was shot) **/
	public long getStartShoot() {
		return this.startShoot;
	}

	/** Returns Image of the ShoopDaWhoopLaser **/
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
	 * The definition here is a bit different (than in the other Laser),
	 * this Laser is in fact an image so we cannot check if the Image is
	 * out or in the World, BUT we decided to remove it when
	 * a time of 2s is passed.
	 */
	public boolean isOutOfScreen() {
		return (startShoot + 2000 < System.currentTimeMillis());
	}
	
}
