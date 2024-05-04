package mu.edu.c.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import mu.edu.c.weapons.IWeapon;
import mu.edu.c.weapons.WeaponFactoryMethod;
import mu.edu.c.weapons.WeaponType;

class EntityTest {
	
	private Player player = null;
	private Enemy enemy = null;
	
	// This method will be invoked for each test method
	@BeforeEach
	void setUp() throws Exception {
		player = new Player(100, 20, 20, 20, "Ryan");
		enemy = new Enemy(100, 20, 20, 20, "Goblin");
	}
	

	
	@ParameterizedTest
	@MethodSource("provideValuesForModifiers")
	public void testCalculateStrengthModifer(int input, int expected) {
		player = new Player(100, input, 20, 20, "Ryan");
		assertEquals(expected, player.calculateStrengthModifier());
	}
	
	@ParameterizedTest
	@MethodSource("provideValuesForModifiers")
	public void testCalculateDefenseModifer(int input, int expected) {
		player = new Player(100, 20, input, 20, "Ryan");
		assertEquals(expected, player.calculateDefenseModifier());
	}
	
	@ParameterizedTest
	@MethodSource("provideValuesForModifiers")
	public void testCalculateBrainsModifer(int input, int expected) {
		player = new Player(100, 20, 20, input, "Ryan");
		assertEquals(expected, player.calculateBrainsModifier());
	}
	
	public static Stream<Object[]> provideValuesForModifiers() {
		return Stream.of(
			new Object[]{23, 10},
			new Object[]{22, 8},
			new Object[]{17, 6},
			new Object[]{14, 4},
			new Object[]{11, 2},
			new Object[]{8, 0},
			new Object[]{4, -2},
			new Object[]{3, -4}
		);
	}
	
	@ParameterizedTest
	@MethodSource("provideValuesForDamageRecieved")
	public void testDamageRecieved(int input, float expected) {
		player.damageRecieved(input);
		assertEquals(expected, player.getHp());
	}
	
	@Test
	public void testCalculateNewHP() {
		assertEquals(player.getMaxHP(), player.calculateNewHP(400000));
	}
	
	public static Stream<Object[]> provideValuesForDamageRecieved() {
		return Stream.of(
			new Object[]{1000, 0},
			new Object[]{22, 78}
		);
	}
	
	@Test
	void testGetName() {
		assertEquals("Ryan", player.getName());
	}
	
	@Test
	void testSetName() {
		player.setName("Bob");
		assertEquals("Bob", player.getName());
	}
	
	@Test
	void testGetHp() {
		assertEquals(100, player.getHp());
	}
	
	@Test
	void testSetHp() {
		player.setHp(97);
		assertEquals(97, player.getHp());
	}
	
	@Test
	void testGetStrength() {
		assertEquals(20, player.getStrength());
	}
	
	@Test
	void testSetStrength() {
		player.setStrength(97);
		assertEquals(97, player.getStrength());
	}
	
	@Test
	void testGetDefense() {
		assertEquals(20, player.getDefense());
	}
	
	@Test
	void testSetDefense() {
		player.setDefense(97);
		assertEquals(97, player.getDefense());
	}
	
	@Test
	void testGetBrains() {
		assertEquals(20, player.getBrains());
	}
	
	@Test
	void testSetBrains() {
		player.setBrains(97);
		assertEquals(97, player.getBrains());
	}
	
	@Test
	void testGetXp() {
		assertEquals(0, player.getXp());
	}
	
	@Test
	void testSetXp() {
		player.setXp(97);
		assertEquals(97, player.getXp());
	}
	
	@Test
	void testGetMaxHP() {
		assertEquals(100, player.getMaxHP());
	}
	
	@Test
	void testSetMaxHP() {
		player.setMaxHP(97);
		assertEquals(97, player.getMaxHP());
	}
	
	@Test
	void testToString() {
		assertEquals("name: Ryan HP: 100.0", player.toString());
	}
	
	/**
	 * tests to make sure simple attack works for an entity
	 */
	@Test
	void testSimpleAttack() {
		WeaponFactoryMethod weaponFactory = new WeaponFactoryMethod();
		IWeapon sword =weaponFactory.createWeapon(WeaponType.SWORD, "Sample sword weapon", 2, 3, 1);
		player.setWeaponStrategy(sword);
		//Tests using sword weapon
		assertEquals(3,player.simpleAttack(enemy, 100)); //sucessfully hit
		assertEquals(0, player.simpleAttack(enemy, -100)); //miss
		
		
		//test using magic weapon
		player.setWeaponStrategy(weaponFactory.createWeapon(WeaponType.MAGIC, "Sample magic weapon", 4, 5, 1));
		assertEquals(5, player.simpleAttack(enemy, 100)); //success
		assertEquals(0, player.simpleAttack(enemy, -100));//failure
	}
	
	/**
	 * Tests to make sure special attack works for an entity
	 */
	@Test
	void testSpecialAttack() {
		WeaponFactoryMethod weaponFactory = new WeaponFactoryMethod();
		IWeapon sword =weaponFactory.createWeapon(WeaponType.SWORD, "Sample sword weapon", 2, 3, 1);
		player.setWeaponStrategy(sword);
		//Tests using sword weapon
		assertEquals(4,player.specialAttack(enemy, 100)); //sucessfully hit
		assertEquals(0, player.specialAttack(enemy, -100)); //miss
		
		
		//test using magic weapon
		player.setWeaponStrategy(weaponFactory.createWeapon(WeaponType.MAGIC, "Sample magic weapon", 4, 5, 1));
		assertEquals(6, player.specialAttack(enemy, 100)); //success
		assertEquals(0, player.specialAttack(enemy, -100));//failure
		
	}
}
