package game.element;

import game.TextureFactory;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import javax.swing.Timer;

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
	
	/** Dimension (width and height) **/
	private final static int WIDTH = 24;	
	private final static int HEIGHT = 16;
	
	/** Attribute used to manage the Element's animation **/
	private int indice;

	/**
	 * Constructs a BasicSpaceShip with given arguments
	 * @param pos the position
	 */
	public BasicInvader(Point2D pos) {
		super(pos, new Rectangle2D.Double(pos.getX(),  pos.getY(),  WIDTH,  HEIGHT));
		this.turnDown();
		this.indice = 0;
	}
	
	/**
	 * Returns Image[] of a BasicInvader
	 */
	@Override
    public Image[] getTexture() {
        return TextureFactory.getInstance().getInvaderAImg();
    }

	/**
	 * Updates BasicInvader's position
	 * @param delta lap of time between 2 displays
	 */
	@Override
	public void update(double delta) {
		move(delta);
		
		/*
		 * Change the indice without using a second Timer
		 */
		this.indice = (((System.currentTimeMillis()) % (getTexture().length)) == 0) ? 1 : 0;
	}

	/**
	 * Draws a BasicInvader in g
	 * @param g : Graphics where the BasicInvader is drawn
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(this.getTexture()[indice], (int)this.getPosition().getX(), (int)this.getPosition().getY(), null);
	}


	@Override
	public double getSpeed() {
		// TODO Auto-generated method stub
		return SPEED;
	}

}
