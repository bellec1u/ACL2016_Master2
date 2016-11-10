package game.element;

import java.awt.geom.Point2D;

/**
 * Project "Space Invader"
 * M1 Informatique 2016/2017
 * @author BELLEC Leopold
 * @author DAUZVARDIS Juozas
 * @author JUNGES Pierre-Marie
 * @author LIPSKI Guillaume
 *
 */
public abstract class GameMoveableElement extends GameElement{
	
	/** Speed of movement */
	private double speed;
	
	/** Direction of movement **/
	protected enum Direction { UP, DOWN, LEFT, RIGHT };
	
	/** Attribute Direction **/
	protected Direction direction;
	
	/** Boolean indicates if object is moving or not **/
	private boolean isMoving;
	
	/**
	 * Constructs a GameMoveableElement.java with the given parameter(s)
	 * @param pos
	 * @param spd
	 */
	public GameMoveableElement(Point2D pos, double spd) {
		// TODO Auto-generated constructor stub
		super(pos);
		speed = spd;
		isMoving = false;
		direction = Direction.LEFT;
	}
	
	/** Moves the object toward a direction with given parameter :
	 * @param delta time between 2 frames
	 */
	protected void move(double delta){
		
		// if the object moves then ...
		if(isMoving){
			// v = (d / t) so d = v * t;
			double distance = speed * delta;
			
			// Recover older position
			Point2D currentPosition = getPosition();
			// Recover older x and y components
			double x = currentPosition.getX();
			double y = currentPosition.getY();
			
			// Calculate the new coordinate
			switch(direction){
			case UP :
				// If UP then x' = x and y' = y - distance
				setPosition(x,(y - distance));
				break;
			case DOWN :
				// If DOWN then x' = x and y' = y + distance
				setPosition(x,(y + distance));
				break;
			case LEFT :
				// If LEFT then x' = x - distance and y' = y
				setPosition((x - distance),y);
				break;
			case RIGHT :
				// If LEFT then x' = x + distance and y' = y
				setPosition((x + distance),y);
				break;
			}
		}
	}
	
	/** Updates the position and behavior of the GameMoveableElement **/
	public abstract void update(double delta);

	/** set the object to 'moving' or 'stable' state with given parameter
	 * @param bool the state of the object
	 **/
	public void canMove(boolean bool){
		isMoving = bool;
	}
	
	/** Sets the Direction to the LEFT **/
	public void turnLeft(){
		direction = Direction.LEFT;
	}
	
	/** Sets the Direction to the RIGHT **/
	public void turnRight(){
		direction = Direction.RIGHT;
	}
	
	/** Sets the Direction to UP **/
	public void turnUp(){
		direction = Direction.UP;
	}
	
	/** Sets the Direction to DOWN **/
	public void turnDown(){
		direction = Direction.DOWN;
	}
	
	/** toString **/
	public String toString(){
		StringBuilder sb = new StringBuilder("");
		sb.append(super.toString());
		sb.append("Direction ? " + direction + "\n");
		sb.append("Moves ? " + isMoving + "\n");
		return sb.toString();
	}
	
	/** Returns the speed **/
	public double getSpeed(){
		return speed;
	}
	
	/** Returns the GameMoveableElement's direction **/
	protected Direction getDirection(){
		return this.direction;
	}
	
}
