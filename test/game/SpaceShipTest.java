package game;

import static org.junit.Assert.*;
import game.element.SpaceShip;

import org.junit.Test;

public class SpaceShipTest {

	
	
	/**
	 * test si le SpaceShip peut aller a gauche
	 */
	@Test
	public void SpaceShipTurnLeft() {
		World w = new World();
		SpaceShip s = w.getSpaceShip();
	}

	/**
	 * test si le SpaceShip peut aller a droite
	 */
	@Test
	public void SpaceShipTurnRight() {
		
	}
	
	/**
	 * test si le SpaceShip ne peut pas sortir par le coté gauche de la carte
	 */
	@Test
	public void SpaceShipWallLeft() {
		
	}
	
	/**
	 * test si le SpaceShip ne peut pas sortir par le coté droit de la carte
	 */
	@Test
	public void SpaceShipWallRight() {
		
	}
	
}
