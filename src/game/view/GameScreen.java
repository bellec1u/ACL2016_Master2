package game.view;

import game.World;
import game.controler.GameListener;
import game.controler.RefreshListener;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GameScreen extends JPanel {
	
	private World world;
	
	/**
	 * FPS Management
	 */
	private final int fps = 16; // (1 / 60) * 1000 (ms value)
	private Timer timer;
	
	public GameScreen(World w) {
		this.world = w;
		this.setBackground(Color.BLACK);
		
		timer = new Timer(fps, new RefreshListener(this));
		timer.setRepeats(true);
		timer.start();
	}
		
	@Override
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		
		world.update( 0.001666 ); // <- value to determine
		world.render(g);
		
		this.repaint();
	}
	
}
