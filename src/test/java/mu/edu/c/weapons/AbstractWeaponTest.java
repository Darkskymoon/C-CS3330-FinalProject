package mu.edu.c.weapons;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.opentest4j.AssertionFailedError;

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
	
	@Test
	void testIncorrectEqual() {
		assertFalse(weapon.equals(new SwordWeapon("Diffrent weapon", 10, 20, 2)));
	}
	
	
	@ParameterizedTest
	@MethodSource("provideRandomWeapons")
	void testRandomWeaponPrefixes(AbstractWeapon randWeapon) {
		int simpleDamage = randWeapon.getSimpleDamage();
		if (simpleDamage == 1) {
			assertTrue(randWeapon.getName().contains("Rusty"));
		}
		else if (simpleDamage == 2) {
			assertTrue(randWeapon.getName().contains("Basic"));
		}
		else if (simpleDamage == 3) {
			assertTrue(randWeapon.getName().contains("Superior"));
		}
		else if (simpleDamage == 4) {
			assertTrue(randWeapon.getName().contains("Lethal"));
		}
		else {
			fail("simple damage was not a correct number: " + simpleDamage);
		}
	}
	
	@ParameterizedTest
	@MethodSource("provideRandomWeapons")
	void testRandomWeaponSuffixes(AbstractWeapon randWeapon, String basicName) {
		int specialDamageBonus = randWeapon.getSpecialDamage() - randWeapon.getSimpleDamage();
		if (specialDamageBonus == 0) {
			assertTrue(randWeapon.getName().contains("of Wasted Potential"));
		}
		else if (specialDamageBonus == 3) {
			assertTrue(randWeapon.getName().contains("of Unleashed Potential"));
		}
		else {
			assertTrue(randWeapon.getName().endsWith(basicName));
		}
	}
	
	
	public static Stream<Object[]> provideRandomWeapons() {
		return Stream.of(
			new Object[]{new SwordWeapon("Sword1"), "Sword1"},
			new Object[]{new SwordWeapon("Sword2"), "Sword2"},
			new Object[]{new SwordWeapon("Sword3"), "Sword3"},
			new Object[]{new SwordWeapon("Sword4"), "Sword4"},
			new Object[]{new SwordWeapon("Sword5"), "Sword5"},
			new Object[]{new MagicWeapon("Wand1"), "Wand1"},
			new Object[]{new MagicWeapon("Wand2"), "Wand2"},
			new Object[]{new MagicWeapon("Wand3"), "Wand3"},
			new Object[]{new MagicWeapon("Wand4"), "Wand4"},
			new Object[]{new MagicWeapon("Wand5"), "Wand5"}
		);
	}
}
