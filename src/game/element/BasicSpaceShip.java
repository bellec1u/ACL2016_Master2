package game.element;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;

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
public class BasicSpaceShip extends SpaceShip {

	/** Speed of a BasicSpaceShip **/
	private static final double SPEED = 200.0; // 4 pixels every refresh call
	private static final int SHOT_DELAY = 200;

	/** Dimension (width and height) **/
	private final static int WIDTH = 30;	
	private final static int HEIGHT = 16;
	
	/** delay until the BasicSpaceShip can shoot again **/
	private long lastShotTime;
	
	/**
	 * Constructs a BasicSpaceShip with given arguments
	 * @param pos the position
	 */
	public BasicSpaceShip(Point2D pos) {
		super(pos, new Rectangle2D.Double(pos.getX(),  pos.getY(),  WIDTH,  HEIGHT));
		this.lastShotTime = System.currentTimeMillis();
	}
	
	/**
	 * Returns Image[] of a BasicSpaceShip
	 */
	@Override
    public Image[] getTexture() {
        return TextureFactory.getInstance().getSpaceShipImg();
    }

	/**
	 * Updates BasicSpaceShip's position
	 * @param delta lap of time between 2 displays
	 */
	@Override
	public void update(double delta) {
		move(delta); // moves the SpaceShip
		Laser laser;
		// Iterates through the Laser's List available
		for(int i = 0 ; i < lasers.size() ; i++) {
			laser = lasers.get(i);
			laser.update(delta); // moves Laser
			if (laser.isOutOfScreen() ) {
				// deletes the laser whom is out of screen
				deleteLaser(laser); 
			}
		}
	}

	/**
	 * Draws a BasicSpaceShip and his laser(s) in g
	 * @param g : Graphics where the BasicLaser is drawn
	 */
    @Override
    public void render(Graphics g) {
        g.drawImage(this.getTexture()[0], (int)this.getPosition().getX(), (int)this.getPosition().getY(), null);
        for (Laser laser : lasers) {
            laser.render(g);
        }
    }

    /**
     * Shoots a BasicLaser with UP direction,
     * The BasicLaser is created just above the BasicSpaceShip's coordinates
     */
	@Override
	public void shoot() {
	    // limit a bit the number of lasers
	    if (!(lastShotTime + SHOT_DELAY < System.currentTimeMillis())) {
	        return;
	    }
	    lastShotTime = System.currentTimeMillis();
	    
		// create a laser above spaceship's position
		Point2D pos = getPosition();
		Laser laser = new BasicLaser(pos);
		
		// place in right position (middle of spaceship)
		double x = getBoundingBox().getWidth()/2 - laser.getBoundingBox().getWidth()/2;
		laser.setRelativePosition(x, -2);
		
		lasers.add(laser);
	}

	@Override
	public double getSpeed() {
		return SPEED;
	}
	
}
