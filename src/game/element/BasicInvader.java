package game.element;

import game.TextureFactory;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

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
	private static final double spd = 3.0;

	private Timer animator;
	private int delay = 50;
	private int currentFrame = 0;

	/**
	 * Constructs a BasicSpaceShip with given arguments
	 * @param pos the position
	 */
	public BasicInvader(Point2D pos) {
		super(pos, spd);
		//turnDown();
	}

	@Override
	public void update(double delta) {
		move(delta);
	}

	@Override
	public BufferedImage[] getTexture() {
		return TextureFactory.getInstance().getInvaderAImg();
	}

	@Override
	public void render(Graphics g) {
		if (this.currentFrame >= this.getTexture().length-1) {
			this.currentFrame = 0;
		} else {
			this.currentFrame++;
		}

		g.drawImage(this.getTexture()[this.currentFrame], (int)this.getPosition().getX(), (int)this.getPosition().getY(), null);

		// TODO: sleep right amount of time
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
