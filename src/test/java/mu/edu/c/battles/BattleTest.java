package mu.edu.c.battles;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mu.edu.c.entities.Enemy;
import mu.edu.c.entities.Player;

class BattleTest{
	private Battle battle = null;
	private Player player = null;
	private Enemy enemy = null;
	
	// This method will be invoked for each test method
	@BeforeEach
	public void setUp() throws Exception {
		player = new Player(100, 0, 0, 0, "Ryan");
		enemy = new Enemy(100, 0, 0,0, "Zombie");
		battle = new Battle(player);
		
	}
	
	@Test 
	public void testPlayerEnemyBattleConstructor() {
		//creates new battle with the two parameters
		Battle battle = new Battle(player, enemy);
		//tests to see if a battle object was created
		if(battle != null && battle.getClass()==Battle.class) {
			//test that the zombie and player were created
//			testGetPlayerName();
			assertEquals("Ryan", battle.getPlayerName());
			assertEquals("Zombie", battle.getCurrentEnemyName());	
		}
		else
		{
			fail("battle not created");
		}
	}
	
	//TODO: how to test to make sure file throws the exception
	@Test
	public void testInitializeEnemies() {
		File battlelog = new File("src/main/resources/enemyLogger.json");
		battlelog.delete();
		assertEquals(true, battle.initializeEnemies());
		
	}
	
	@Test
	public void testGetCurrentEnemy() {
		battle.setCurrentEnemy(enemy);
		assertEquals(this.enemy, battle.getCurrentEnemy());
	}
	
	@Test
	public void testSetCurrentEnemyWEnemy() {
		assertEquals(this.enemy, battle.setCurrentEnemy(enemy));
	}
	
	@Test
	public void testGetCurrentEnemyMaxHP() {
		testSetCurrentEnemyWEnemy();
		assertEquals(100, battle.getCurrentEnemyMaxHP());
	}
	
	@Test
	public void testGetCurrentEnemyCurrentHP() {
		testSetCurrentEnemyWEnemy();
		assertEquals(100, battle.getCurrentEnemyCurrentHP());
	}
	
	@Test
	public void testSetCurrentEnemyCurrentHP() {
		testSetCurrentEnemyWEnemy();
		assertEquals(15, battle.setCurrentEnemyCurrentHP(15));
		
	}
	
	@Test 
	public void testToString() {
		testSetCurrentEnemyWEnemy();
		assertEquals("Ryan vs Zombie", battle.toString());
	}
	@Test
	public void testGetPlayerName() {
		assertEquals("Ryan", battle.getPlayerName());
	}
	
	@Test
	public void testGetPlayerHP() {
		assertEquals(100, battle.getPlayerHP());
	}
	
	@Test
	public void testGetPlayerMaxHP() {
		assertEquals(100, battle.getPlayerMaxHP());
	}
	/**
	 * Tests the createPossible enemies method
	 * @throws IOException
	 */
	@Test
	public void testGetPlayer() {
		assertEquals(player, battle.getPlayer());
	}
	@Test
	public void testRoll() {
		int roll = battle.roll();
		assertTrue(roll >= 1 && roll <= 20);
	}
	
	//TODO: not really sure how to test this 
	@Test
	public void testEnemyAttack() {
		
	}
	
	@Test
	public void testCharacterSimpleAttack() {
		//test for hit
		assertEquals(2, battle.characterSimpleAttack(100, enemy));
		
		//test for certain miss
		assertEquals(0, battle.characterSimpleAttack(-1, enemy));
		
		//test for fail - now this is tough to properly test since it is up to random chance
		float missedAttack = battle.characterSimpleAttack(0, enemy);
		assertTrue(missedAttack==0 || missedAttack==2);
		
		
	}
	
	@Test
	public void testCharacterSpecialAttack() {
		//test for hit
		assertEquals(3, battle.characterSpecialAttack(100, enemy));
		
		//test for certain miss
		assertEquals(0, battle.characterSpecialAttack(-1, enemy));
		
		//test for fail - now this is tough to properly test since it is up to random chance
		float missedAttack = battle.characterSpecialAttack(0, enemy);
		assertTrue(missedAttack==0 || missedAttack==2);
		
		
	}

}
