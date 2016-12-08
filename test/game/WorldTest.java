package game;


import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import org.junit.Test;

public class WorldTest {

	/**
	 * Test la difficulté du World
	 */
	@Test
	public void testWorldLevel() {
		
	}
	
	/**
	 * test si un bonus spécial shoot s'ajoute bien dans le monde
	 */
	@Test
	public void testAddBonusSpecialShoot() {
		World w = new World();
		w.generateBonus( new Point2D.Double(0, 0) );
		assert(w.getListSpecialShoot().size() == 1);
	}
	
	/**
	 * test si un bonus spécial shoot se supprime de la liste lors d'une sortie d'écran
	 */
	@Test
	public void testBonusSpecialShootIsOutOfScreen() {
		World w = new World();
		w.generateBonus( new Point2D.Double(w.WIDTH, w.HEIGHT-5) );
		w.update(50);
		assert(w.getListSpecialShoot().size() == 0);
	}
	
	/**
	 * test si un bonus spécial shoot s'ajoute au nb de spécial shoot stocké lors d'une collision spaceship - bonus spécial shoot
	 */
	@Test
	public void testAddBonusSpecialShootStock() {
		World w = new World();
		Point2D pos = w.getSpaceShip().getPosition();
		w.generateBonus( new Point2D.Double(pos.getX(), pos.getY()) );
		w.update(5);
		assert(w.getNbSpecialShoot() == 1);
	}
}
