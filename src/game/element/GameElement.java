package game.element;

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
	
	/*
	 * position du GameElement
	 */
	private Point2D position;
	

	/**
	 * Constructeur vide de GameElement, initialise tout a 0
	 */
	public GameElement(){
		position=new Point2D.Double(0,0);
	}
	
	/**
	 * Constructeur pour un element sans hitbox (juste un points)
	 * @param pos positions de l'element
	 */
	public GameElement(Point2D pos){
		position=new Point2D.Double(pos.getX(),pos.getY());
	}
	
	
	/**
	 * Getter de position
	 * @return position
	 */
	public Point2D getPosition(){
		return position;
	}

	/**
	 * Set la position du GameElement
	 * @param x position dans l'axe X
	 * @param y position dans l'axe Y
	 */
	public void setPosition(double x, double y){
		if(x>0&&y>0){
			position.setLocation(x, y);
		}
	}
	
	public String toString(){
		String s=this.toString()+" en position : "+this.position.getX()+", "+this.position.getY()+".\n";
		return s;
	}
}
