package mu.edu.c.logger;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mu.edu.c.battles.Battle;
import mu.edu.c.entities.Enemy;
import mu.edu.c.entities.Player;

class BattleLoggerSingletonTest {
	
	Player player =null;
	Enemy enemy = null;
	Battle battle = null;
	private BattleLoggerSingleton logger = null;

	@BeforeEach
	void setUp() throws Exception {
		logger = BattleLoggerSingleton.getInstance();
		logger = BattleLoggerSingleton.getInstance();
		try {
			//clears the battle logger
			FileWriter overwriter = new FileWriter("src/main/resources/battleLogger.json");
			overwriter.write("");
			overwriter.close();
		}catch(Exception e) {
			throw e;
		}
		this.player = new Player(100, 100, 100, 100, "TempPlayer");
		this.enemy = new Enemy(100, 100, 100, 100, "Temp enemy");
		//writes a single battle
		this.battle = new Battle(this.player, this.enemy);
//		logger.logBattleData(this.battle);
	}


	/**
	 * tests that a battle can be logged
	 */
	@Test
	public void testLogBattleData() throws Exception{
		//tests null case
		assertEquals(false, logger.logBattleData(null));
		
		assertEquals(true, logger.logBattleData(battle));
		//resets file
		try {
			//clears the battle logger
			FileWriter overwriter = new FileWriter("src/main/resources/battleLogger.json");
			overwriter.write("");
			overwriter.close();
		}catch(Exception e) {
			throw e;
		}
		//note that an additional case hasn't been tested since it relies on a IOexception to trigger from filewriter
	}
	
	@Test
	public void testReadAllBattleData() throws Exception{
		//no battles to read in - failure
		assertEquals(null, logger.readAllBattleData());
		logger.logBattleData(battle);
		ArrayList<Battle> battles = logger.readAllBattleData();
//		System.out.println(battles.get(0));
//		System.out.println(battle);
		assertEquals(true, this.battle.equals(battles.get(0)));
		try {
			//writes random stuff to the battle data 
			FileWriter overwriter = new FileWriter("src/main/resources/battleLogger.json");
			overwriter.write("asdfkasdjflkajt; esoj random garbaget text");
			overwriter.close();
		}catch(Exception e) {
			throw e;
		}
		//tests case in which no battles could be read in
		assertEquals(null, logger.readAllBattleData());
		
		try {
			//clears the battle logger
			FileWriter overwriter = new FileWriter("src/main/resources/battleLogger.json");
			overwriter.write("");
			overwriter.close();
		}catch(Exception e) {
			throw e;
		}
	}
	
//	@AfterAll
//	void cleanup() throws Exception{
//		try {
//			//clears the battle logger
//			FileWriter overwriter = new FileWriter("src/main/resources/battleLogger.json");
//			overwriter.write("");
//			overwriter.close();
//		}catch(Exception e) {
//			throw e;
//		}
//	}
	
}
