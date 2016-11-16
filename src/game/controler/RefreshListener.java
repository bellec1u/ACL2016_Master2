/**
 * 
 */
package game.controler;

import game.view.GameScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Project "Space Invader"
 * M1 Informatique 2016/2017
 * @author BELLEC Leopold
 * @author DAUZVARDIS Juozas
 * @author JUNGES Pierre-Marie
 * @author LIPSKI Guillaume
 *
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
