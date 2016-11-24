package game.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.Timer;

import game.TextureFactory;
import game.World;
import game.controler.RefreshListener;

/**
 * Project "Space Invader"
 * M1 Informatique 2016/2017
 * @author BELLEC Leopold
 * @author DAUZVARDIS Juozas
 * @author JUNGES Pierre-Marie
 * @author LIPSKI Guillaume
 *
 */
@SuppressWarnings("serial")
public class GameScreen extends JPanel {
	
	private World world;
	
	/**
	 * FPS Management
	 */
	private final int frameDuration = 16; //  1000ms / 60fps (ms value)
	private final double delay = ( 1.0 / 60.0 );
	private Timer timer; // use to call repaint() every frameDuration
	
	public GameScreen(World w) {
		super();
	    this.world = w;

		this.setBackground(Color.BLACK);
		
		// calls paintComponent() each 16 ms
		timer = new Timer(frameDuration, new RefreshListener(this));
		timer.setRepeats(true);
		timer.start();
	}
		
	@Override
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);

		/*
		 * Our Timer calls repaint() method every 16 ms which means we have to
		 * update the world with a delta Time equals to ( 1 / 60 ) second = 0.16666 second
		 */
		world.update(delay);
		world.render(g);
		
		/**
		 * Draws the score
		 */
		drawScore(g);
		
		/**
		 * si gameOver est a true, le jeu est fini
		 */
		if (this.world.getGameOver()) {
			this.timer.stop();
		}
	}
	
	public void drawScore(Graphics g) {
	    /**
	     * Sets the Graphics g to draw the Score with a custom Font
	     * deriveFont in order to increase font's size
	     */
	    g.setFont(TextureFactory.getInstance().getFont().deriveFont(20.0f));
	    g.setColor(Color.WHITE); 
	    g.drawString("SCORE " + world.getScore(), (int)(World.WIDTH * 0.45), (World.HEIGHT - 50));
	}
	
}
