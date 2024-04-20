package mu.edu.c.entities;

public class Character extends Entity {
	
	private int attributePoints;

	public Character(float maxHP, int Strength, int defense, int brains) {
		super(maxHP, Strength, defense, brains);
		setAttributePoints(0);
	}

	public int getAttributePoints() {
		return attributePoints;
	}

	public void setAttributePoints(int attributePoints) {
		this.attributePoints = attributePoints;
	}
	
	

}
