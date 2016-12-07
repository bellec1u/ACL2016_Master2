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
	
	/**
	 * Test la collision entre un SpaceShip et un Invader,
	 * dans ce test aucune collision ce produit
	 */
	@Test
	public void SpaceShipNoCollision() {
		World w = new World();
		w.update(1/60);
		SpaceShip s = w.getSpaceShip();
		Invader i = w.getInvader(0); // recupere le premier Invader
		
		assertTrue(s.hasCollision(i) == false);
	}
	
	/**
	 * Test la collision entre un SpaceShip et un Invader,
	 * dans ce test il y a collision
	 */
	@Test
	public void SpaceShipCollision() {
		World w = new World();
		SpaceShip s = w.getSpaceShip();
		// on place le spaceship a l'emplacement de l'Invader
		s.setPosition(29, 16); 
		w.update(1/60);
		
		Invader i = w.getInvader(0); // recupere le premier Invader
		s.setPosition(i.getPosition().getX(), i.getPosition().getY()); 
		
		assertTrue(s.hasCollision(i) == true);
	}
	
	/**
	 * Test la reaction du World
	 * pour la collision entre un SpaceShip et un Invader,
	 * dans ce test il y a collision
	 */
	@Test
	public void SpaceShipCollisionWorldReaction() {
		World w = new World();
		SpaceShip s = w.getSpaceShip();
		w.update(1/60);
		Invader i = w.getInvader(0);
		// on place le spaceship a l'emplacement de l'Invader
		s.setPosition(i.getPosition().getX(), i.getPosition().getY());
		
		w.update((1/60));
		
		/* Si la collision s'est produit( fct vérifiée ci-dessus )
		 * La vie s'est décrémentée de 1,
		 */
		assertTrue(s.getLives() == 2); // 3 vies par défaut donc 3 - 1
	}
	
	/**
	 * Test la reaction du World
	 * si il n'y a aucune collision entre un SpaceShip et un Invader,
	 * dans ce test il y a collision
	 */
	@Test
	public void SpaceShipNoCollisionWorldReaction() {
		World w = new World();
		SpaceShip s = w.getSpaceShip();	
		w.update((1/60));
		
		/* Si la collision ne s'est pas produit( fct vérifiée ci-dessus )
		 * La vie reste a 3
		 */
		assertTrue(s.getLives() == 3); // 3 vies par défaut donc 3 - 1
	}
	
	/**
	 * On test si la collision entre un Laser tiré du SpaceShip et un Invader
	 * supprime bien l'Invader et le Laser et incremente bien le score.
	 * Pas de collision dans ce cas
	 */
	@Test
	public void SpaceShipShotNoCollisionInvader() {
		World w = new World();
		SpaceShip s = w.getSpaceShip();	
		s.shoot();
		int nbInvader = w.getInvaderNumber();
		int nbLaser = s.getNbLaser();
		w.update((1/60));
		
		/* Le nombre d'Invader ne doit pas avoir changé
		 * -1 car le world a ajouté un invader via sa fonction generateInvaders
		 */
		assertTrue(nbInvader == ( w.getInvaderNumber() - 1));
		
		//Le nombre de Laser n'a pas du également changé
		assertTrue(nbLaser == s.getNbLaser());
		
		//Le score doit etre resté vierge
		assertTrue(w.getScore() == 0);
	}
	
	/**
	 * On test si la collision entre un Laser tiré du SpaceShip et un Invader
	 * supprime bien l'Invader et le Laser et incremente bien le score.
	 * Collision dans ce cas
	 */
	@Test
	public void SpaceShipShotCollisionInvader() {
		World w = new World();
		SpaceShip s = w.getSpaceShip();	
		w.update(1/60);
		
		Invader i = w.getInvader(0);
		// On recupere le score d'un basicInvader
		int scoreInvader = i.getScore();
		s.shoot();
		
		int invadersNb = w.getInvaderNumber();
		int lasersNb = s.getNbLaser();
		// on recupere le laser
		Laser l = s.getLaser(0); 
		// on change sa position pour le faire rentrer en collision
		l.setPosition(i.getPosition().getX(), i.getPosition().getY());
		
		// on update
		w.update((1/60));
		
		// Le nombre d'Invader doit avoir changé
		assertTrue(w.getInvaderNumber() == invadersNb-1);
		
		//Le nombre de Laser aussi
		assertTrue(s.getNbLaser() == lasersNb-1);
		
		//On verifie que le score ait été augmenté
		assertTrue(w.getScore() == scoreInvader);
	}
	
}
