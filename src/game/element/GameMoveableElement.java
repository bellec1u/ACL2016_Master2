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
public abstract class GameMoveableElement extends GameElement{

    /** Speed of movement 
     * Since we decide to update every 0.0166 second ( 60 fps purpose )
     * the value of speed has too be greater or equals than 60 ( >= 60 );
     * mathematical explanation :
     *  (1 / 60 ) * 60 = 1 <- object moves at 1 pixel LEFT / RIGHT / UP / DOWN every refresh
     * because we can draw only integers coordinates (cf : drawImage() method )
     * */
    private double speed;

    /** Direction of movement **/
    protected enum Direction { UP, DOWN, LEFT, RIGHT, NONE };

    /** Attribute Direction **/
    protected Direction direction = Direction.NONE;

    /**
     * Constructs a GameMoveableElement.java with the given parameter(s)
     * @param pos
     * @param spd
     */
    public GameMoveableElement(Point2D pos, Rectangle2D box, double spd) {
        super(pos, box);
        speed = spd;
    }


    /** Moves the object toward a direction with given parameter :
     * @param delta time between 2 frames
     */
    protected void move(double delta) {
        // v = (d / t) so d = v * t;
        double distance = speed * delta;

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

    /** Updates the position and behavior of the GameMoveableElement **/
    public abstract void update(double delta);

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

    /** Returns the speed **/
    public double getSpeed() {
        return speed;
    }

    /** Returns the GameMoveableElement's direction **/
    public Direction getDirection() {
        return this.direction;
    }

    /** toString **/
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append(super.toString());
        sb.append("    Direction : " + direction + "\n");
        return sb.toString();
    }

}
