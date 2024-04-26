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
	
	
	

}
