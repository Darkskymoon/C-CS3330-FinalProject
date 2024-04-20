package mu.edu.c.entities;

import java.util.ArrayList;

public class Enemy extends Entity{
	
	//array to hold adjectives that describes an enemy
	ArrayList<String> descriptors;

	public Enemy(float maxHP, int Strength, int defense, int brains, String Name) {
		
		super(maxHP, Strength, defense, brains, Name);
		
		//Adds some basic descriptors
		descriptors = new ArrayList<>();
		descriptors.add("evil");
		descriptors.add("devious");
		descriptors.add("plotting");
		
	}
	
	
	
	/**
	 * This method adds descriptors to the enemy 
	 * @param adjective
	 */
	public void AddDescriptors(String adjective) {
		descriptors.add(adjective);
	}
	

}
