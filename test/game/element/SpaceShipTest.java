package game.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import game.World;
import game.element.GameElement.Direction;

public class SpaceShipTest {

	/**
	 * test si le SpaceShip ne bouge pas
	 */
	@Test
	public void SpaceShipDontMove() {
		World w = new World();
		SpaceShip s = w.getSpaceShip();
		
		assertEquals(s.getDirection(), Direction.NONE);
	}
	
	/**
	 * test si le SpaceShip peut aller a gauche
	 */
	@Test
	public void SpaceShipTurnLeft() {
		World w = new World();
		SpaceShip s = w.getSpaceShip();
		s.turnLeft();
		
		assertEquals(Direction.LEFT, s.getDirection());
	}
	
	/**
	 * test si le SpaceShip se déplace vers la gauche
	 */
	@Test
	public void SpaceShipForwardLeft() {
		World w = new World();
		SpaceShip s = w.getSpaceShip();
		Double xInit = s.getPosition().getX();
		s.turnLeft();
		double delay = 1.0 / 60.0;
		s.update(delay);

		assertTrue(xInit - delay*s.getSpeed() == s.getPosition().getX());
	}

	/**
	 * test si le SpaceShip peut aller a droite
	 */
	@Test
	public void SpaceShipTurnRight() {
		World w = new World();
		SpaceShip s = w.getSpaceShip();
		s.turnRight();
		
		assertEquals(Direction.RIGHT, s.getDirection());
	}
	
	/**
	 * test si le SpaceShip se déplace vers la gauche
	 */
	@Test
	public void SpaceShipForwardRight() {
		World w = new World();
		SpaceShip s = w.getSpaceShip();
		Double xInit = s.getPosition().getX();
		s.turnRight();
		double delay = 1.0 / 60.0;
		s.update(delay);
		
		assertTrue(xInit + delay*s.getSpeed() == s.getPosition().getX());
	}
	
	/**
	 * test si le SpaceShip ne peut pas sortir par le coté gauche de la carte
	 */
	@Test
	public void SpaceShipWallLeft() {
		World w = new World();
		SpaceShip s = w.getSpaceShip();
		s.turnLeft();
		s.update(4000);
		
		assertTrue(0 <= s.getPosition().getX());
	}
	
	/**
	 * test si le SpaceShip ne peut pas sortir par le coté droit de la carte
	 */
	@Test
	public void SpaceShipWallRight() {
		World w = new World();
		SpaceShip s = w.getSpaceShip();
		s.turnRight();
		s.update(World.WIDTH + 20);
		
		assertTrue(World.WIDTH >= s.getPosition().getX());
	}
	
	/**
	 * Test si un SpaceShip a sa liste de laser vide
	 */
	@Test
	public void SpaceShipNoShoot() {
		World w = new World();
		SpaceShip s = w.getSpaceShip();
		
		assertTrue(s.getNbLaser() == 0);
	}
	
	/**
	 * Test si un SpaceShip a sa liste de laser est egale à 1
	 */
	@Test
	public void SpaceShipShoot() {
		World w = new World();
		SpaceShip s = w.getSpaceShip();
		s.shoot();
		
		assertTrue(s.getNbLaser() == 1);
	}

	/**
	 * Test si un SpaceShip a sa liste de laser est egale à 0
	 * car tire( +1 ) et delete ( -1 )
	 */
	@Test
	public void SpaceShipShootThenDelete() {
		World w = new World();
		SpaceShip s = w.getSpaceShip();
		s.shoot(); // on tire
		s.deleteLaser(s.getLaser(0)); // et on supprime le Laser créé
		
		assertTrue(s.getNbLaser() == 0);
	}
	
	
	
}
