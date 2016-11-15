package game.element;

import game.TextureFactory;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * Project "Space Invader"
 * M1 Informatique 2016/2017
 * @author BELLEC Leopold
 * @author DAUZVARDIS Juozas
 * @author JUNGES Pierre-Marie
 * @author LIPSKI Guillaume
 *
 */
public class BasicLaser extends Laser{


	/** Speed of a BasicLaser **/
	private static final double SPEED = 7.0;
	
	/** Dimension (width and height) **/
	private final static int WIDTH = 4;	
	private final static int HEIGHT = 16;
	
	/**
	 * Constructs a BasicSpaceShip with given arguments
	 * @param pos the position
	 */
	public BasicLaser(Point2D pos) {
		super(pos, new Rectangle2D.Double(pos.getX(),  pos.getY(),  WIDTH,  HEIGHT), SPEED);
		turnUp();
	}

	@Override
	public void update(double delta) {
		move(delta);
	}

	@Override
	public BufferedImage[] getTexture() {
		return TextureFactory.getInstance().getShootImg();
	}

    @Override
    public void render(Graphics g) {
        g.drawImage(this.getTexture()[0], (int)this.getPosition().getX(), (int)this.getPosition().getY(), null);
    }

}
