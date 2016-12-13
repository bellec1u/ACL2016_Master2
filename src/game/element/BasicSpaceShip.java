package game.element;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

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
		this.lastShotTime = 0;
		this.lives = 3;
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
			
			if (laser instanceof ShoopDaWhoopLaser) {
				laser.setPosition((int)this.getPosition().getX(), 0);
				
				if (((ShoopDaWhoopLaser) laser).canShowLaser()) {
					laser.setBoundingBox( new Rectangle2D.Double(
							laser.getPosition().getX(), laser.getPosition().getY() + 15 - ((ShoopDaWhoopLaser)laser).getHeight() + 500, 
							((ShoopDaWhoopLaser)laser).getWidth(),  ((ShoopDaWhoopLaser)laser).getHeight()) );
				}
			}
		}
	}

	/**
	 * Shoots a BasicLaser with UP direction,
	 * The BasicLaser is created just above the BasicSpaceShip's coordinates
	 */
	@Override
	public void shoot() {
		if (!this.shootShoopDaWhoop) {
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
		} else {
			// create a laser above spaceship's position
			Point2D pos = getPosition();
			pos.setLocation(pos.getX(), 0);
			Laser laser = new ShoopDaWhoopLaser(pos);
			lasers.add(laser);
		}
	}

	@Override
	public double getSpeed() {
		return SPEED;
	}

	/**
	 * Returns Image of a BasicSpaceShip
	 */
	public Image getImage() {
		// TODO Auto-generated method stub
		return getTexture()[0];
	}

}
