package game.controler;

import game.World;
import game.view.GameScreen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Project "Space Invader"
 * M1 Informatique 2016/2017
 * @author BELLEC Leopold
 * @author DAUZVARDIS Juozas
 * @author JUNGES Pierre-Marie
 * @author LIPSKI Guillaume
 *
 */
public class GameListener implements KeyListener {

	/** SpaceShip to control **/
	private World world;
	private GameScreen gameScreen;

	public GameListener(GameScreen gscreen) {
		this.gameScreen = gscreen;
	    this.world = gscreen.getWorld();
	}

	/**
	 * Changes SpaceShip's direction or shoot a Laser
	 * if the user press one Key
	 */
	@Override
	public void keyPressed(KeyEvent key) {

		switch(key.getKeyCode()) {
		case KeyEvent.VK_LEFT :
			// then spaceship moves to the left
			this.world.getSpaceShip().turnLeft();
			break;
		case KeyEvent.VK_RIGHT :
			// then spaceship moves to the right
			this.world.getSpaceShip().turnRight();
			break;
		case KeyEvent.VK_SPACE :
			// then spaceship shoots a laser
			this.world.getSpaceShip().shoot();
			break;
		case KeyEvent.VK_R : 
			if (this.world.getGameOver()) {
				this.world.restart();
			}
			break;
		case KeyEvent.VK_ESCAPE :
		    gameScreen.togglePause();
		    break;
		case KeyEvent.VK_Q :
		    System.exit(0);
		    break;
		}
	}

	/**
	 * Sets the SpaceShip's direction to NONE when
	 * the user already pressed one key : LEFT or RIGHT 
	 */
	@Override
	public void keyReleased(KeyEvent key) {
		switch(key.getKeyCode()) {
		case KeyEvent.VK_LEFT :
		case KeyEvent.VK_RIGHT :
			this.world.getSpaceShip().stopMove();
			break;
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
}
