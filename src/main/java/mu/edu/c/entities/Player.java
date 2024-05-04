package mu.edu.c.entities;

import mu.edu.c.weapons.IWeapon;

public class Player extends Entity {
	
	private int attributePoints;


	/**
	 * Constructor the player class that includes initializing a weapon
	 * @param maxHP
	 * @param strength
	 * @param defense
	 * @param brains
	 * @param Name
	 * @param strategy
	 */
	public Player(float maxHP, int strength, int defense, int brains, String Name, IWeapon strategy) {
		super(maxHP, strength, defense, brains, Name, strategy);
		setAttributePoints(0);
	}
	
	/**
	 * constructs a player with a default weapon (no weapon pass required)
	 * @param maxHP
	 * @param strength
	 * @param defense
	 * @param brains
	 * @param Name
	 */
	public Player(float maxHP, int strength, int defense, int brains, String Name){
		super(maxHP, strength, defense, brains, Name);
		setAttributePoints(0);
	}

	public int getAttributePoints() {
		return attributePoints;
	}

	public void setAttributePoints(int attributePoints) {
		this.attributePoints = attributePoints;
	}
	
	/**
	 * Tests to see if two players are equal
	 * @param player the player to test equality
	 * @return true if equal, false if not equal
	 */
	public boolean equals(Player player) {
		if(player.brains == this.brains &&
				player.getAttributePoints() == this.attributePoints &&
				player.getDefense() == this.defense &&
				player.getHp() == this.getHp() &&
				player.getMaxHP() == this.getMaxHP() &&
				player.getName().equals(this.name) &&
				player.getStrength() ==this.strength &&
				player.weaponStrategy.equals(this.weaponStrategy) &&
				player.xp == this.xp) {
			return true;
			
		}
		return false;
	}
	
	
	

}
