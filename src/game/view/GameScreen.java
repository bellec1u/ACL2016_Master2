package game.view;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.SoundFactory;
import game.TextureFactory;
import game.World;
import game.element.GameElement;

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

	/**
	 * World
	 */
	private World world;

	/**
	 * Music
	 */
	private Clip music;

	/**
	 * FPS Management
	 */
	private final int frameDuration = 16; //  1000ms / 60fps (ms value)
	private final double delay = ( 1.0 / 60.0 );
	private Timer timer; // use to call repaint() every frameDuration
	private boolean paused; // indicates if the game if paused or not

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

		// loads musics
		music = SoundFactory.getInstance().getBackgroundSound();
		music.loop(Clip.LOOP_CONTINUOUSLY);
		music.start();
		
		paused = true;
	}

	/** Pause the Game **/
	public void togglePause() {
		if (!world.getGameOver()) {
			paused = !paused;
		}
	}
	
	/** Mute the music is the music is active and if the pause menu is not open **/ 
	public void toggleMusic() {
		if ( music.isActive() ) {
			music.stop();
		} else {
			music.loop(Clip.LOOP_CONTINUOUSLY);
			music.start();
		}
	}
	
	/** Returns the variable world **/
	public World getWorld() {
		return world;
	}

	/**
	 * Most important graphic function,
	 * used here to draw every GameElements of the World
	 */
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);

		/**
		 * si gameOver est a true, le jeu est fini
		 */
		if (!this.world.getGameOver()) {
			/*
			 * Draws the score
			 */
			drawScore(g);
			drawSpaceShipLives(g);
			drawSpaceShipSpecialShoot(g);

			/*
			 * Our Timer calls repaint() method every 16 ms which means we have to
			 * update the world with a delta Time equals to ( 1 / 60 ) second = 0.16666 second
			 */
			if (!paused) {
				world.update(delay);
			}

			renderWorld(g);
			if (paused) {
				drawPauseScreen(g);
			}

		} else {
			drawGameOver(g);	
		}

	}

	/**
	 * Draws all the World's Element into Graphics g
	 */
	private void renderWorld(Graphics g) {
		// get all worlds elements
		List<GameElement> elements = world.getWorldElements();

		// iterates and draw each element into g
		for(GameElement gameElement : elements) {

			g.drawImage(gameElement.getImage(), 
					(int)gameElement.getPosition().getX(),
					(int)gameElement.getPosition().getY(), 
					(int)gameElement.getWidth(),
					(int)gameElement.getHeight(),
					null);
			
		}
	}
	
	/**
	 * @return the abscissa of the centered string on screen
	 */
	private int getCenteredStringX(Graphics g, String str) {
		FontMetrics fm = g.getFontMetrics();
		return World.WIDTH/2 - fm.stringWidth(str)/2;
	}

	/**
	 * Sets the Graphics g to draw the Score with a custom Font
	 * deriveFont in order to increase font's size
	 */
	public void drawScore(Graphics g) {
		g.setFont(TextureFactory.getInstance().getFont().deriveFont(20.0f));
		g.setColor(Color.WHITE);

		String txt = "SCORE " + world.getScore();
		g.drawString(txt, getCenteredStringX(g, txt), (World.HEIGHT - 50));
	}

	public void drawGameOver(Graphics g) {
		String txt;
		g.setFont(TextureFactory.getInstance().getFont().deriveFont(40.0f));
		g.setColor(Color.RED);
		txt = "GAME OVER";
		g.drawString(txt, getCenteredStringX(g, txt), (World.HEIGHT/2-25));
		g.setFont(TextureFactory.getInstance().getFont().deriveFont(20.0f));
		g.setColor(Color.WHITE);
		txt = "SCORE  " + world.getScore();
		g.drawString(txt, getCenteredStringX(g, txt), (World.HEIGHT/2));
		txt = "press  R  to  reset";
		g.drawString(txt, getCenteredStringX(g, txt), (World.HEIGHT/2+40));
	}

	public void drawSpaceShipLives(Graphics g) {
		g.setFont(TextureFactory.getInstance().getFont().deriveFont(20.0f));
		g.setColor(Color.WHITE);
		g.drawImage(TextureFactory.getInstance().getSpaceShipColorImg(), 20, World.HEIGHT - 62, null);
		String txt = "x " + world.getSpaceShip().getLives();
		g.drawString(txt, 45, (World.HEIGHT - 50));
	}


	public void drawPauseScreen(Graphics g) {
		g.setColor(new Color(.0f, .0f, .0f, .85f));
		g.fillRect(0, 0, World.WIDTH, World.HEIGHT);

		g.setColor(Color.GREEN);
		g.setFont(TextureFactory.getInstance().getFont().deriveFont(40.0f));
		String txt = "PAUSE";
		g.drawString(txt, getCenteredStringX(g, txt), 100);

		// Draw control keys
		g.setColor(Color.WHITE);
		g.setFont(TextureFactory.getInstance().getMonospacedFont());
		String[] texts = {
            "  m     mute the music",
            "  n     special laser",
            "  \u2192     move right", 
            "  \u2190     move left", 
            "SPACE   shoot",
            " ESC    pause", 
            "  q     quit"};
		int x = getCenteredStringX(g, texts[0]);
		int y = 130;

		for (String str : texts) {
			y += 20;
			g.drawString(str, x, y);
		}
	}

	public void drawSpaceShipSpecialShoot(Graphics g) {
		g.setFont(TextureFactory.getInstance().getFont().deriveFont(20.0f));
		g.setColor(Color.WHITE);
		g.drawImage(TextureFactory.getInstance().getSpecialShootBonus()[0], 20, World.HEIGHT - 47, null);
		String txt = "x " + world.getSpaceShip().getNbSpecialShoot();
		g.drawString(txt, 45, (World.HEIGHT - 30));

	}
}
