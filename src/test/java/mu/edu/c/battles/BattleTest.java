package mu.edu.c.battles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mu.edu.c.entities.Player;

class BattleTest {

	private Battle battle = null;
	private Player player = null;
	
	// This method will be invoked for each test method
	@BeforeEach
	void setUp() throws Exception {
		player = new Player(100, 0, 0, 0, "Ryan");
		battle = new Battle(player);
	}
	
	@Test
	void testGetPlayerName() {
		assertEquals("Ryan", battle.getPlayerName());
	}
	
	@Test
	void testGetPlayerHP() {
		assertEquals(100, battle.getPlayerHP());
	}
	
	@Test
	void testGetPlayerMaxHP() {
		assertEquals(100, battle.getPlayerMaxHP());
	}
	
	@Test
	void testRoll() {
		int roll = battle.roll();
		assertTrue(roll >= 1 && roll <= 20);
	}

}
