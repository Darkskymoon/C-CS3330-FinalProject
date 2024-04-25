package mu.edu.c.entities;
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
	 * Constructs an Enemy instance
	 * @return instance of enemy
	 */
	public Enemy createEnemy(float maxHP, int strength, int defense, int brains, String name) {
		return new Enemy(maxHP, strength, defense, brains, name);
		
	}
	
	/**
	 * Constructs a player instance
	 * @return instance of player
	 */
	public Player createPlayer(float maxHP, int strength, int defense, int brains, String Name) {
		return new Player(maxHP, strength, defense, brains, Name);
	}

}
