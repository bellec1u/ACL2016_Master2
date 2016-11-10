package game.element;

import static org.junit.Assert.*;
import game.World;
import game.element.GameMoveableElement.Direction;
import game.element.SpaceShip;

import org.junit.Test;

public class SpaceShipTest {

	/**
	 * test si le SpaceShip ne bouge pas
	 */
	@Test
	public void SpaceShipDontMove() {
		World w = new World();
		SpaceShip s = w.getSpaceShip();
		
		assertFalse(s.getIsMoving());
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
		s.update(w.getWidth());
		
		assertTrue(w.getWidth() >= s.getPosition().getX());
	}
	
}
