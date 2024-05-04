package mu.edu.c.logger;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BattleLoggerSingletonTest {
	private BattleLoggerSingleton logger = null;

	@BeforeEach
	void setUp() throws Exception {
		logger = BattleLoggerSingleton.getInstance();
		logger = BattleLoggerSingleton.getInstance();
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
