package game;

import game.controler.GameListener;
import game.view.GameScreen;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Scanner;

import javax.swing.JFrame;
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
public class Game extends JFrame{
    
    private World world;
	private final static String title = "Space invader";
    
	// Timer and FPS
	private Timer timer;
	private int fps = 16 ; // ~60 fps = ( 1 / 60 ) * 1000 
	
    public Game() {
        this.world = new World();
        
        this.setTitle(title);
		this.setPreferredSize(new Dimension(this.world.WIDTH, this.world.HEIGHT));
		this.setResizable(false);
		
		GameScreen gs = new GameScreen(this.world);
		this.add(gs);
		
		// Defaults operations
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Timer uses to manage fps
		timer = new Timer(fps, new GameListener());
		timer.setRepeats(true);
		timer.start();
    }
    
    /**
     * methode qui lance le jeu
     */
    public void start() {
        Scanner s = new Scanner(System.in);
        String input = "";
        
        while (!input.equals("q")) {
        	System.out.println("+========================+");
            System.out.println(world);
            System.out.println("+========================+");
            System.out.println();
            System.out.println("Commandes : (l)eft, (r)ight, (q)uit");
            System.out.print("Entrez : ");
            input = s.nextLine();
                   
            switch (input) {
            case "l":
                world.spaceShip.turnLeft();
                break;
            case "r":
                world.spaceShip.turnRight();
                break;
            default:
                world.spaceShip.stopMove();
                break;
            }
            
            world.update(1);
            //System.out.println("Input : " + input);
        }
        
        s.close();
    }
    
    public World getWorld() {
    	return this.world;
    }
   
}
