package mu.edu.c.entities;

import java.util.ArrayList;
import java.util.Iterator;

import mu.edu.c.weapons.IWeapon;

public class Enemy extends Entity{
	
	//array to hold adjectives that describes an enemy
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
			AddDescriptors(descriptors.get(i));
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
			AddDescriptors(descriptorIterator.next());
		}
	}
	
	
	
	
	/**
	 * This method adds descriptors to the enemy 
	 * @param adjective
	 * false on failure
	 * true on success
	 */
	public boolean AddDescriptors(String adjective) {
		if(adjective ==null) {
			return false;
		}
		this.descriptors.add(adjective);
		return true;
	}
	

}
