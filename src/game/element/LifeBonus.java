package game.element;

import game.TextureFactory;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class LifeBonus extends Bonus {

	/** Speed of a bonus **/
	private static final double SPEED = 50.0; // 4 pixels every refresh call

	/** Dimension (width and height) **/
	private final static int WIDTH = 36;	
	private final static int HEIGHT = 16;
	
	public LifeBonus(Point2D pos) {
		super(pos, new Rectangle2D.Double(pos.getX(),  pos.getY(),  WIDTH,  HEIGHT));
		this.turnDown();
	}

	@Override
	public Image[] getTexture() {
		return TextureFactory.getInstance().getLifeBonus();
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
