package game.element;

import game.TextureFactory;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * Project "Space Invader"
 * M1 Informatique 2016/2017
 * @author BELLEC Leopold
 * @author DAUZVARDIS Juozas
 * @author JUNGES Pierre-Marie
 * @author LIPSKI Guillaume
 *
 */
public class Bomb extends Invader  {

	/** Speed of a BasicInvader **/
	private static final double SPEED = 180.0; // 3 pixels every refresh call
	private static final int TEXTURE_CHANGE_DELAY = 500;

	/** Dimension (width and height) **/
	private final static int WIDTH = 4;	
	private final static int HEIGHT = 4;

	/** Attributes used to manage the Element's animation **/
	private int textureIndex;
	private long lastTextureChange;

	/** determine si l'invader est de type A, B ou C **/
	private int invaderType;

	/** Score value**/
	public static final int SCORE = 20;

	/**
	 * Constructs a BasicSpaceShip with given arguments
	 * @param pos the position
	 */
	public Bomb(Point2D pos) {
		super(pos, new Rectangle2D.Double(pos.getX(),  pos.getY(),  WIDTH,  HEIGHT));
		this.turnDown();
		this.textureIndex = 0;
		this.lastTextureChange = System.currentTimeMillis();
		Random r = new Random();
		this.invaderType = r.nextInt(3);
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return SCORE;
	}

	@Override
	public Image[] getTexture() {
		return TextureFactory.getInstance().getBombImg();
	}

	@Override
	public void update(double delta) {
		// TODO Auto-generated method stub
		move(delta);
	}

	@Override
	public double getSpeed() {
		// TODO Auto-generated method stub
		return this.SPEED;
	}

	@Override
	public boolean canShot() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns Image of a Bomb
	 */
	public Image getImage() {
		// TODO Auto-generated method stub
		return getTexture()[0];
	}
}
