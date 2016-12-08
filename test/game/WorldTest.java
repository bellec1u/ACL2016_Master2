package game;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorldTest {

	/**
	 * Test la difficulté du World en EASY
	 */
	@Test
	public void testWorldLevelEasy() {
		World world = new World();
		world.incrementScore(440);
		
		assertTrue(world.getScore() < world.getLevelMedium());
	}
	
	/**
	 * Test la difficulté du World en MEDIUM
	 */
	@Test
	public void testWorldLevelMedium() {
		World world = new World();
		world.incrementScore(760);
		
		assertTrue(world.getScore() >= world.getLevelMedium());
		assertTrue(world.getScore() < world.getLevelHard());
	}
	
	/**
	 * Test la difficulté du World en HARD
	 */
	@Test
	public void testWorldLevelHard() {
		World world = new World();
		world.incrementScore(1510);
		
		assertTrue(world.getScore() > world.getLevelHard());
	}
}
