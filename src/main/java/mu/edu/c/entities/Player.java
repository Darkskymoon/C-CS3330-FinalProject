package mu.edu.c.entities;

public class Player extends Entity {
	
	private int attributePoints;

	public Player(float maxHP, int Strength, int defense, int brains, String Name) {
		super(maxHP, Strength, defense, brains, Name);
		setAttributePoints(0);
	}

	public int getAttributePoints() {
		return attributePoints;
	}

	public void setAttributePoints(int attributePoints) {
		this.attributePoints = attributePoints;
	}
	
	

}