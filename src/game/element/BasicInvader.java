package game.element;

import game.TextureFactory;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	private int delay = 500;
	private int currentFrame = 0;

	/**
	 * Constructs a BasicSpaceShip with given arguments
	 * @param pos the position
	 */
	public BasicInvader(Point2D pos) {
		super(pos, spd);
		Timer timer = new Timer(this.delay, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (currentFrame >= getTexture().length-1) {
        			currentFrame = 0;
        		} else {
        			currentFrame++;
        		}
            }
        });
        timer.start();
	}
	
	@Override
    public BufferedImage[] getTexture() {
        return TextureFactory.getInstance().getInvaderAImg();
    }

	@Override
	public void update(double delta) {
		move(delta);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(this.getTexture()[this.currentFrame], (int)this.getPosition().getX(), (int)this.getPosition().getY(), null);
	}

}
