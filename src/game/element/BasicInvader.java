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
public class BasicInvader extends Invader {

	/** Speed of a BasicInvader **/
	private static final double SPEED = 90.0; // 1.5 pixels every refresh call
	private static final int TEXTURE_CHANGE_DELAY = 500;

	/** Dimension (width and height) **/
	private final static int WIDTH = 24;	
	private final static int HEIGHT = 16;

	/** Attributes used to manage the Element's animation **/
	private int textureIndex;
	private long lastTextureChange;

	/** determine si l'invader est de type A, B ou C **/
	private int invaderType;

	/** Score value**/
	public static final int SCORE = 10;
	
	/** Munitions **/
	private int amo;

	/**
	 * Constructs a BasicSpaceShip with given arguments
	 * @param pos the position
	 */
	public BasicInvader(Point2D pos) {
		super(pos, new Rectangle2D.Double(pos.getX(),  pos.getY(),  WIDTH,  HEIGHT));
		this.turnDown();
		this.textureIndex = 0;
		this.lastTextureChange = System.currentTimeMillis();
		Random r = new Random();
		this.invaderType = r.nextInt(3);
		this.amo=r.nextInt(3);
	}

	/**
	 * Returns Image[] of a BasicInvader
	 */
	@Override
	public Image[] getTexture() {
		switch (this.invaderType) {
		case 0 :
			return TextureFactory.getInstance().getInvaderAImg();
		case 1 :
			return TextureFactory.getInstance().getInvaderBImg();
		default :
			return TextureFactory.getInstance().getInvaderCImg();
		}
	}
	
	/**
	 * Updates BasicInvader's position
	 * @param delta lap of time between 2 displays
	 */
	@Override
	public void update(double delta) {
		move(delta);

		/*
		 * Change the indice without using a Timer
		 */
		if (System.currentTimeMillis() > lastTextureChange + TEXTURE_CHANGE_DELAY) {
			textureIndex = ++textureIndex % getTexture().length;
			lastTextureChange = System.currentTimeMillis();
		}
	}

	@Override
	public double getSpeed() {
		return SPEED;
	}

	/** Returns Invader's score value **/
	public int getScore() {
		return SCORE;
	}
	
	public boolean canShot(){
		boolean shot=false;
		if(amo>0){
			if(new Random().nextInt(100)>98){
				shot = true;
				amo--;
			}
		}
		return shot;
	}

	/**
	 * Returns Image of a BasicInvader
	 */
	public Image getImage() {
		return getTexture()[textureIndex];
	}

}
