package game.controler;

import game.element.SpaceShip;
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
    private SpaceShip ship;

    public GameListener(SpaceShip space) {
        this.ship = space;
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
            ship.turnLeft();
            break;
        case KeyEvent.VK_RIGHT :
            // then spaceship moves to the right
            ship.turnRight();
            break;
        case KeyEvent.VK_SPACE :
            // then spaceship shoots a laser
            ship.shoot();
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
            ship.stopMove();
            break;
        }
        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }
}
