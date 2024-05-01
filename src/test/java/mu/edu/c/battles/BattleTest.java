package mu.edu.c.battles;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mu.edu.c.entities.Enemy;
import mu.edu.c.entities.Player;

class BattleTest {

	private Battle battle = null;
	private Player player = null;
	private Enemy enemy = null;
	
	// This method will be invoked for each test method
	@BeforeEach
	void setUp() throws Exception {
		player = new Player(100, 0, 0, 0, "Ryan");
		enemy = new Enemy(100, 0, 0,0, "Zombie");
		battle = new Battle(player);
		
	}
	
	@Test 
	void testPlayerEnemyBattleConstructor() {
		//creates new battle with the two parameters
		Battle battle = new Battle(player, enemy);
		//tests to see if a battle object was created
		if(battle != null && battle.getClass()==Battle.class) {
			//test that the zombie and player were created
			testGetPlayerName();
			assertEquals("Zombie", battle.getCurrentEnemyName());	
		}
		else
		{
			fail("battle not created");
		}
	}
	
	//TODO: how to test to make sure file throws the exception
	@Test
	void testInitializeEnemies() {
		File battlelog = new File("src/main/resources/enemyLogger.json");
		battlelog.delete();
		assertEquals(true, battle.initializeEnemies());
		
	}
	
	@Test
	void testGetCurrentEnemy() {
		battle.setCurrentEnemy(enemy);
		assertEquals(this.enemy, battle.getCurrentEnemy());
	}
	
	@Test
	void testSetCurrentEnemyWEnemy() {
		assertEquals(this.enemy, battle.setCurrentEnemy(enemy));
	}
	
	@Test
	void testGetCurrentEnemyMaxHP() {
		testSetCurrentEnemyWEnemy();
		assertEquals(100, battle.getCurrentEnemyMaxHP());
	}
	
	@Test
	void testGetCurrentEnemyCurrentHP() {
		testSetCurrentEnemyWEnemy();
		assertEquals(100, battle.getCurrentEnemyCurrentHP());
	}
	
	@Test
	void testSetCurrentEnemyCurrentHP() {
		testSetCurrentEnemyWEnemy();
		assertEquals(15, battle.setCurrentEnemyCurrentHP(15));
		
	}
	
	@Test 
	void testToString() {
		testSetCurrentEnemyWEnemy();
		assertEquals("Ryan vs Zombie", battle.toString());
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
