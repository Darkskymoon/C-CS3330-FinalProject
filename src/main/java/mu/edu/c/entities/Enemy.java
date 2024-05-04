package mu.edu.c.entities;

import java.util.ArrayList;
import java.util.Iterator;

import mu.edu.c.weapons.IWeapon;

public class Enemy extends Entity{
	
	//array to hold adjectives that describes an enemy
	//Note that this feature was something we planned on adding, but ran out of time
	//the ability to add and get all the descriptors is fully implemented, 
	//but not hooked up with the battle feature.
	//we planned on giving enemies a random descriptor in their battle text.
	//It could be easily implemented at a later point. 
	ArrayList<String> descriptors;

	/**
	 * constructor that doesn't take any descriptors but instead applies some default descriptors
	 * @param maxHP
	 * @param Strength
	 * @param defense
	 * @param brains
	 * @param Name
	 */
	public Enemy(float maxHP, int Strength, int defense, int brains, String Name) {
		
		super(maxHP, Strength, defense, brains, Name);
		
		//Adds some basic descriptors
		this.descriptors = new ArrayList<>();
		this.descriptors.add("evil");
		this.descriptors.add("devious");
		this.descriptors.add("plotting");
		
	}
	
	/**
	 * constructor that takes an arraylist of descriptors
	 * @param maxHP
	 * @param Strength
	 * @param defense
	 * @param brains
	 * @param Name
	 * @param descriptors
	 */
	public Enemy(float maxHP, int Strength, int defense, int brains, String Name, ArrayList<String> descriptors) {
		super(maxHP, Strength, defense, brains, Name);
		this.descriptors = new ArrayList<>();
		for(int i =0; i<descriptors.size(); i++) {
			addDescriptors(descriptors.get(i));
		}
	}
	
	/**
	 * constructor that doesn't take descriptors but does take a custom weapon
	 * @param maxHP
	 * @param Strength
	 * @param defense
	 * @param brains
	 * @param Name
	 */
	public Enemy(float maxHP, int Strength, int defense, int brains, String Name, IWeapon weapon) {
		
		super(maxHP, Strength, defense, brains, Name, weapon);
		
		//Adds some basic descriptors
		this.descriptors = new ArrayList<>();
		descriptors.add("evil");
		descriptors.add("devious");
		descriptors.add("plotting");
		
	}
	
	/**
	 * constructor that takes an arraylist of descriptors AND a custom weapon
	 * @param maxHP
	 * @param Strength
	 * @param defense
	 * @param brains
	 * @param Name
	 * @param descriptors
	 */
	public Enemy(float maxHP, int Strength, int defense, int brains, String Name, ArrayList<String> descriptors, IWeapon weapon) {
		super(maxHP, Strength, defense, brains, Name, weapon);
		this.descriptors = new ArrayList<>();
		Iterator<String> descriptorIterator = descriptors.iterator();
		while(descriptorIterator.hasNext()) {
			addDescriptors(descriptorIterator.next());
		}
	}
	
	
	
	
	/**
	 * This method adds descriptors to the enemy 
	 * @param adjective
	 * false on failure
	 * true on success
	 */
	public boolean addDescriptors(String adjective) {
		if(adjective ==null) {
			return false;
		}
		this.descriptors.add(adjective);
		return true;
	}
	
	
	/**
	 * gets a copy of the descriptor array list
	 * @return a copy of the descriptors array list
	 */
	public ArrayList<String> getDescriptors() {
		ArrayList<String> descriptorCopy = new ArrayList<>();
		for(String descriptor : descriptors) {
			descriptorCopy.add(descriptor);
			
		}
		return descriptorCopy;
	}

	/**
	 * copies in all of the descriptiions from the passed in descriptors array to the object's descriptors (resetting the descriptor array)
	 * @param descriptors the descriptor array to set the descriptors of the object to 
	 * @return The object's new descriptor list (copy)
	 */
	public ArrayList<String> setDescriptors(ArrayList<String> descriptors) {
		//Set to new array list
		this.descriptors = new ArrayList<>();
		//copy in the descriptions
		for(String descriptor: descriptors) {
			this.descriptors.add(descriptor);
		}
		
		return getDescriptors();
	}

	/**
	 * Copy constructor for enemy
	 * @param enemy The enemy to make a copy of
	 */
	public Enemy(Enemy enemy) {
		super(enemy.getMaxHP(),enemy.getStrength(),enemy.getDefense(),enemy.getBrains(),enemy.getName(),enemy.getWeaponStrategy());
		
		setDescriptors(enemy.getDescriptors());
		this.xp = enemy.getXp();
	
	}
	
	/**
	 * Tests to see if two enemies are identical from values
	 * @param other the enemy to test if equal to the current enemy
	 * @return true if equal, false if not equal
	 */
	public boolean equals(Enemy other) {
		if(other.brains == this.brains &&
				other.defense ==this.defense &&
				other.maxHP == this.maxHP &&
				other.name.equals(this.name) &&
				other.strength == this.strength &&
				other.weaponStrategy.equals(this.weaponStrategy) &&
				other.xp ==this.xp && 
				other.getDescriptors().equals(this.getDescriptors())
				) {
			
			return true;
			
		}
		else {
			return false;
		}
	}
	

}
