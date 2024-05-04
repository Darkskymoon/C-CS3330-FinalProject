package mu.edu.c.weapons;

import mu.edu.c.entities.Entity;

public class MagicWeapon extends AbstractWeapon {
	
	public MagicWeapon(String name, int simpleDamage, int specialDamage, float scaler) {
		super(name, simpleDamage, specialDamage, scaler);
		this.weapontype = WeaponType.MAGIC;
	}
	
	public MagicWeapon(String name) {
		super(name);
		this.weapontype = WeaponType.MAGIC;
	}

	@Override
	public float simpleAttack(Entity attacker, Entity target, int roll) {
		float damage = (getScaler() * attacker.calculateBrainsModifier())+1 + getSimpleDamage();
		target.damageRecieved(damage);
		return damage;
	}

	@Override
	public float specialAttack(Entity attacker, Entity target, int roll) {
		float damage = (getScaler() * attacker.calculateBrainsModifier())+1 + getSpecialDamage();
		target.damageRecieved(damage);
		return damage;
	}
	
}
