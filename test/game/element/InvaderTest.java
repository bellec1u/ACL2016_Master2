package game.element;

import static org.junit.Assert.*;
import game.World;
import game.element.GameMoveableElement.Direction;

import org.junit.Test;

public class InvaderTest {

	/**
	 * test si l'Invader ne bouge pas
	 */
	@Test
	public void SpaceShipDontMove() {
		World w = new World();
		Invader i = w.getInvader();
		
		assertTrue(i.getIsMoving());
	}
	
	/**
	 * test si l'Invader vas vers le bas
	 */
	@Test
	public void SpaceShipGoDown() {
		World w = new World();
		Invader i = w.getInvader();
		
		assertEquals(i.getDirection(), Direction.DOWN);
	}

}
