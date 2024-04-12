package mu.edu.c.entities;

public abstract class Entity {
	protected String name;
	
	//entity stats
	protected float hp;
	protected int strength;
	protected int defense; 
	protected int brains;
	
	//TODO add weapon 
	
	protected int xp;
	
	//TODO
	public int calculateTotalDamage() {
		return 0;
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
	
	
	
	
	

}
