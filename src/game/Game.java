package game;

import java.util.Scanner;

/**
 * Project "Space Invader"
 * M1 Informatique 2016/2017
 * @author BELLEC Leopold
 * @author DAUZVARDIS Juozas
 * @author JUNGES Pierre-Marie
 * @author LIPSKI Guillaume
 *
 */
public class Game {
    
    private World world;
    
    public Game() {
        this.world = new World();
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
