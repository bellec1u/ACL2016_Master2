package game;

import game.element.BasicInvader;
import game.element.BasicSpaceShip;
import game.element.DeserterInvader;
import game.element.Bonus;
import game.element.GameElement;
import game.element.Invader;
import game.element.LifeBonus;
import game.element.SpaceShip;
import game.element.SpecialShootBonus;

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

    /** Pallier de difficultés **/
    private final int MEDIUM = 750; 
    private final int HARD = 1500; 
    
    /** Nombre minimum d'Invader a créer par niveau de difficulté **/
    private final int INVADER_EASY = 3;
    private final int INVADER_MEDIUM = 6;
    private final int INVADER_HARD = 10;
    
	private int SPAWN_MIN_RATE = 200;
	private int spawnDelay = 1000;    
	private int spawnNumber = 1;
	private long lastSpawn;
	

	private List<Bonus> listBonus;
	private double tauxSpawnBonus = 0.95;
	
	public World() {
		invaders = new LinkedList<Invader>();    	
		listBonus = new LinkedList<Bonus>();
		addSpaceShip();
		score = 0;
	}

	/** Returns all Worl's element **/
	public List<GameElement> getWorldElements() {
		LinkedList<GameElement> elements = new LinkedList<GameElement>();
		
		// adds the SpaceShip
		elements.add(spaceShip);
		// adds SpaceShip's laser
		elements.addAll(spaceShip.getListLasers());
		
		// adds the invaders
		elements.addAll(invaders);
		
		// adds bonuses
		elements.addAll(listBonus);
		
		return elements;
	}
	
	private void addSpaceShip() {
		this.spaceShip = new BasicSpaceShip(new Point2D.Double(WIDTH/2, HEIGHT-100));
		this.spaceShip.setRelativePosition(-spaceShip.getBoundingBox().getWidth()/2, 0);
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

	private void deleteInvader(Iterator<Invader> it) {
		it.remove();
	}

	/** Updates all the GameElement present in the World **/
	public void update(double delta) {
		spaceShip.update(delta);

		Iterator<Invader> it = invaders.iterator();
		
		// temporary list
		LinkedList<Invader> invaderShot = new LinkedList<Invader>();
		while (it.hasNext()) {
			Invader invader = it.next();
			invader.update(delta);
			manageCollision(invader, it);

			if(invader.hasDeserters()){
	    		invaderShot.add(new DeserterInvader(new Point2D.Double(invader.getPosition().getX()+10,invader.getPosition().getY()+8)));
	    	}
			
			if (invader.isOutOfScreen()) {
				deleteInvader(it);
			}
		}

		invaders.addAll(invaderShot);
		
		// gestion des bonus
		Iterator<Bonus> ssb = this.listBonus.iterator();
		while (ssb.hasNext()) {
			Bonus s = ssb.next();
			s.update(delta);
			//manage collision entre bonus  & Spaceship
			manageCollision(s, ssb);

			if (s.isOutOfScreen()) {
				this.deleteBonus(ssb);
			}
		}

		if (System.currentTimeMillis() > lastSpawn + SPAWN_MIN_RATE+spawnDelay) {
			generateInvaders();
			lastSpawn = System.currentTimeMillis();
		}	
	}

	private void generateInvaders(){
		int x;
		Random rand = new Random();
		/*
		 * Change the indice without using a Timer
		 */
		int divideBy = 29;
		int rows = (World.WIDTH / divideBy);
		boolean[] spawnTab = new boolean[rows];
		for(int i = 0 ; i < spawnNumber ; i++){
			x = rand.nextInt(rows);
			while( spawnTab[x] == true ){
				x = rand.nextInt(rows);
			}
			spawnTab[x] = true;
			invaders.add(new BasicInvader(new Point2D.Double((divideBy) * x, 16)));
		}
	}
	
	/**
	 * Modifie le niveau du Jeu si le score de l'utilisateur
	 * depasse certains palliers définies ci-dessus ( champs EASY, MEDIUM, HARD )
	 * cette fonction modifiera le spawnDelay et le spawnNumber
	 */
	private void updateLevel() {
		// Pour générer des nombres aleatoires
		Random rand = new Random();
		
		// niveau facile
		if ( score < MEDIUM ) {
			spawnDelay = rand.nextInt(500) + SPAWN_MIN_RATE;
			spawnNumber = rand.nextInt(INVADER_EASY) + 1;
		}
		
		// niveau medium
		if( score >= MEDIUM && score < HARD ) {
			spawnDelay = rand.nextInt(400) + SPAWN_MIN_RATE;
			spawnNumber = rand.nextInt(INVADER_MEDIUM) + 1;
		}
		
		// niveau hard
		if ( score >= HARD ) {
			spawnDelay = rand.nextInt(200) + SPAWN_MIN_RATE;
			spawnNumber = rand.nextInt(INVADER_HARD) + 1;
		}
	}

	private void manageCollision(Invader invader, Iterator<Invader> iter) {
		//si une collision c'est produit entre un invader et le spaceship
		if ( this.spaceShip.hasCollision(invader) ) {
			spaceShip.decrementLives();
			iter.remove();

			if (spaceShip.isWrecked()) {
				gameOver = true;
			}

		} else {
			boolean hasCollisionLaserInvader = this.spaceShip.manageLaserCollision(invader);
			//si une collision c'est produit entre un invader et un tire
			if (hasCollisionLaserInvader) {
				// incremente le score
				incrementScore(invader.getScore());

				Point2D pos = invader.getPosition();

				iter.remove();

				// proba de drop un bonus de tire spécial = 20%
				if (Math.random() >= this.tauxSpawnBonus) {
					this.generateBonus(pos);
				}

			}
		}
	}

	private void manageCollision(Bonus ssb, Iterator<Bonus> issb) {
		//si une collision c'est produit entre le vaisseau et le bonus special shoot
		if ( this.spaceShip.hasCollision(ssb) ) {
			ssb.applyBonus(spaceShip);
			this.deleteBonus(issb);		
		} 
	}

	/** 
	 * methode qui sert a generer un bonus aux coordonées x, y
	 * @param x
	 * @param y
	 */
	private void generateBonus(Point2D pos) {
		if (Math.random() >= 1.0/2) {
			SpecialShootBonus ssb = new SpecialShootBonus(pos);
			this.listBonus.add(ssb);
		} else {
			LifeBonus lb = new LifeBonus(pos);
			this.listBonus.add(lb);
		}
	}
	
	/**
	 * Fonction pour tester le fonctionnement des bonus
	 */
	public void testerBonus(Bonus bonus) {
		this.listBonus.add(bonus);
	}

	private void deleteBonus(Iterator<Bonus> ib) {
		ib.remove();
	}

	public void restart() {
		if ( getGameOver() ) {
			this.score = 0;
			this.invaders.clear();
			addSpaceShip();
			updateLevel();
			this.gameOver = false;
			this.listBonus.clear();		//if (Math.random() >= 1.0/2) {
		}
	}

	/** Returns the score **/
	public int getScore() {
		return score;
	}

	public boolean getGameOver() {
		return this.gameOver;
	}

	/** Adds value to the score **/
	public void incrementScore(int value) {
		score += value;
		updateLevel() ;
	}
	
	/** Returns MEDIUM **/
	public int getLevelMedium() {
		return MEDIUM;
	}
	
	/** Returns HARD **/
	public int getLevelHard() {
		return HARD;
	}

	public List<Bonus> getListBonus() {
		return listBonus;
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
