package main;

import game.Game;
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
public class Main {

	/**
	 * main function
	 * @param args arguments
	 */
	public static void main(String[] args){	
		Game game = new Game();
		GameScreen gs = new GameScreen(game.getWorld());
		game.start();
		
		System.out.println("END");
	}
}
