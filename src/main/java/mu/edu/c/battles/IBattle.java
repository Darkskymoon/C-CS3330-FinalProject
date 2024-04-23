package mu.edu.c.battles;

import java.util.ArrayList;

import mu.edu.c.entities.Enemy;
import mu.edu.c.entities.Player;

public interface IBattle {
	
	/**
	 * Gets the name of the player in combat
	 * @return
	 */
	public String getPlayerName();
	
	
	public float getPlayerMaxHP();
	public float getPlayerHP();
	
	public boolean Attack();

}
