package mu.edu.c.weapons;

import mu.edu.c.entities.Entity;

public class MagicWeapon extends AbstractWeapon {
	
	public MagicWeapon(String name, int simpleDamage, int specialDamage, float scaler) {
		super(name, simpleDamage, specialDamage, scaler);
		this.weapontype = WeaponType.MAGIC;
	}
	
	

	@Override
	public float simpleAttack(Entity attacker, Entity target, int roll) {
		boolean hitOrMiss= calculateHitOrMiss(roll, attacker.calculateBrainsModifier(), target.getDefense());
		if(hitOrMiss ==false) { //attacker missed
			return 0;
		}
		float damage = getScaler() + getSimpleDamage();
		target.damageRecieved(damage);
		return damage;
	}

	@Override
	public float specialAttack(Entity attacker, Entity target, int roll) {
		boolean hitOrMiss= calculateHitOrMiss(roll, attacker.calculateBrainsModifier(), target.getDefense());
		if(hitOrMiss ==false) { //attacker missed
			return 0;
		}
		float damage = getScaler() + getSpecialDamage();
		target.damageRecieved(damage);
		return damage;
	}
	
}
