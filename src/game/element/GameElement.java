package game.element;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import game.World;

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
	 * Bounding box de l'element
	 */
	private Rectangle2D boundingBox;

	/**
	 * Constructeur vide de GameElement, initialise tout a 0
	 */
	public GameElement() {
		position = new Point2D.Double(0,0);
		boundingBox = new Rectangle2D.Double(0,0,0,0);
	}
	
	/**
	 * Constructeur pour un element sans hitbox (juste un points)
	 * @param pos positions de l'element
	 */
	public GameElement(Point2D pos, Rectangle2D box) {
		position = new Point2D.Double(pos.getX(), pos.getY());
		boundingBox = new Rectangle2D.Double(box.getX(), box.getY(), box.getWidth(), box.getHeight());
	}
	
	
	/**
	 * Getter de position
	 * @return position
	 */
	public Point2D getPosition() {
		return (Point2D) position.clone();
	}

	/**
	 * Getter de boundingbox
	 * @return boundingbox
	 */
	public Rectangle2D getBoundingBox() {
		return (Rectangle2D) boundingBox.clone();
	}
	
	/**
	 * Set la position du GameElement
	 * @param x position dans l'axe X
	 * @param y position dans l'axe Y
	 */
	private void setPosition(double x, double y) {
		// if a supprimer, après verifications
		if (x >= 0 && y >= 0 && x < World.WIDTH && y < World.HEIGHT) {
			position.setLocation(x, y);
			boundingBox.setRect(x, y, boundingBox.getWidth(), boundingBox.getHeight());
			return;
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
        
		/*
		 *  Plusieurs cas a gérer: 
		 *  - Le cas où le deplacement ne pose pas de probleme.
		 *  - Le cas où le deplacement depasse la bordure droite
		 *  - Le cas où le deplacement depasse les bordures (haut, bas)
		 */
        if((newX + boundingBox.getWidth()) > World.WIDTH) {
        	// cas où l'element depasse à droite
        	newX = World.WIDTH - boundingBox.getWidth();
        }
        
        if((newY + boundingBox.getHeight() > World.HEIGHT)) {
        	// cas où l'element depasse en bas
        	newY = World.HEIGHT - boundingBox.getHeight();
        }
        
        if((newY + boundingBox.getHeight() < 0 )) {
        	// cas où l'element depasse en haut
        	newY = boundingBox.getHeight();
        }
        this.setPosition(newX, newY);
    }
    
    public abstract BufferedImage[] getTexture();
    
    public abstract void render(Graphics g);
	
	/**
	 * donne le nom de l'element et sa position
	 */
	public String toString() {
		String s="    Position : "+this.position.getX()+", "+this.position.getY()+".\n";
		return s;
	}
}
