package game.element;

import game.World;

import java.awt.Image;
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
public abstract class GameElement{
	
	
	/**
	 * position du GameElement
	 */
	protected Point2D position;
	
	/**
	 * Bounding box de l'element
	 */
	private Rectangle2D boundingBox;

    /** Direction of movement **/
    public enum Direction { UP, DOWN, LEFT, RIGHT, NONE };

    /** Attribute Direction **/
    protected Direction direction = Direction.NONE;

    /**
     * Constructs a GameMoveableElement.java with the given parameter(s)
     * @param pos
     * @param spd
     */
    public GameElement(Point2D pos, Rectangle2D box) {
    	position = new Point2D.Double(pos.getX(), pos.getY());
		boundingBox = new Rectangle2D.Double(box.getX(), box.getY(), box.getWidth(), box.getHeight());
    }

    /**
     * Returns  Image[] of a GameElement
     * @return
     */
    public abstract Image[] getTexture();
    
    /**
     * Returns the current Image used by the GameElement
     */
    public abstract Image getImage();    
    
    /** Updates the position and behavior of the GameMoveableElement **/
    public abstract void update(double delta);
    
    /** Returns the speed **/
    public abstract double getSpeed();
    
	/**
	 * Set la position du GameElement
	 * @param x position dans l'axe X
	 * @param y position dans l'axe Y
	 */
	public void setPosition(double x, double y) {	
    	position.setLocation(x, y);
    	boundingBox.setRect(x, y, boundingBox.getWidth(), boundingBox.getHeight());
	}
	
	/**
     * Set la position relative du GameElement
     * @param x valeur relative à l'axe X
     * @param y valeur relative à l'axe Y
     */
    public void setRelativePosition(double x, double y) {
        double newX = position.getX() + x;
        double newY = position.getY() + y;
        
        if ((newX + boundingBox.getWidth()) > World.WIDTH) {
            // cas où l'element depasse à droite
            newX = World.WIDTH - boundingBox.getWidth();
        }
        if (newX < 0) {
        	newX = 0;
        }
        this.setPosition(newX, newY);
    }

    /** Moves the object toward a direction with given parameter :
     * @param delta time between 2 frames
     */
    protected void move(double delta) {
        // v = (d / t) so d = v * t;
        double distance = getSpeed() * delta;

        // Calculate the new coordinate
        switch (direction) {
        case UP :
            // If UP then x' = x and y' = y - distance
            setRelativePosition(0, -distance);
            break;
        case DOWN :
            // If DOWN then x' = x and y' = y + distance
            setRelativePosition(0, distance);
            break;
        case LEFT :
            // If LEFT then x' = x - distance and y' = y
            setRelativePosition(-distance, 0);
            break;
        case RIGHT :
            // If LEFT then x' = x + distance and y' = y
            setRelativePosition(distance, 0);
            break;
        default:
            break;
        }
    }

    /** Sets the Direction to the LEFT **/
    public void turnLeft() {
        direction = Direction.LEFT;
    }

    /** Sets the Direction to the RIGHT **/
    public void turnRight() {
        direction = Direction.RIGHT;
    }

    /** Sets the Direction to UP **/
    public void turnUp() {
        direction = Direction.UP;
    }

    /** Sets the Direction to DOWN **/
    public void turnDown() {
        direction = Direction.DOWN;
    }
    
    public void stopMove() {
        direction = Direction.NONE;
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
    
    /** Updates the position and behavior of the GameElement's direction **/
    public Direction getDirection() {
        return this.direction;
    }
    
    /**
     * Returns true if the parameter 'element' has a collision with 'this'
     * @param element
     */
    public boolean hasCollision(GameElement element) {
    	return boundingBox.intersects(element.getBoundingBox());
    }

    public void setBoundingBox(Rectangle2D boundingBox) {
		this.boundingBox = boundingBox;
	}
    
    /** Check if GameElement is out of screen **/
    public abstract boolean isOutOfScreen();

	/** toString **/
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append("    Direction : " + direction + "\n");
        sb.append("    Position : " + position + "\n");
        return sb.toString();
    }
    
    /**
     * Returns WIDTH of the GameElement
     */
    public abstract int getWidth();
    
    /**
     * Returns HEIGHTT of the GameElement;
     */
    public abstract int getHeight();

}
