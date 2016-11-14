package game.element;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import game.TextureFactory;

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
	private static final double spd = 3.0;

	private int textureIndex = 0;
	private int frameCount = 0;

	/**
	 * Constructs a BasicSpaceShip with given arguments
	 * @param pos the position
	 */
	public BasicInvader(Point2D pos) {
		super(pos, spd);
		//turnDown();
	}
	
	@Override
    public BufferedImage[] getTexture() {
        return TextureFactory.getInstance().getInvaderAImg();
    }

	@Override
	public void update(double delta) {
		move(delta);
		
		// Change texture to render each 15 frames
		if (frameCount % 15 == 0) {
		    textureIndex = ++textureIndex % getTexture().length; // [0 1]
		    frameCount = 0; // to prevent integer overflow
		}
	}

	@Override
	public void render(Graphics g) {
	    frameCount++;
		g.drawImage(getTexture()[textureIndex], (int)getPosition().getX(), (int)getPosition().getY(), null);
	}
}
