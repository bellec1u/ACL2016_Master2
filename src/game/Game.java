package game;

import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.util.Scanner;

import javax.swing.JFrame;

import game.controler.*;
import game.view.GameScreen;

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
public class Game extends JFrame {
    
    private World world;
    private KeyListener listener;
	private final static String TITLE = "Space Invader";
	
    public Game() {
        this.world = new World();
		this.listener = new GameListener(world.getSpaceShip());
		
		GameScreen gs = new GameScreen(this.world);
		this.add(gs);
		
		addKeyListener(listener);
		
		initGraphics();
    }
    
    private void initGraphics() {
        this.setTitle(TITLE);
        this.setPreferredSize(new Dimension(World.WIDTH, World.HEIGHT));
        this.setResizable(false);
        
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null); // display window in the middle of the screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    
 
}
