package game;

import game.element.BasicInvader;
import game.element.BasicSpaceShip;
import game.element.Invader;
import game.element.SpaceShip;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Project "Space Invader"
 * M1 Informatique 2016/2017
 * @author BELLEC Leopold
 * @author DAUZVARDIS Juozas
 * @author JUNGES Pierre-Marie
 * @author LIPSKI Guillaume
 *
 */
public class World {
    
	/** World dimensions **/
    public final static int WIDTH = 500;
    public final static int HEIGHT = 600;
    
    /** Score **/
    private int score;
    
    /** Invaders and SpaceShip(Player) **/
    private List<Invader> invaders;
    private SpaceShip spaceShip; 
    
    /** sert a savoir si le jeu est fini **/
    private boolean gameOver = false;

	private final int SPAWN_MIN_RATE=200;
	private int spawnDelay=1000;    
	private int spawnNumber=1;
	private boolean[] spawnTab;
	private long lastSpawn;
    
    public World() {
    	invaders = new LinkedList<Invader>();
    	int nbInvaders = 1;
    	for (int i = 1; i < (nbInvaders + 1); i++) {
    		invaders.add(new BasicInvader(new Point2D.Double((24+5) * i, 16)));
    	}
        this.spaceShip = new BasicSpaceShip(new Point2D.Double(WIDTH/2, HEIGHT-100));
        this.spaceShip.setRelativePosition(-spaceShip.getBoundingBox().getWidth()/2, 0);
        score = 0;
    }
    
    /** Returns the ith Invader **/
	public Invader getInvader(int i) {
		if( i >= 0 && i < invaders.size()) {
			return invaders.get(i);
		} else {
			return null;
		}
	}

	/** Returns the SpaceShip **/
	public SpaceShip getSpaceShip() {
		return spaceShip;
	}
	
	/** Returns the number of invaders available in the List **/
	public int getInvaderNumber() {
	    return invaders.size();
	}
	
	public void deleteInvader(Iterator<Invader> it) {
	    it.remove();
	}
	
	/** Updates all the GameElement present in the World **/
	public void update(double delta) {
	    spaceShip.update(delta);
	    
	    Iterator<Invader> it = invaders.iterator();
	    while (it.hasNext()) {
	        Invader invader = it.next();
	    	invader.update(delta);
	    	manageCollision(invader, it);
	    	
	    	if (invader.isOutOfScreen()) {
                deleteInvader(it);
            }
	    }
	    
		if (System.currentTimeMillis() > lastSpawn + SPAWN_MIN_RATE+spawnDelay) {
			generateInvaders();
			lastSpawn=System.currentTimeMillis();
		}	
	}
	
	private void generateInvaders(){
		int x;
		Random rand=new Random();
		/*
		 * Change the indice without using a Timer
		 */
		spawnTab=new boolean[World.WIDTH/29];
		for(int i=0;i<spawnNumber;i++){
			x=rand.nextInt(World.WIDTH/29);
			while(spawnTab[x]==true){
				x=rand.nextInt(World.WIDTH/29);
			}
			spawnTab[x]=true;
			invaders.add(new BasicInvader(new Point2D.Double((29) * x, 16)));
		}
		spawnDelay=rand.nextInt(500)+200;
		spawnNumber=rand.nextInt(3)+1;
	}
	
	private void manageCollision(Invader invader, Iterator<Invader> i) {
		//si une collision c'est produit entre un invader et le spaceship
		if (this.spaceShip.getBoundingBox().intersects(invader.getBoundingBox())) {
			this.gameOver = true;
		}
		
		boolean hasCollisionLaserInvader = this.spaceShip.manageLaserCollision(invader);
		//si une collision c'est produit entre un invader et un tire
		if (hasCollisionLaserInvader) {
			score += invader.getScore(); // incremente le score
			this.deleteInvader(i);		
		}
	}

	/** Draws inside g all the GameElement's images with their current positions **/
	public void render(Graphics g) {
	    spaceShip.render(g);
	    for (Invader invader : invaders) {
	    	invader.render(g);
	    }
	}
	
	public void restart(){
		this.score=0;
		this.invaders.clear();
		invaders.add(new BasicInvader(new Point2D.Double((24+5), 16)));
        this.spaceShip.setPosition(WIDTH/2, HEIGHT-100);
		this.gameOver=false;
		
	}
	
	/** Returns the score **/
	public int getScore() {
		return score;
	}
	
	public boolean getGameOver() {
		return this.gameOver;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("INVADER :\n");
        for (Invader invader : invaders) {
        	sb.append(invader.toString());
        }
        sb.append("\n-------------------------\n");
        sb.append("SPACE SHIP :\n");
        sb.append(spaceShip.toString());
        
        return sb.toString();
    }
}
