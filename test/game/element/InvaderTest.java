package game.element;

import static org.junit.Assert.*;
import game.World;
import game.element.GameElement.Direction;

import org.junit.Test;

public class InvaderTest {

	/**
	 * test si l'Invader ne bouge pas -> doit retourner faux
	 */
	@Test
	public void invaderCantMove() {
		World w = new World();
		Invader i = w.getInvader();
		
		assertNotEquals(i.getDirection(), Direction.NONE);
	}
	
	/**
	 * test si l'Invader vas vers le bas
	 */
	@Test
	public void invaderGoDown() {
		World w = new World();
		Invader i = w.getInvader();
		
		assertEquals(i.getDirection(), Direction.DOWN);
	}
	
	/**
	 * test si l'Invader avance vers le bas
	 */
	@Test
	public void invaderForwardDown() {
		World w = new World();
		Invader i = w.getInvader();
		Double yInit = i.getPosition().getY();
		i.turnDown();
		i.update(2);

		assertTrue(yInit + 2*i.getSpeed() == i.getPosition().getY());
	}
	
	@Test
	public void invaderOutOfScreenRemove() {
	    World w = new World();
        Invader i = w.getInvader();
        
        w.update(100);
        assertEquals(w.getInvaderNumber(), 0);
	}

}
