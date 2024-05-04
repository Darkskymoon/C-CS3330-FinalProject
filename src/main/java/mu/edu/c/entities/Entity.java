package mu.edu.c.entities;

import mu.edu.c.weapons.IWeapon;
import mu.edu.c.weapons.SwordWeapon;

public abstract class Entity {
	protected String name;
	
	//entity stats
	protected float hp;
	protected float maxHP;
	protected int strength;
	protected int defense; 
	protected int brains;
	
	//TODO add weapon 
	protected IWeapon weaponStrategy = new SwordWeapon("Excalibur", 10, 20, 2);

	protected int xp;
	
	/**
	 * This constructor constructs a player without a weapon strategy and auto-creates a starter sword
	 * @param maxHP
	 * @param strength
	 * @param defense
	 * @param brains
	 * @param Name
	 */
	public Entity(float maxHP, int strength, int defense, int brains, String Name) {
		
		//call alternate constructor with a starter weapon
		this(maxHP, strength, defense, brains, Name, new SwordWeapon("Sword of Beginnings", 1, 2, 1));
	}
	
	/**
	 * This constructor constructs a player with a weapon strategy
	 * @param maxHP
	 * @param strength
	 * @param defense
	 * @param brains
	 * @param name
	 * @param weaponStrategy
	 */
	public Entity(float maxHP, int strength, int defense, int brains, String name, IWeapon weaponStrategy) {
		//Set basic stats
		this.hp = maxHP;
		this.maxHP = maxHP;
		this.strength = strength;
		this.defense = defense;
		this.brains = brains;
		this.xp = 0;
		
		this.name = name;
		
		//set the weapon strategy
		this.weaponStrategy=weaponStrategy;
		
	}

	
	public int calculateDefenseModifier() {
		return calculateModifierValue(defense);
	}
	
	public int calculateStrengthModifier() {
		return calculateModifierValue(strength);
		
	}
	
	public int calculateBrainsModifier() {
		return calculateModifierValue(brains);
		
	}
	
	/**
	 * This method takes a statistic and will calculate what the modifier for that 
	 * statistic
	 * @param statistic The statistic to calculate the modifier for
	 * @return integer representing the modifier of the statistic passed in
	 */
	private int calculateModifierValue(int statistic) {
			if(statistic>=23) {
				return 10;
			}
			else if(statistic >=20) {
				return 8;
			}
			else if(statistic>=17) {
				return 6;
			}
			else if (statistic>=14) {
				return 4;
			}
			else if (statistic>=11) {
				return 2;
			}
			else if (statistic>=8) {
				return 0;
			}
			else if (statistic>=4) {
				return -2;
			}
			else {
				return -4;
			}
	}
	
	
	/**
	 * TODO: this is a temporary method until the strategy design pattern is implemented
	 * Takes the value of the damage passed in and calculates the negative value 
	 * Then adjusts the entities hp.
	 * @param damageValue value that the entities hp should be adjusted
	 * @return the new hp of the target
	 */
	public float damageRecieved(float damageValue) {
		//gets the absolute value of the damage passed in
		float total = Math.abs(damageValue);
		//gets the negative value of the damage
		total = 0-total;
		return calculateNewHP(total);
	}
	
	/**
	 * Calculates the hp of an entity based on a passed in value
	 * @param valueToAdjustBy value that the HP is adjusted by
	 * @return float representing the new HP of the enemy.
	 */
	public float calculateNewHP(float valueToAdjustBy) {
		//sets the HP to 0 if the hp goes below 0
		if(hp + valueToAdjustBy <0) {
			hp=0;
			return 0;
		}
		//sets the HP to the max hp if it goes above the maxHP
		else if (hp+valueToAdjustBy> maxHP) {
			hp=maxHP;
			return maxHP;
		}
		//default adjustment to HP
		hp += valueToAdjustBy;
		return hp;
	}
	
	/**
	 * Performs simple attack on enemy using weapon
	 * @param enemy what the player is attacking
	 * @param roll value of a roll to see if the player hit
	 * @return value o
	 */
	public float simpleAttack(Entity enemy, int roll) {
		return weaponStrategy.simpleAttack(this, enemy, roll);
	}
	
	/**
	 * Performs special attack on enemy using weapon
	 * @param enemy the enemy that the player is attacking
	 * @param roll value of a roll to see if the player hit
	 */
	public float specialAttack(Entity enemy, int roll) {
		return weaponStrategy.specialAttack(this, enemy, roll);
	}
	
	
	//getters and setters for all the fields
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getHp() {
		return hp;
	}

	public void setHp(float hp) {
		this.hp = hp;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getBrains() {
		return brains;
	}

	public void setBrains(int brains) {
		this.brains = brains;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}
	
	public float getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(float maxHP) {
		this.maxHP = maxHP;
	}
	
	public IWeapon getWeaponStrategy() {
		return weaponStrategy;
	}

	public void setWeaponStrategy(IWeapon weaponStrategy) {
		this.weaponStrategy = weaponStrategy;
	}

	//TODO: Fix the toString
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name: " +name
				+ " HP: " + maxHP;
	}
	
	
	

}
