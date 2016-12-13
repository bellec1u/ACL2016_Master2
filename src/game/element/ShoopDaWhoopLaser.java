package game.element;

import game.TextureFactory;
import game.World;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class ShoopDaWhoopLaser extends Laser{


	/** Speed of a BasicLaser **/
	private static final double SPEED = 0.0; // 3 pixels every refresh call
	
	/** Dimension (width and height) **/
	private final static int WIDTH = 49;	
	private final static int HEIGHT = World.HEIGHT;

	private long startShoot = -1;
	
	/**
	 * Constructs a BasicSpaceShip with given arguments
	 * @param pos the position
	 */
	public ShoopDaWhoopLaser(Point2D pos) {
		super(pos, new Rectangle2D.Double(pos.getX(),  pos.getY(),  0,  0));
		this.startShoot = System.currentTimeMillis();
	}

	/**
	 * Returns Image[] of a BasicLaser
	 */
	@Override
	public Image[] getTexture() {
		return TextureFactory.getInstance().getShoopDaWhoop();
	}

	/**
	 * Updates BasicLaser's position
	 * @param delta lap of time between 2 displays
	 */
	@Override
	public void update(double delta) {
		move(delta);
	}

	/**
	 * Draws a BasicInvader in g
	 * @param g : Graphics where the BasicLaser is drawn
	 */
    @Override
    public void render(Graphics g) {
    	g.drawImage(this.getTexture()[0], 
				(int)this.getPosition().getX() - 15, 500 - 8, 
				60, 32, null);        
    	if (System.currentTimeMillis() - this.startShoot >= 2700) {
    		this.setBoundingBox( new Rectangle2D.Double(this.position.getX(), this.position.getY(), WIDTH, HEIGHT) );
    		g.drawImage(this.getTexture()[1], (int)this.getPosition().getX(), (int)this.getPosition().getY() + 10 - HEIGHT + 500, null);
    	}
    }

	@Override
	public double getSpeed() {
		return SPEED;
	}
	
}
