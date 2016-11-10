package game.element;

import static org.junit.Assert.*;
import game.World;
import game.element.GameMoveableElement.Direction;

import org.junit.Test;

public class InvaderTest {

	/**
	 * test si l'Invader ne bouge pas -> doit retourner faux
	 */
	@Test
	public void InvaderCantMove() {
		World w = new World();
		Invader i = w.getInvader();
		
		assertFalse(i.getDirection() == null);
	}
	
	/**
	 * test si l'Invader vas vers le bas
	 */
	@Test
	public void InvaderGoDown() {
		World w = new World();
		Invader i = w.getInvader();
		
		assertEquals(i.getDirection(), Direction.DOWN);
	}

}
