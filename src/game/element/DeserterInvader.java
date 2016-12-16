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
public class DeserterInvader extends Invader  {

	/** Speed of a BasicInvader **/
	private final static double SPEED = 180.0; // 3 pixels every refresh call

	/** Dimension (width and height) **/
	private final static int WIDTH = 4;	
	private final static int HEIGHT = 4;

	/** Score value**/
	public static final int SCORE = 20;

	/**
	 * Constructs a BasicSpaceShip with given arguments
	 * @param pos the position
	 */
	public DeserterInvader(Point2D pos) {
		super(pos, new Rectangle2D.Double(pos.getX(),  pos.getY(),  WIDTH,  HEIGHT));
		this.turnDown();
	}

	/** Returns Invader's score value **/
	public int getScore() {
		return SCORE;
	}

	/**
	 * Returns Image[] of a DeserterInvader
	 */
	public Image[] getTexture() {
		return TextureFactory.getInstance().getDeserterImg();
	}

	/**
	 * Updates DeserterInvader's position
	 * @param delta lap of time between 2 displays
	 */
	public void update(double delta) {
		move(delta);
	}

	/** Returns DeserterInvader's speed **/
	public double getSpeed() {
		return SPEED;
	}

	/**
	 * DeserterInvader cannot have deserters, so always return false.
	 */
	public boolean hasDeserters() {
		return false;
	}

	/**
	 * Returns Image of a DeserterInvader
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
     * Returns HEIGHTT of the GameElement;
     */
    public int getHeight() {
    	return HEIGHT;
    }
}
