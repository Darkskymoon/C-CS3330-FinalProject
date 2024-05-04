package mu.edu.c.weapons;
import java.util.Random;

import mu.edu.c.entities.Enemy;
import mu.edu.c.entities.Player;

public abstract class AbstractWeapon implements IWeapon {
	private String name;
	private int simpleDamage;
	private int specialDamage;
	private float scaler;
	protected WeaponType weapontype;
	
	public AbstractWeapon(String name, int simpleDamage, int specialDamage, float scaler) {
		super();
		this.name = name;
		this.simpleDamage = simpleDamage;
		this.specialDamage = specialDamage;
		this.scaler = scaler;
	}

	public AbstractWeapon(String name) {
		super();
		Random rand = new Random();
		this.name = name;
		this.simpleDamage = rand.nextInt(1, 5);
		this.specialDamage = simpleDamage + rand.nextInt(4);
		this.scaler = 1;
		
		String namePrefix;
		int key = this.getSimpleDamage();
		switch (key) {
			case 1: {
				namePrefix = "Rusty";
				break;
			}
			case 2: {
				namePrefix = "Basic";
				break;
			}
			case 3: {
				namePrefix = "Superior";
				break;
			}
			case 4: {
				namePrefix = "Lethal";
				break;
			}
			default:{
				namePrefix = "Unknown";
			}
		}
		
		String nameSuffix;
		key = this.getSpecialDamage()-this.getSimpleDamage();
		switch (key) {
			case 0: {
				nameSuffix = "of Wasted Potential";
				break;
			}
			case 3: {
				nameSuffix = "of Unleashed Potential";
				break;
			}
			default:{
				nameSuffix = "";
			}
		}
		this.setName(namePrefix + " " + name + " "+ nameSuffix);
	}

	public String getName() {
		return name;
	}

	public String setName(String name) {
		this.name = name;
		return this.name;
	}

	public int getSimpleDamage() {
		return simpleDamage;
	}

	public int setSimpleDamage(int simpleDamage) {
		this.simpleDamage = simpleDamage;
		return this.simpleDamage;
	}

	public int getSpecialDamage() {
		return specialDamage;
	}

	public int setSpecialDamage(int specialDamage) {
		this.specialDamage = specialDamage;
		return this.specialDamage;
	}

	public float getScaler() {
		return scaler;
	}

	public float setScaler(float scaler) {
		this.scaler = scaler;
		return this.scaler;
	}
	
	/**
	 * Calculates if a entity hits or misses their target	
	 * @param roll the result from a roll prior to making the attack
	 * @param modifier the strength/brains modifier to hit
	 * @param opponentDefense the target's defense value
	 * @return true if it is a hit, or false if it is not a hit
	 */
	public boolean calculateHitOrMiss(int roll, int modifier, int opponentDefense) {
		int totalRoll = roll +modifier;
		if(totalRoll <0) { //below 0 will never hit
			return false; 
		}
		if(totalRoll<opponentDefense) {//If roll is below the opposing side,then the attack most likely won't hit
			Random rand = new Random();
			if(rand.nextInt(2) ==0) { //gives a 50% chance to hit regardless of missing
				return true;
			}
			return false; //attack misses
		}
		return true;
		
	}
	
	/**
	 * Tests to see if two weapons are equal
	 * @return
	 */
	public boolean equals(IWeapon weapon) {
		AbstractWeapon weapontemp = (AbstractWeapon) weapon;
		if(this.name.equals(weapontemp.getName()) &&
				this.scaler==weapontemp.getScaler() &&
				this.simpleDamage == weapontemp.getSimpleDamage() &&
				this.specialDamage == weapontemp.getSpecialDamage() &&
				this.weapontype.equals(weapontemp.weapontype)) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name: "+getName() +", Simple DMG: "+ getSimpleDamage() + ", Special DMG: "+ getSpecialDamage() + ", Scaler: "+ getScaler();
	}
	
	
	
}
