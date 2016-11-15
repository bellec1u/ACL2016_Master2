package game.controler;

import game.element.SpaceShip;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameListener implements KeyListener {

	/** SpaceShip to control **/
	private SpaceShip ship;
	
	public GameListener(SpaceShip space) {
		this.ship = space;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent key) {
		
		switch(key.getKeyCode()) {
		case KeyEvent.VK_LEFT :
				// then spaceship moves to the left
				System.out.println("LEFT");
				ship.turnLeft();
				break;
		case KeyEvent.VK_RIGHT :
				// then spaceship moves to the right
				System.out.println("RIGHT");
				ship.turnRight();
				break;
		case KeyEvent.VK_SPACE :
				//then spaceship shots a missile
			System.out.println("SHOT");
			ship.shot();
			break;
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}