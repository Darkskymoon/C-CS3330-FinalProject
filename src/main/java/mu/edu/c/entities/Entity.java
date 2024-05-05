package mu.edu.c.entities;

import mu.edu.c.weapons.IWeapon;
import mu.edu.c.weapons.SwordWeapon;
import mu.edu.c.weapons.WeaponFactoryMethod;

public abstract class Entity {
	protected String name;
	
	//entity stats
	protected float hp;
	protected float maxHP;
	protected int strength;
	protected int defense; 
	protected int brains;
	
 
	protected IWeapon weaponStrategy = new SwordWeapon("Excalibur", 10, 20, 2);

	protected int xp;
	
	/**
	 * This constructor constructs a entity without a weapon strategy and auto-creates a starter sword
	 * @param maxHP the max hp that a entity can have
	 * @param strength the strength the entity can have
	 * @param defense the defense the entity can have
	 * @param brains the brains the entity can have
	 * @param Name the name of the entity
	 */
	public Entity(float maxHP, int strength, int defense, int brains, String Name) {
		
		//call alternate constructor with a starter weapon
		this(maxHP, strength, defense, brains, Name, new SwordWeapon("Sword of Beginnings", 1, 2, 1));
	}
	
	/**
	 * This constructor constructs a entity with a weapon strategy
	 * @param maxHP the max hp that a entity can have
	 * @param strength the strength the entity can have
	 * @param defense the defense the entity can have
	 * @param brains the brains the entity can have
	 * @param Name the name of the entity
	 * @param weaponStrategy the weapon of the entity
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

	/**
	 * returns the modifier for defense (unused)
	 * @return integer value of modifier
	 */
	public int calculateDefenseModifier() {
		return calculateModifierValue(defense);
	}
	
	/**
	 * returns the strength modifier
	 * @return the integer representing the strength modifier
	 */
	public int calculateStrengthModifier() {
		return calculateModifierValue(strength);
		
	}
	
	/**
	 * retuns the calculated brains modifier
	 * @return integer representing the brains modifier
	 */
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
	 * This is public as to allow healing to occur if that were ever implemented. 
	 * For damage, ideally damage recieved is called first
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
	 * @return damage 
	 */
	public float simpleAttack(Entity enemy, int roll) {
		return weaponStrategy.simpleAttack(this, enemy, roll);
	}
	
	/**
	 * Performs special attack on enemy using weapon
	 * @param enemy the enemy that the player is attacking
	 * @param roll value of a roll to see if the player hit
	 * @return damage
	 */
	public float specialAttack(Entity enemy, int roll) {
		return weaponStrategy.specialAttack(this, enemy, roll);
	}
	
	
	//getters and setters for all the fields
	/**
	 * gets the entity name
	 * @return string name field
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets the name field of the entity
	 * @param name what the new name of the entity should be 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gets the hp of the entity
	 * @return hp value
	 */
	public float getHp() {
		return hp;
	}

	/**
	 * sets the hp of an entity
	 * Ideally for damage, the damageRecieved method should be called instead.
	 * This is useful if for some reason an entities hit points should be set to max or above the 
	 * intended value.
	 * @param hp value hp should be set to. 
	 */
	public void setHp(float hp) {
		this.hp = hp;
	}

	/**
	 * gets the strength of an entity
	 * @return value of the entity's strength
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * sets the strength of an entity
	 * @param strength what to set the strength to
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}

	/**
	 * gets the defense of an entity
	 * @return defense value
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * sets the defense of an entity
	 * @param defense what to set the entity's defense to
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * gets the brains of an entity
	 * @return brains value
	 */
	public int getBrains() {
		return brains;
	}

	/**
	 * sets brains field
	 * @param brains what to set the brains field to
	 */
	public void setBrains(int brains) {
		this.brains = brains;
	}

	/**
	 * gets the integer value of xp
	 * @return integer value of the xp
	 */
	public int getXp() {
		return xp;
	}

	/**
	 * sets the xp
	 * @param xp what to set the xp to
	 */
	public void setXp(int xp) {
		this.xp = xp;
	}
	
	/**
	 * gets the max hp
	 * @return max hp value
	 */
	public float getMaxHP() {
		return maxHP;
	}

	/**
	 * sets the max hp of the entity
	 * @param maxHP what to set the maxhp to
	 */
	public void setMaxHP(float maxHP) {
		this.maxHP = maxHP;
	}
	
	/**
	 * gets the current weapon strategy
	 * @return the weapon strategy used
	 */
	public IWeapon getWeaponStrategy() {
		return weaponStrategy;
	}

	/**
	 * sets the weapon strategy
	 * @param weaponStrategy to set to
	 */
	public void setWeaponStrategy(IWeapon weaponStrategy) {
		this.weaponStrategy = weaponStrategy;
	}

	/**
	 * makes a to string for the entity that lists the name and max hp
	 */
	@Override
	public String toString() {
		return "name: " + name
				+ " HP: " + maxHP;
	}
	
	
	

}
