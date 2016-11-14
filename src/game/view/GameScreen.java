package game.view;

import game.World;
import game.element.SpaceShip;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameScreen extends JPanel {
	
	private World world;
	
	public GameScreen(World w) {
		this.world = w;
		this.setBackground(Color.BLACK);
	}
		
	@Override
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		
		SpaceShip s = this.world.getSpaceShip();
		g.drawImage(s.getTexture(), (int)s.getPosition().getX(), (int)s.getPosition().getY(), null);

		this.repaint();
	}
	
}
