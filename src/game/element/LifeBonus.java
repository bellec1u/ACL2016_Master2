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
public class LifeBonus extends Bonus {

	/** Speed of a bonus **/
	private final double SPEED = 60.0; // 1 pixel every refresh call

	/** Dimension (width and height) **/
	private final static int WIDTH = 24;	
	private final static int HEIGHT = 16;
	
	public LifeBonus(Point2D pos) {
		super(pos, new Rectangle2D.Double(pos.getX(),  pos.getY(),  WIDTH,  HEIGHT));
		this.turnDown();
	}

	/**
	 * Returns Image[] of a LifeBonus
	 */
	public Image[] getTexture() {
		return TextureFactory.getInstance().getLifeBonus();
	}
	
	/** Updates LifeBonus' positions in the game **/
	public void update(double delta) {
		move(delta);
	}
	
	/**
	 * Increments the SpaceShip's life
	 */
	public void applyBonus(SpaceShip spaceShip) {
		spaceShip.addLife();
	}

	/** Returns LifeBonus's speed **/
	public double getSpeed() {
		return SPEED;
	}

	/**
	 * Returns Image of LifeBonus
	 */
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
	
}
