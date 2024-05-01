package mu.edu.c.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mu.edu.c.weapons.IWeapon;
import mu.edu.c.weapons.WeaponFactoryMethod;
import mu.edu.c.weapons.WeaponType;

class EnemyTest {
	
	private Enemy enemy1 = null;
	private Enemy enemy2 =null;
	private Enemy enemy3= null;
	private Enemy enemy4= null;
	private Enemy enemy5 =null;
	
	// This method will be invoked for each test method
	@BeforeEach
	void setUp() throws Exception {
		enemy1 = new Enemy(100, 20, 20, 20, "Goblin");
		
		WeaponFactoryMethod weaponFactory = new WeaponFactoryMethod();
		IWeapon weapon = weaponFactory.createWeapon(WeaponType.MAGIC, "Magic Fairy wand", 1, 2, 1);
		ArrayList<String> descriptors = new ArrayList<>();
		descriptors.add("Most Devious");
		
		ArrayList<String> descriptors2 = new ArrayList<>();
		descriptors.add("EVILEST");
		IWeapon weapon2 = weaponFactory.createWeapon(WeaponType.SWORD, "Excalibur", 2, 4, 2);
		
		enemy2 = new Enemy(100, 20, 20, 20, "Goblin", descriptors);
		enemy3 = new Enemy(100, 20, 20, 20, "Goblin", weapon);
		enemy4 = new Enemy(100, 20, 20, 20, "Goblin", descriptors,weapon);
		enemy5 = new Enemy(96, 25, 25, 25, "Gremlin", descriptors2, weapon2 );
	}
	
	@Test
	void testAddDescriptors() {
		assertEquals(false, enemy2.addDescriptors(null));
		
		assertEquals(true, enemy2.addDescriptors("Most Most devious"));
	}
	
	@Test
	void testGetDescriptors() {
		ArrayList<String> descriptors = enemy3.getDescriptors();
		assertEquals("evil", descriptors.get(0));
		assertEquals("devious", descriptors.get(1));
		assertEquals("plotting", descriptors.get(2));
		
	}
	
	@Test
	void testSetDescriptors() {
		ArrayList<String> newDescriptors = new ArrayList<>();
		newDescriptors.add("devious");
		newDescriptors.add("most devious");
		ArrayList<String> temp =enemy3.setDescriptors(newDescriptors);
		assertEquals("devious", temp.get(0));
		assertEquals("most devious", temp.get(1));
		
	}
	
	@Test
	void testCopyConstructor() {
		Enemy newEnemy = new Enemy(enemy2);
		assertEquals(true, newEnemy.equals(enemy2));
	}
	
	@Test
	void testEquals() {
		assertEquals(false, enemy2.equals(enemy1));
		
		assertEquals(true, enemy1.equals(enemy1));
		
		assertEquals(false, enemy1.equals(enemy5));
		
		enemy5.setBrains(20);
		assertEquals(false, enemy1.equals(enemy5));
		
		enemy5.setDefense(20);
		assertEquals(false, enemy1.equals(enemy5));
		
		Enemy newEnemy = new Enemy(enemy1);
		newEnemy.setStrength(25);
		assertEquals(false, enemy1.equals(newEnemy));
		
		ArrayList<String> descriptors = new ArrayList<>();
		descriptors.add("Most Devious");
		Enemy newEnemy2 = new Enemy(100, 20, 20, 20, "Gobli", descriptors);
		assertEquals(false, enemy1.equals(newEnemy2));
		
		newEnemy.setStrength(20);
		newEnemy.setXp(20);
		assertEquals(false, enemy1.equals(newEnemy));
		
		newEnemy.setXp(0);
		newEnemy.setDescriptors(descriptors);
		assertEquals(false, enemy1.equals(newEnemy));
		
	}

}
