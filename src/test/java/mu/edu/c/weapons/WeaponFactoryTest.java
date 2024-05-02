package mu.edu.c.weapons;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeaponFactoryTest {
	WeaponFactoryMethod weaponFactory =null;
	
	@BeforeEach
	void setUp() {
		weaponFactory = new WeaponFactoryMethod();
	}

	
	@Test
	public void testCreateWeapon() {
		assertEquals(MagicWeapon.class,weaponFactory.createWeapon(WeaponType.MAGIC, "Scepter", 1, 2, 3).getClass());
		assertEquals(SwordWeapon.class,weaponFactory.createWeapon(WeaponType.SWORD, "blade", 2, 3, 4).getClass());
		assertEquals(null, weaponFactory.createWeapon(null, "temp", 0, 0, 0));
	}
	
	@Test
	public void testParseCharacterWeapon() {
		weaponFactory.parseCharacterWeapon(null);
		//wrongly formatted json
		JSONObject weapon = new JSONObject("{'name':'Basic Sword','simpleDamage':1,'specialDamage':2,'scaler':1.0,'weapontype':'SWORD'}");
		assertEquals(null, weaponFactory.parseCharacterWeapon(weapon));
		
		//correctly formatted json
		JSONObject weapon2 = new JSONObject("{'weaponStrategy':{'name':'Basic Sword','simpleDamage':1,'specialDamage':2,'scaler':1.0,'weapontype':'SWORD'}}");
		//todo
		IWeapon weapon3 = weaponFactory.parseCharacterWeapon(weapon2);
//		assertEquals("Basic Sword", );
		
	}

}
