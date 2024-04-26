package mu.edu.c.weapons;

import mu.edu.c.entities.Entity;

public interface IWeapon {
	
	/**
	 * Simple attack where attacker inflicts damage on target utilizing current weapon
	 * @param attacker
	 * @param target
	 */
	void simpleAttack(Entity attacker, Entity target);
	
	/**
	 * Special attack where attacker inflicts damage on target utilizing current weapon
	 * @param attacker
	 * @param target
	 */
	void specialAttack(Entity attacker, Entity target);
}
