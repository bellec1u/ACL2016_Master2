package game;

import static org.junit.Assert.*;
import game.element.Bonus;
import game.element.LifeBonus;
import game.element.SpaceShip;
import game.element.SpecialShootBonus;

import java.awt.geom.Point2D;
import org.junit.Test;

public class WorldTest {

	/**
	 * Test la difficulté du World en EASY
	 */
	@Test
	public void testWorldLevelEasy() {
		World world = new World();
		world.incrementScore(440);
		
		assertTrue(world.getScore() < world.getLevelMedium());
	}
	
	/**
	 * Test la difficulté du World en MEDIUM
	 */
	@Test
	public void testWorldLevelMedium() {
		World world = new World();
		world.incrementScore(760);
		
		assertTrue(world.getScore() >= world.getLevelMedium());
		assertTrue(world.getScore() < world.getLevelHard());
	}
	
	/**
	 * Test la difficulté du World en HARD
	 */
	@Test
	public void testWorldLevelHard() {
		World world = new World();
		world.incrementScore(1510);
		
		assertTrue(world.getScore() > world.getLevelHard());
	}
	
	/**
	 * test si un bonus spécial shoot s'ajoute bien dans le monde
	 */
	@Test
	public void testAddBonusSpecialShoot() {
		World w = new World();
		w.generateBonus( new Point2D.Double(0, 0) );
		assertEquals(1, w.getListBonus().size());
	}
	
	/**
	 * test si un bonus spécial shoot se supprime de la liste lors d'une sortie d'écran
	 */
	@Test
	public void testBonusSpecialShootIsOutOfScreen() {
		World w = new World();
		w.generateBonus( new Point2D.Double(World.WIDTH, World.HEIGHT-5) );
		w.update(50);
		assertEquals(0, w.getListBonus().size());
	}
	
	/**
	 * test si un bonus spécial shoot s'ajoute au nb de spécial shoot stocké lors d'une collision spaceship - bonus spécial shoot
	 */
	@Test
	public void testAddBonusSpecialShootStock() {
		World w = new World();
		Point2D pos = w.getSpaceShip().getPosition();
		Bonus bonus = new SpecialShootBonus(pos);
		w.testerBonus(bonus);
		w.update(0);
		assertEquals(1, w.getSpaceShip().getNbSpecialShoot());
		
		// le bonus a du être supprimé
		assertTrue(w.getListBonus().size() == 0);
	}
	
	/**
	 * On test la collision entre le SpaceShip et un Bonus de vie
	 * si collision alors le vie du spaceShip est augmentée de 1.
	 */
	@Test
	public void testCollisionSpaceShipBonus() {
		World w = new World();
		SpaceShip s = w.getSpaceShip();	
		
		// recupere la vie du vaisseau avant
		int vieAvant = s.getLives();
		
		// on créé le bonus a la position du vaisseau
		Bonus bonus = new LifeBonus(s.getPosition());
		w.testerBonus(bonus);
		// on update
		w.update(0);
		
		// on verifie que la vie du vaisseau ait été augmenté
		assertTrue(s.getLives() == (vieAvant + 1));
		
		// le bonus a du être supprimé
		assertTrue(w.getListBonus().size() == 0);
	}
}
