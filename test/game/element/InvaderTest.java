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
		w.update(0);
		Invader i = w.getInvader(0);
		
		assertNotEquals(i.getDirection(), Direction.NONE);
	}
	
	/**
	 * test si l'Invader vas vers le bas
	 */
	@Test
	public void invaderGoDown() {
		World w = new World();
		w.update(0);
		Invader i = w.getInvader(0);
		
		assertEquals(i.getDirection(), Direction.DOWN);
	}
	
	/**
	 * test si l'Invader avance vers le bas
	 */
	@Test
	public void invaderForwardDown() {
		World w = new World();
		w.update(1/60);
		Invader i = w.getInvader(0);
		Double yInit = i.getPosition().getY();
		i.turnDown();
		i.update(2);

		assertTrue(yInit + 2*i.getSpeed() == i.getPosition().getY());
	}
	
	@Test
	public void invaderOutOfScreenRemove() {
	    World w = new World();
	    w.update(0);
        Invader i = w.getInvader(0);
        int invaderNb = w.getInvaderNumber();
        i.update(200);
        w.update(0);
        assertEquals(w.getInvaderNumber(), invaderNb-1);
	}
	
	@Test
	public void invaderGeneration() {
	    World w = new World();
	    int nbInvader=w.getInvaderNumber();
	    try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	    w.update(1);
	    assertTrue(nbInvader<w.getInvaderNumber());
	}

}
