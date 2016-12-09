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

	/** Speed of a BasicSpaceShip **/
	private static final double SPEED = 50.0; // 4 pixels every refresh call

	/** Dimension (width and height) **/
	private final static int WIDTH = 36;	
	private final static int HEIGHT = 16;
	
	public SpecialShootBonus(Point2D pos) {
		super(pos, new Rectangle2D.Double(pos.getX(),  pos.getY(),  WIDTH,  HEIGHT));
		this.turnDown();
	}

	@Override
	public Image[] getTexture() {
		return TextureFactory.getInstance().getSpecialShootBonus();
	}
	
	@Override
	public void update(double delta) {
		move(delta);
	}

	@Override
	public double getSpeed() {
		return SPEED;
	}


	public Image getImage() {
		return getTexture()[0];
	}

}
