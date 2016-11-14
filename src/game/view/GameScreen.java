package game.view;

import game.World;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameScreen extends JFrame {

	private World world;
	private final static String title = "Space invader";
	
	public GameScreen(World w) {
		this.world = w;
		this.setTitle(title);
		this.setPreferredSize(new Dimension(this.world.WIDTH, this.world.HEIGHT));
		this.setResizable(false);
		
		JPanel game = new JPanel();

		game.setBackground(Color.BLACK);
		
		this.add(game);
		
		//Defaults operations
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
