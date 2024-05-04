package mu.edu.c.entities;

import java.util.ArrayList;

import mu.edu.c.weapons.IWeapon;

/**
 * The entity factory method class is a way of creating enemies and players in one place
 */
public class EntityFactoryMethod {
	/**
	 * Constructor for the entity factory
	 */
	public EntityFactoryMethod() {
		
	}
	
	/**
	 * Constructs an Enemy instance without descriptors
	 * @return instance of enemy
	 */
	public Enemy createEnemy(float maxHP, int strength, int defense, int brains, String name) {
		return new Enemy(maxHP, strength, defense, brains, name);
		
	}
	
	/**
	 * Constructs an Enemy instance that takes descriptors
	 * @return instance of enemy
	 */
	public Enemy createEnemy(float maxHP, int strength, int defense, int brains, String name, ArrayList<String> descriptors) {
		return new Enemy(maxHP, strength, defense, brains, name, descriptors);
		
	}
	/**
	 * Constructs an Enemy instance that takes descriptors and weapon
	 * @return instance of enemy
	 */
	public Enemy createEnemy(float maxHP, int strength, int defense, int brains, String name, ArrayList<String> descriptors, IWeapon weapon) {
		return new Enemy(maxHP, strength, defense, brains, name, descriptors, weapon);
		
	}
	
	/**
	 * Constructs an Enemy instance that takes weapons but no descriptor
	 * @return instance of enemy
	 */
	public Enemy createEnemy(float maxHP, int strength, int defense, int brains, String name, IWeapon weapon) {
		return new Enemy(maxHP, strength, defense, brains, name, weapon);
		
	}
	
	/**
	 * Constructs a player instance w/o specific weapon (gets default weapon)
	 * @return instance of player
	 */
	public Player createPlayer(float maxHP, int strength, int defense, int brains, String Name) {
		return new Player(maxHP, strength, defense, brains, Name);
	}
	
	/**
	 * Constructs a player instance with weapon
	 * @return instance of player
	 */
	public Player createPlayerWithWeapon(float maxHP, int strength, int defense, int brains, String Name, IWeapon strategy) {
		return new Player(maxHP, strength, defense, brains, Name, strategy);
	}

}
