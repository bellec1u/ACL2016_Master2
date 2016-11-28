package game.controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.World;
import game.element.SpaceShip;

/**
 * Project "Space Invader"
 * M1 Informatique 2016/2017
 * @author BELLEC Leopold
 * @author DAUZVARDIS Juozas
 * @author JUNGES Pierre-Marie
 * @author LIPSKI Guillaume
 *
 */
public class RestartListener implements KeyListener {

	/** World to reset when an input is pressed **/
	private World world;
	
	public RestartListener(World w){
		world=w;
	}
	
    /**
     * Changes SpaceShip's direction or shoot a Laser
     * if the user press one Key
     */
    @Override
    public void keyPressed(KeyEvent key) {
    	if(key.getKeyCode()==key.VK_R){
    		world.restart();
    	}
    }

    /**
     * Sets the SpaceShip's direction to NONE when
     * the user already pressed one key : LEFT or RIGHT 
     */
    @Override
    public void keyReleased(KeyEvent key) {
    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }
}
