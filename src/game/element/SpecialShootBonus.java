package game.element;

import game.TextureFactory;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

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
	public void render(Graphics g) {
		g.drawImage(this.getTexture()[0], (int)this.getPosition().getX(), (int)this.getPosition().getY(), null);
	}

	@Override
	public void update(double delta) {
		move(delta);
	}

	@Override
	public double getSpeed() {
		return SPEED;
	}

}
