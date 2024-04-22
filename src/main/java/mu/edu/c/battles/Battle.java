package mu.edu.c.battles;

import java.util.ArrayList;

import mu.edu.c.entities.Enemy;
import mu.edu.c.entities.Player;
/**
 * This class represents a battle 
 */
public class Battle {
	//The player in combat
	private Player player;
	
	//all of the enemies in possible in combat
	private ArrayList<Enemy> PossibleEnemies;
	
	public Battle(Player player) {
		this.player = player;
		//TODO this should read in all saved enemies
		this.PossibleEnemies =new ArrayList<>();
		
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

}
