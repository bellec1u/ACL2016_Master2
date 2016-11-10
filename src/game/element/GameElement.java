package game.element;

import game.World;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Project "Space Invader"
 * M1 Informatique 2016/2017
 * @author BELLEC Leopold
 * @author DAUZVARDIS Juozas
 * @author JUNGES Pierre-Marie
 * @author LIPSKI Guillaume
 *
 */
public abstract class GameElement {
	
	/**
	 * position du GameElement
	 */
	private Point2D position;

	/**
	 * Constructeur vide de GameElement, initialise tout a 0
	 */
	public GameElement() {
		position=new Point2D.Double(0,0);
	}
	
	/**
	 * Constructeur pour un element sans hitbox (juste un points)
	 * @param pos positions de l'element
	 */
	public GameElement(Point2D pos) {
		position = new Point2D.Double(pos.getX(), pos.getY());
	}
	
	
	/**
	 * Getter de position
	 * @return position
	 */
	public Point2D getPosition() {
		return (Point2D) position.clone();
	}

	/**
	 * Set la position du GameElement
	 * @param x position dans l'axe X
	 * @param y position dans l'axe Y
	 */
	public void setPosition(double x, double y) {
		if (x >= 0 && y >= 0 && x < World.WIDTH && y < World.HEIGHT) {
			position.setLocation(x, y);
		}
	}
	
	/**
     * Set la position relative du GameElement
     * @param x valeur relative à l'axe X
     * @param y valeur relative à l'axe Y
     */
    public void setRelativePosition(double x, double y) {
        double newX = position.getX() + x;
        double newY = position.getY() + y;
        if (newX >= 0 && newY >= 0 && newX < World.WIDTH && newY < World.HEIGHT) {
            position.setLocation(newX, newY);
        }
    }
	
	/**
	 * donne le nom de l'element et sa position
	 */
	public String toString() {
		String s="    Position : "+this.position.getX()+", "+this.position.getY()+".\n";
		return s;
	}
}
