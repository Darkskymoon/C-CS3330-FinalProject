package mu.edu.c.weapons;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import mu.edu.c.entities.Enemy;
import mu.edu.c.entities.Player;

class MagicWeaponTest {

	private Player player = null;
	private Enemy enemy = null;
	
	// This method will be invoked for each test method
	@BeforeEach
	void setUp() throws Exception {
		player = new Player(100, 50, 20, 20, "Ryan");
		enemy = new Enemy(100, 20, 20, 20, "Goblin");
	}
	
	@ParameterizedTest
	@MethodSource("provideValuesForSimpleAttack")
	public void testSimpleAttack(IWeapon weapon, int expected) {
		player.setWeaponStrategy(weapon);
		
		float health1 = enemy.getHp();
		player.simpleAttack(enemy, 100);
		float health2 = enemy.getHp();
		
		float damage = health1 - health2;
		
		assertTrue((damage == expected) || (damage ==  0));
	}
	
	public static Stream<Object[]> provideValuesForSimpleAttack() {
		return Stream.of(
			new Object[]{new MagicWeapon("Cool Magic", 5, -100, 2), 7},
			new Object[]{new MagicWeapon("Cool Magic", 5, 10, 1), 6},
			new Object[]{new MagicWeapon("Cool Magic", 5, 25, 0), 5},
			new Object[]{new MagicWeapon("Cool Magic", 10, 97, 2), 12},
			new Object[]{new MagicWeapon("Cool Magic", 10, 57, 1), 11},
			new Object[]{new MagicWeapon("Cool Magic", 10, 2, 0), 10}
		);
	}
	
	@ParameterizedTest
	@MethodSource("provideValuesForSpecialAttack")
	public void testSpecialAttack(IWeapon weapon, int expected) {
		player.setWeaponStrategy(weapon);
		
		float health1 = enemy.getHp();
		player.specialAttack(enemy, 100);
		float health2 = enemy.getHp();
		
		float damage = health1 - health2;
		
		assertTrue((damage == expected) || (damage ==  0));
	}
	
	public static Stream<Object[]> provideValuesForSpecialAttack() {
		return Stream.of(
			new Object[]{new MagicWeapon("Cool Magic", -100, 5, 2), 7},
			new Object[]{new MagicWeapon("Cool Magic", 10, 5, 1), 6},
			new Object[]{new MagicWeapon("Cool Magic", 25, 5, 0), 5},
			new Object[]{new MagicWeapon("Cool Magic", 97, 10, 2), 12},
			new Object[]{new MagicWeapon("Cool Magic", 57, 10, 1), 11},
			new Object[]{new MagicWeapon("Cool Magic", 2, 10, 0), 10}
		);
	}
	
}
