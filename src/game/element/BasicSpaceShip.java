package game.element;

import game.TextureFactory;

import java.awt.Graphics;
import java.awt.geom.Point2D;
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
public class BasicSpaceShip extends SpaceShip{

	/** Speed of a BasicSpaceShip **/
	private static final double spd = 3000.0;
	
	/**
	 * Constructs a BasicSpaceShip with given arguments
	 * @param pos the position
	 */
	public BasicSpaceShip(Point2D pos) {
		super(pos, spd);
	}
	
	@Override
    public BufferedImage[] getTexture() {
        return TextureFactory.getInstance().getSpaceShipImg();
    }

	@Override
	public void update(double delta) {
		move(delta);
		
		/*
		 *	Updates Lasers position 
		 */
		for(Laser laser : lasers) {
			laser.move(delta);
		}
	}

    @Override
    public void render(Graphics g) {
        g.drawImage(this.getTexture()[0], (int)this.getPosition().getX(), (int)this.getPosition().getY(), null);
    }

	/**
	 * Shot a BasicLaser
	 */
	@Override
	public void shot() {
		// create a laser above spaceship's position
		Point2D pos = getPosition();
		pos.setLocation(pos.getX(), (pos.getY() - 1));
		
		// Instanciate BasicLaser
		Laser laser = new BasicLaser(pos);
		
		// add it to the laser's list
		lasers.add(laser);
	}

}
