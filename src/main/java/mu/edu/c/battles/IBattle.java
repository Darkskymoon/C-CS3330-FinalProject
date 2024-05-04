package mu.edu.c.battles;

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
