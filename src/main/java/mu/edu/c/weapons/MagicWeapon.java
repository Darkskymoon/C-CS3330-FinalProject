package mu.edu.c.weapons;

import mu.edu.c.entities.Entity;

public class MagicWeapon extends AbstractWeapon {
	
	public MagicWeapon(String name, int simpleDamage, int specialDamage, float scaler) {
		super(name, simpleDamage, specialDamage, scaler);
		this.weapontype = WeaponType.MAGIC;
	}

	@Override
	public void simpleAttack(Entity attacker, Entity target) {
		float damage = getScaler() * attacker.calculateStrengthModifier() + getSimpleDamage();
		target.damageRecieved(damage);
	}

	@Override
	public void specialAttack(Entity attacker, Entity target) {
		float damage = getScaler() * attacker.calculateStrengthModifier() + getSpecialDamage();
		target.damageRecieved(damage);
	}
	
}
