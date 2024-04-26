package mu.edu.c.battles;

import java.util.ArrayList;
import java.util.Random;

import mu.edu.c.entities.Enemy;
import mu.edu.c.entities.Player;
import mu.edu.c.logger.EnemyLoggerSingleton;
/**
 * This class represents a battle 
 */
public class Battle {
	//The player in combat
	private Player player;
	
	//all of the enemies in possible in combat
	private ArrayList<Enemy> PossibleEnemies;
	
	private Enemy CurrentEnemy;
	
	public Battle(Player player) {
		this.player = player;
		System.out.println(player);
		//TODO this should read in all saved enemies
		this.setPossibleEnemies(new ArrayList<>());
		
	}
	
	/**
	 * Gets the name of the player in combat
	 * @return
	 */
	public String getPlayerName() {
		return player.getName();
	}
	public float getPlayerMaxHP() {
		return player.getMaxHP();
	}
	public float getPlayerHP() {
		return player.getHp();
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
		//set all possible enemies
		setPossibleEnemies();
		
		//sets the current enemy
		boolean CurrentEnemyFlag = setCurrentEnemy();
		if(CurrentEnemyFlag == false) { //setting the current enemy failed.
			return false;
		}
		
		
		
		
		return true;
	}
	
	////////////////////////////////////////////////
	//Setters and Getters
	/////////////////////////////////////////////////
	
	/**
	 * Gets all possible enemies that could have occurred in the battle
	 * @return arraylist of all enemies
	 */
	public ArrayList<Enemy> getPossibleEnemies() {
		return PossibleEnemies;
	}

	/**
	 * sets all possible enemies that can occur in the battle
	 * @param possibleEnemies the enemies that can occur in the battle
	 */
	public void setPossibleEnemies(ArrayList<Enemy> possibleEnemies) {
		PossibleEnemies = possibleEnemies;
	}
	
	/**
	 * Sets all possible enemies that can occur in battle from reading in from the file.
	 */
	public boolean setPossibleEnemies() {
		ArrayList<Enemy> enemies = EnemyLoggerSingleton.getInstance().readAllEnemyData();
		if(enemies == null) { //reading failed
			return false;
		}
		
		setPossibleEnemies(enemies);
		return true;
	}
	

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
		
		//This should never happen but, in case it does,
		//This re-reads in all possible enemies, which if it is empty, will be populated with some
		//sample monsters
		if(PossibleEnemies.isEmpty()) {
			boolean setPossibleFlag =setPossibleEnemies();
			if(setPossibleFlag ==false) { //reading failed
				return false;
			}
		}
		//Generates a random number using rand(max-min) +min formula
		int max = this.PossibleEnemies.size()-1;
		int min = 0;
		int index =rand.nextInt(max-min)+min;
		
		//gets a random enemy
		this.CurrentEnemy=this.PossibleEnemies.get(index);
		
		return true;
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
	 */
	public void setCurrentEnemyCurrentHP(float newValue) {
		this.CurrentEnemy.setHp(newValue);
		
	}
	
	
}
