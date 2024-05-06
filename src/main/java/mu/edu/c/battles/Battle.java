package mu.edu.c.battles;

import java.util.ArrayList;
import java.util.Random;

import mu.edu.c.entities.Enemy;
import mu.edu.c.entities.Player;
import mu.edu.c.logger.EnemyLoggerSingleton;
import mu.edu.c.weapons.MagicWeapon;
import mu.edu.c.weapons.SwordWeapon;
/**
 * This class represents a battle 
 */
public class Battle {
	//The player in combat
	private Player player;
	
	//all of the enemies in possible in combat
	//private ArrayList<Enemy> PossibleEnemies;
	
	private Enemy CurrentEnemy;
	
	/**
	 * Constructor for building a battle based on pre-existing
	 * player and enemy. This constructor is meant for reading in pre-existing
	 * battles 
	 * @param player
	 * @param enemy
	 */
	public Battle(Player player, Enemy enemy) {
		this.player= player;
		this.CurrentEnemy= enemy;
	}
	/**
	 * Constructor for only building a battle based on a player
	 * This constructor is meant to only be used when initializing a NEW battle
	 * not for reading in an existing battle
	 * @param player the player to set as the player for combat
	 */
	public Battle(Player player) {
		this.player = player;
		setCurrentEnemy();
		
	}
	
	/**
	 * Gets the player in combat
	 * @return
	 */
	public Player getPlayer() {
		return this.player;

	}
	
	/**
	 * Rolls a number between 1 and 20
	 * @return a number between 1 and 20
	 */
	public int roll() {
		Random rand = new Random();
		return rand.nextInt(20-1)+1;
	}
	
	/**
	 * Does all the initialization for battle (for enemies)
	 * @return
	 */
	public boolean initializeEnemies() {
		//sets the current enemy
		boolean CurrentEnemyFlag = setCurrentEnemy();
		if(CurrentEnemyFlag == false) { //setting the current enemy failed.
			return false;
		}
		
		return true;
	}

	/**
	 * enemy tries to attack the player
	 * @return the damage dealt by the enemy
	 */
	public float enemyAttack() {
		Random rand = new Random();
		if(rand.nextInt(2) ==0) {
			//current enemy attacks the player with simple attack
			return this.CurrentEnemy.simpleAttack(this.player, this.roll());
		}else { //current enemy attacks the player with special attack
			return this.CurrentEnemy.specialAttack(this.player, this.roll());
		}
	}
	
	/**
	 * Performs simple attack on enemy
	 * 
	 * @param roll
	 * @param enemy
	 * @return
	 */
	public float characterSimpleAttack(int roll, Enemy enemy) {
		return this.player.simpleAttack(enemy, roll);
		
		
	}
	
	/**
	 * Performs special attack on enemy
	 * 
	 * @param roll
	 * @param enemy
	 * @return
	 */
	public float characterSpecialAttack(int roll, Enemy enemy) {
		return this.player.specialAttack(enemy, roll);
	}
	
	/**
	 * Sets all possible enemies that can occur in battle from reading in from the file.
	 * protected for testing purposes
	 * @return an array list of the read in enemies
	 */
	protected ArrayList<Enemy> createPossibleEnemies() {
		ArrayList<Enemy> enemies = EnemyLoggerSingleton.getInstance().readAllEnemyData();
		if(enemies == null) { //reading failed
			return null;
		}
		
		//setPossibleEnemies(enemies);
		return enemies;
	}
	
	////////////////////////////////////////////////
	//Setters and Getters
	/////////////////////////////////////////////////
	

	/**
	 * gets the current enemy of the battle
	 * @return the current enemy
	 */
	public Enemy getCurrentEnemy() {
		return this.CurrentEnemy;

	}

	/**
	 * sets the current Enemy to a random available enemy
	 * @param currentEnemy
	 */
	public boolean setCurrentEnemy() {
		Random rand = new Random();
		
		//Gets all the current available enemies
		ArrayList<Enemy> PossibleEnemies = createPossibleEnemies();
	
		
		//No enemies to choose from, so set to a placeholder enemy
		//This code should be unreachable since enemies will be generated in createPossibleEnemies
		//if the file is null
		//indicates a failure 
		if(PossibleEnemies.isEmpty()) {
			this.CurrentEnemy=new Enemy(1, 1, 1, 1, "PlaceHolder enemy");
			return false;
		}
		//Generates a random number using rand(max-min) +min formula
		int max = PossibleEnemies.size()-1;
		System.out.println(max);
		int min = 0;
		int index =rand.nextInt(max-min)+min;
		
		//gets a random enemy
		this.CurrentEnemy=PossibleEnemies.get(index);
		if (rand.nextInt(2)==0){
			this.CurrentEnemy.setWeaponStrategy(new SwordWeapon("Sword"));
		}
		else{
			this.CurrentEnemy.setWeaponStrategy(new MagicWeapon("Wand"));
		}
		
		return true;
	} 
	
	/**
	 * sets the current enemy based on a passed enemy	
	 * @param enemy what to set the current enemy to	
	 * @return null if current enemy has been set to null (failure), the current enemy if successfull
	 */
	public Enemy setCurrentEnemy(Enemy enemy) {
		this.CurrentEnemy = enemy;
		return this.CurrentEnemy;
	}
	
	/**
	 * Gets the current enemie's name
	 * @return name of current enemy
	 */
	public String getCurrentEnemyName() {
		return this.CurrentEnemy.getName();
	}
	
	/**
	 * Gets the current enemies max HP	
	 * @return max HP of current enemy
	 */
	public float getCurrentEnemyMaxHP() {
		return this.CurrentEnemy.getMaxHP();
	}
	
	
	/**
	 * gets the current Enemy's current Hp
	 * @return Enemy's current hp
	 */
	public float getCurrentEnemyCurrentHP() {
		return this.CurrentEnemy.getHp();
	}

	/**
	 * Sets the current enemy's current hp 
	 * @param newValue the value to set the current enemy's hp
	 * @return the new hp value
	 */
	public float setCurrentEnemyCurrentHP(float newValue) {
		this.CurrentEnemy.setHp(newValue);
		return getCurrentEnemyCurrentHP();
		
	}
	
	/**
	 * Gets the name of the player in combat
	 * @return
	 */
	public String getPlayerName() {
		return player.getName();
	}
	
	/**
	 * Gets the max HP of the player in combat
	 * @return
	 */
	public float getPlayerMaxHP() {
		return player.getMaxHP();
	}
	
	/**
	 * Gets the HP of the player in combat
	 * @return
	 */
	public float getPlayerHP() {
		return player.getHp();
	}
	
	@Override
	public String toString() {
		return this.getPlayerName() + " vs " + this.getCurrentEnemyName();
	}
	
	public boolean equals(Battle battle2) {
		if(this.getCurrentEnemy().equals(battle2.getCurrentEnemy()) &&
				this.getPlayer().equals(battle2.getPlayer())) {
			return true;
		}
		return false;
	}
	
}
