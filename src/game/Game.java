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
    
    public void update() {
        
    }
    
    public void start() {
        Scanner s = new Scanner(System.in);
        String input = "";
        
        while (!input.equals("q")) {
            System.out.println(world);
            System.out.print("Commande : ");
            input = s.nextLine();
            
            
            //System.out.println("Input : " + input);
        }
        
        s.close();
    }
    
   
}
