package main;

import game.Game;

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
		game.start();
		
		System.out.println("END");
	}
}
