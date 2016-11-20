package game.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import game.World;
import game.element.GameElement.Direction;

import org.junit.Test;

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
		s.update(2);
		
		assertTrue(xInit - 2*s.getSpeed() == s.getPosition().getX());
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
		s.update(2);
		
		assertTrue(xInit + 2*s.getSpeed() == s.getPosition().getX());
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
	
}
