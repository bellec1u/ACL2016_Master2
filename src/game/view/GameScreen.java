package game.view;

import game.World;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameScreen extends JPanel {
	
	private World world;
	
	public GameScreen(World w) {
		this.world = w;
		this.setBackground(Color.BLACK);
	}
		
	@Override
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		
		world.update(1);
		world.rendre(g);
		
		// TODO: sleep right amount of time
		try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

		this.repaint();
	}
	
}
