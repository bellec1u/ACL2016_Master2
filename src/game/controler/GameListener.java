package game.controler;

import game.TextureFactory;
import game.World;
import game.view.GameScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

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
	
	//-1 = gauche | 0 = pas bouger | 1 = droite
	private int directionDeplacement;
		
	private boolean shoopDaWhoopAction = false;
	private int dureeActionShoopDaWhoop = 5000;
	private long startTimerShoopDaWhoop = -1;

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
			if (this.directionDeplacement - 1 >= -1)
				this.directionDeplacement -= 1;
			break;
		case KeyEvent.VK_RIGHT :
			// then spaceship moves to the right
			if (this.directionDeplacement + 1 <= 1)
				this.directionDeplacement += 1;
			break;
		case KeyEvent.VK_SPACE :
			// then spaceship shoots a laser
			if (!shoopDaWhoopAction) {
				this.world.getSpaceShip().shoot();
			}
			break;
		case KeyEvent.VK_N :
			// generate a shoopDaWhoop
			if (this.world.getNbSpecialShoot() >= 1 && !shoopDaWhoopAction) {
				this.world.getSpaceShip().startShootShoopDaWhoop();
				this.world.getSpaceShip().shoot();
				this.world.decrementSpecialShoot();
				
				this.shoopDaWhoopAction = true;
				
				Timer timer = new Timer(10000, new ActionListener() {

		            @Override
		            public void actionPerformed(ActionEvent e) {
						shoopDaWhoopAction = false;
						world.getSpaceShip().endShootShoopDaWhoop();
		            }

		        });
		        timer.start();
			}
			
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
		this.changeDirection();
	}

	/**
	 * Sets the SpaceShip's direction to NONE when
	 * the user already pressed one key : LEFT or RIGHT 
	 */
	@Override
	public void keyReleased(KeyEvent key) {
		switch(key.getKeyCode()) {
		case KeyEvent.VK_LEFT :
			if (this.directionDeplacement + 1 <= 1)
				this.directionDeplacement += 1;
			break;
		case KeyEvent.VK_RIGHT :
			if (this.directionDeplacement - 1 >= -1)
				this.directionDeplacement -= 1;
			break;
		}
		this.changeDirection();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
	
	private void changeDirection() {
		switch(this.directionDeplacement) {
		case -1 :
			this.world.getSpaceShip().turnLeft();
			break;
		case 0 :
			this.world.getSpaceShip().stopMove();
			break;
		case 1 :
			this.world.getSpaceShip().turnRight();
			break;
		default :
			this.directionDeplacement = 0;
		}
	}
}
