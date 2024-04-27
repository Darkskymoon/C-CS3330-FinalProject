package mu.edu.c.weapons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractWeaponTest {

	private AbstractWeapon weapon;
	
	@BeforeEach
	void setUp() throws Exception {
		weapon = new SwordWeapon("Excalibur", 10, 20, 2);
	}
	
	@Test
	void testGetName() {
		assertEquals("Excalibur", weapon.getName());
	}
	
	@Test
	void testSetName() {
		weapon.setName("Wand");
		assertEquals("Wand", weapon.getName());
	}
	
	@Test
	void testGetSimpleDamage() {
		assertEquals(10, weapon.getSimpleDamage());
	}
	
	@Test
	void testSetSimpleDamage() {
		weapon.setSimpleDamage(5);
		assertEquals(5, weapon.getSimpleDamage());
	}
	
	@Test
	void testGetSpecialDamage() {
		assertEquals(20, weapon.getSpecialDamage());
	}
	
	@Test
	void testSetSpecialDamage() {
		weapon.setSpecialDamage(30);
		assertEquals(30, weapon.getSpecialDamage());
	}
	
	@Test
	void testGetScaler() {
		assertEquals(2, weapon.getScaler());
	}
	
	@Test
	void testSetScaler() {
		weapon.setScaler(3);
		assertEquals(3, weapon.getScaler());
	}
	
	
}
