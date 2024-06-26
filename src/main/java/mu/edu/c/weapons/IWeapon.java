package mu.edu.c.weapons;

import mu.edu.c.entities.Entity;

public interface IWeapon {
	
	/**
	 * Simple attack where attacker inflicts damage on target utilizing current weapon
	 * @param attacker the entity inflicting the attack
	 * @param target who the attacker is attacking
	 * @return total damage dealt
	 */
	float simpleAttack(Entity attacker, Entity target, int roll);
	
	/**
	 * Special attack where attacker inflicts damage on target utilizing current weapon
	 * @param attacker the entity inflicting the attack
	 * @param target who the attacker is attacking
	 * @return total damage dealt
	 */
	float specialAttack(Entity attacker, Entity target, int roll);
	/**
	 * Tests if two weapons are equal
	 * @param weapon the weapon to compare against the current Iweapon
	 * @return true if equal, false if not
	 */
	public boolean equals(IWeapon weapon);
}
