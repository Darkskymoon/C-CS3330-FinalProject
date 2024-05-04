package mu.edu.c.logger;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mu.edu.c.entities.Enemy;

class EnemyLoggerSingletonTest {
	EnemyLoggerSingleton logger= null;
	Enemy enemy = null;
	
	/**
	 * sets up the enemy logger before each test
	 */
	@BeforeEach
	void setup() throws Exception{
		logger = EnemyLoggerSingleton.getInstance();
		logger = EnemyLoggerSingleton.getInstance();
		
		try {
			//clears the log
			FileWriter overwriter = new FileWriter("src/main/resources/enemyLogger.json");
			overwriter.write("");
			overwriter.close();
		}catch(Exception e) {
			throw e;
		}
		
		this.enemy =new Enemy(110, 102, 103, 100, "TEST ENEMY");
		
	}
	
	@Test
	public void TestlogEnemyData() throws Exception{
		//tests null case
		assertEquals(false, logger.logEnemyData(null));
		//tests normal case
		assertEquals(true, logger.logEnemyData(this.enemy));
		
		//Note that log enemy data is not fully tested since one of the cases only occurs when the built in java writer fails
		
		try {
			//clears the log
			FileWriter overwriter = new FileWriter("src/main/resources/enemyLogger.json" );
			overwriter.write("");
			overwriter.close();
		}catch(Exception e) {
			throw e;
		}
	}
	
	@Test
	public void TestReadAllEnemyData() throws Exception {
		ArrayList<Enemy> allEnemies = logger.readAllEnemyData();
		Enemy enemy[]= {new Enemy(1, 2, 3, 4, "Zombie"),
				new Enemy(15, 5, 15, 15, "Vampire"),
				new Enemy(14, 8, 12, 4, "Skeleton"),
				new Enemy(12, 10, 10, 11, "Orc"),
				new Enemy(1,2,8,8, "Goblin"),
				new Enemy(12,12,20,12, "Dragon"),
				new Enemy(16, 5,13,5, "Warlock"),
				new Enemy(12, 14, 13, 2, "Bear"),
				new Enemy(10, 5, 8,3, "Killer Rabbit"),
				new Enemy(12, 10, 10, 10, "Werewolf")};
		
		
		for(int i = 0; i<enemy.length && enemy.length==allEnemies.size(); i++) {
			if(i<allEnemies.size()) {
				assertEquals(true, allEnemies.get(i).equals(enemy[i]));
			}
			
		}
		try {
			//clears the log
			FileWriter overwriter = new FileWriter("src/main/resources/enemyLogger.json");
			overwriter.write("");
			overwriter.close();
		}catch(Exception e) {
			throw e;
		}
		
		logger.logEnemyData(enemy[0]);
		logger.logEnemyData(enemy[3]);
		
		ArrayList<Enemy> allEnemies2= logger.readAllEnemyData();
		
		if(allEnemies2.size()==2) {
			assertEquals(true, allEnemies2.get(0).equals(enemy[0]));
			assertEquals(true, allEnemies2.get(1).equals(enemy[3]));
			
		}
		else {
			fail("Read in too many enemies");
		}
		
	
	}
	
	
}
