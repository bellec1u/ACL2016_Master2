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
public class SpecialShootBonus extends Bonus {

	/** Speed of a bonus **/
	private final double SPEED = 90.0; // 1.5 pixels every refresh call

	/** Dimension (width and height) **/
	private final static int WIDTH = 24;	
	private final static int HEIGHT = 16;
	
	public SpecialShootBonus(Point2D pos) {
		super(pos, new Rectangle2D.Double(pos.getX(),  pos.getY(),  WIDTH,  HEIGHT));
		this.turnDown();
	}

	/**
	 * Returns Image[] of a SpecialShootBonus
	 */
	public Image[] getTexture() {
		return TextureFactory.getInstance().getSpecialShootBonus();
	}
	
	/**
	 * Updates the SpecialShootBonus' position
	 * @param delta lap of time between 2 displays
	 */
	public void update(double delta) {
		move(delta);
	}

	/** Returns SpecialShootBonus' speed **/
	public double getSpeed() {
		return SPEED;
	}

	/** Returns Image of a SpecialShootBonus **/
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
     * 
     * Returns HEIGHTT of the GameElement;
     */
    public int getHeight() {
    	return HEIGHT;
    }

	/**
	 * Increments the number of specialShot possible of the SpaceShip
	 */
	public void applyBonus(SpaceShip spaceShip) {
		spaceShip.addSpecialShoot();
	}

}
