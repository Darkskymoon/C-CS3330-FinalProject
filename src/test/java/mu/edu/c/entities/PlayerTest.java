package mu.edu.c.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

	private Player player = null;
	
	// This method will be invoked for each test method
	@BeforeEach
	void setUp() throws Exception {
		EntityFactoryMethod entityFactory = new EntityFactoryMethod();
		player =entityFactory.createPlayer(100, 20, 20, 20, "Ryan");
//		player = new Player(100, 20, 20, 20, "Ryan");
	}
	
	@Test
	void testGetAttributePoints() {
		assertEquals(0, player.getAttributePoints());
	}
	
	@Test
	void testSetAttributePoints() {
		player.setAttributePoints(97);
		assertEquals(97, player.getAttributePoints());
	}
	
	

}
