package game.view;

import game.World;
import game.controler.GameListener;
import game.controler.RefreshListener;

import java.awt.Color;
import java.awt.Dimension;
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
	private final int frameDuration = 16; //  1000ms / 60fps (ms value)
	private final double delay = ( 1.0 / 60.0 );
	private Timer timer;
	
	public GameScreen(World w) {
		this.world = w;
		
		this.setPreferredSize(new Dimension(World.HEIGHT, World.WIDTH));
		this.setBackground(Color.BLACK);
		
		// Calls paintComponent() each 16 ms
		timer = new Timer(frameDuration, new RefreshListener(this));
		timer.setRepeats(true);
		timer.start();
	}
		
	@Override
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		
		world.update(1); // TODO: calculate time elapsed since last update
		world.render(g);
	}
	
}
