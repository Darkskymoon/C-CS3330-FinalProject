package mu.edu.c.logger;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mu.edu.c.entities.Player;

class CharacterLoggerSingletonTest {

	CharacterLoggerSingleton logger = null;
	Player player =null;
	
	/**
	 * initializes the logger before each test
	 */
	@BeforeEach
	void init() throws Exception{
		//get the logger twice for each case of the get instance
		logger = CharacterLoggerSingleton.getInstance();
		logger = CharacterLoggerSingleton.getInstance();
		player = new Player(20, 22, 24, 26, "TEST character");
		
		//file reset
		try {
			//clears the log
			FileWriter overwriter = new FileWriter("src/main/resources/characterLogger.json");
			overwriter.write("");
			overwriter.close();
		}catch(Exception e) {
			throw e;
		}
	}
	/**
	 * 
	 */
	@Test
	public void testLogCharacterData() {
		//test null case
		assertEquals(false, logger.logCharacterData(null));
		assertEquals(true, logger.logCharacterData(this.player));
		
		
	}

}
