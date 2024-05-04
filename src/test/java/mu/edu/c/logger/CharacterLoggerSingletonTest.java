package mu.edu.c.logger;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;

import org.junit.jupiter.api.AfterAll;
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
		//repopulate the character file with a temporary file
		logger.logCharacterData(this.player);
	}
	/**
	 * 
	 */
	@Test
	public void testLogCharacterData() throws Exception {
		//test null case
		assertEquals(false, logger.logCharacterData(null));
		assertEquals(true, logger.logCharacterData(this.player));
		
		//file reset
		try {
			//clears the log
			FileWriter overwriter = new FileWriter("src/main/resources/characterLogger.json");
			overwriter.write("");
			overwriter.close();
		}catch(Exception e) {
			throw e;
		}
		//repopulate the character file with a temporary file
		logger.logCharacterData(this.player);
		
	}
	
	@Test
	public void testReadCharacter() {
		assertEquals(null, logger.readCharacter(null));
		String playerString = "{\"attributePoints\":0,\"name\":\"TEST character\",\"hp\":20.0,\"maxHP\":20.0,\"strength\":22,\"defense\":24,\"brains\":26,\"weaponStrategy\":{\"name\":\"Sword of Beginnings\",\"simpleDamage\":1,\"specialDamage\":2,\"scaler\":1.0,\"weapontype\":\"SWORD\"},\"xp\":0}";
		Player playerRead = logger.readCharacter(playerString);
		assertEquals(true, playerRead.equals(this.player));
		
		playerString = "{\"attributePoints\":0,\"name\":\"TEST character\",\"hp\":20.0,\"maxHP\":20.0,\"strength\":22,\"defense\":24,\"brains\":26,\"xp\":0}";
		Player playerReadWithoutWeapon = logger.readCharacter(playerString);
		assertEquals(true, playerReadWithoutWeapon.equals(this.player));
		//repopulate the character file with a temporary file
		logger.logCharacterData(this.player);
	}
	
	@Test
	public void testReadCharacterData() throws Exception {
		try {
			//clears the log
			FileWriter overwriter = new FileWriter("src/main/resources/characterLogger.json");
			overwriter.write("");
			overwriter.close();
		}catch(Exception e) {
			throw e;
		}
		//test for nothing in the json file
		assertEquals(null, logger.readCharacterData());
		
		logger.logCharacterData(player);
		//test after a character has been created
		assertEquals(true, logger.readCharacterData().equals(player));
		//file reset
		try {
			//clears the log
			FileWriter overwriter = new FileWriter("src/main/resources/characterLogger.json");
			overwriter.write("");
			overwriter.close();
		}catch(Exception e) {
			throw e;
		}
		//repopulate the character file with a temporary file
		logger.logCharacterData(this.player);
	}
	



}
