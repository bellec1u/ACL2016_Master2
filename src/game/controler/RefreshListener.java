/**
 * 
 */
package game.controler;

import game.view.GameScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author JUNGES Pierre-Marie - M1 Informatique 2016/2017
 *
 * Nov 15, 2016
 */
public class RefreshListener implements ActionListener{

	/**
	 * Class to manage
	 */
	private GameScreen gameScreen;
	
	/**
	 * Class used to manage the paint / repaint call on class GameScreen
	 */
	public RefreshListener(GameScreen screen) {
		this.gameScreen = screen;
	}
	
	/**
	 * Calls method repaint()
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		gameScreen.repaint();
	}

}
