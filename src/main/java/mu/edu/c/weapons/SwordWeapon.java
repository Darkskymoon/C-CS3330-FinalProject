package mu.edu.c.weapons;

import mu.edu.c.entities.Entity;

public class SwordWeapon extends AbstractWeapon implements IWeapon {

	public SwordWeapon(String name, int simpleDamage, int specialDamage, float scaler) {
		super(name, simpleDamage, specialDamage, scaler);
		this.weapontype = WeaponType.SWORD;
	}
	
	

	@Override
	public float simpleAttack(Entity attacker, Entity target, int roll) {
		boolean hitOrMiss= calculateHitOrMiss(roll, attacker.calculateStrengthModifier(), target.getDefense());
		if(hitOrMiss ==false) { //attacker missed
			return 0;
		}
		float damage = getScaler() + getSimpleDamage();
		target.damageRecieved(damage);
		return damage;
	}

	@Override
	public float specialAttack(Entity attacker, Entity target, int roll) {
		//calculates if the attack hit or miss
		boolean hitOrMiss= calculateHitOrMiss(roll, attacker.calculateStrengthModifier(), target.getDefense());
		if(hitOrMiss ==false) { //attacker missed
			return 0;
		}
		//attacker hit
		float damage = getScaler()  + getSpecialDamage();
		target.damageRecieved(damage);
		return damage;
	}

}
