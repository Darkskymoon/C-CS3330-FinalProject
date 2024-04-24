package mu.edu.c.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnemyTest {
	
	private Enemy enemy = null;
	
	// This method will be invoked for each test method
	@BeforeEach
	void setUp() throws Exception {
		enemy = new Enemy(100, 20, 20, 20, "Goblin");
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
}
