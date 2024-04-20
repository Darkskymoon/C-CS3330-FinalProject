package mu.edu.c.entities;

import java.util.ArrayList;

public class Enemy extends Entity{
	
	//array to hold adjectives that describes an enemy
	ArrayList<String> descriptors;

	public Enemy(float maxHP, int Strength, int defense, int brains) {
		
		super(maxHP, Strength, defense, brains);
		descriptors.add("evil");
		descriptors.add("devious");
		descriptors.add("plotting");
		
	}
	
	
	
	

}
