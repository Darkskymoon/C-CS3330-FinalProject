package mu.edu.c.weapons;

import mu.edu.c.entities.Entity;

public interface IWeapon {
	
	void simpleAttack(Entity attacker, Entity target);
	void specialAttack(Entity attacker, Entity target);
}
