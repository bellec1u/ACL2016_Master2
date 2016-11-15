package game.element;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import game.TextureFactory;
import game.World;

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
	private static final double SPEED = 5.0;

	/** Dimension (width and height) **/
	private final static int WIDTH = 30;	
	private final static int HEIGHT = 16;
	
	private long lastShotTime;
	
	/**
	 * Constructs a BasicSpaceShip with given arguments
	 * @param pos the position
	 */
	public BasicSpaceShip(Point2D pos) {
		super(pos, new Rectangle2D.Double(pos.getX(),  pos.getY(),  WIDTH,  HEIGHT), SPEED);
		this.lastShotTime = System.currentTimeMillis();
	}
	
	@Override
    public BufferedImage[] getTexture() {
        return TextureFactory.getInstance().getSpaceShipImg();
    }
	
	@Override
	protected void setPosition(double x, double y) {
        if ((x + boundingBox.getWidth()) > World.WIDTH) {
            // cas où l'element depasse à droite
            x = World.WIDTH - boundingBox.getWidth();
        }
        if (x >= 0) {
            //System.out.println("X : " + x);
            super.setPosition(x, y);
        }
    }

	@Override
	public void update(double delta) {
		move(delta);
		for (Laser laser : lasers) {
			laser.update(delta);
		}
	}

    @Override
    public void render(Graphics g) {
        g.drawImage(this.getTexture()[0], (int)this.getPosition().getX(), (int)this.getPosition().getY(), null);
        for (Laser laser : lasers) {
            laser.render(g);
        }
    }

	@Override
	public void shoot() {
	    // limit a bit the number of lasers
	    if (!(lastShotTime + 100 < System.currentTimeMillis())) {
	        return;
	    }
	    lastShotTime = System.currentTimeMillis();
	    
		// create a laser above spaceship's position
		Point2D pos = getPosition();
		Laser laser = new BasicLaser(pos);
		
		// place in right position
		double x = getBoundingBox().getWidth()/2 - laser.getBoundingBox().getWidth()/2;
		laser.setRelativePosition(x, 1);
		
		lasers.add(laser);
	}

}
