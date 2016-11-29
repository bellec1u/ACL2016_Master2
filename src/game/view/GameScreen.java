package game.view;

import game.TextureFactory;
import game.World;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

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
		timer = new Timer(frameDuration, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
			
		});
		timer.setRepeats(true);
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);

		/**
		 * si gameOver est a true, le jeu est fini
		 */
		if (!this.world.getGameOver()) {
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

		}else{
			drawGameOver(g);	
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

	public void drawGameOver(Graphics g){
		/**
		 * Sets the Graphics g to draw the Score with a custom Font
		 * deriveFont in order to increase font's size
		 */
		g.setFont(TextureFactory.getInstance().getFont().deriveFont(20.0f));
		g.setColor(Color.WHITE); 
		g.drawString("GAME OVER", (int)(World.WIDTH*0.40), (World.HEIGHT/2-25));
		g.drawString(" SCORE  " + world.getScore(),(int)(World.WIDTH*0.40), (World.HEIGHT/2));
		g.drawString("press R to reset",(int)(World.WIDTH*0.35), (World.HEIGHT/2+40));
	}
}
