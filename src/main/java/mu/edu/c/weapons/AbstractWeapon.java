package mu.edu.c.weapons;

public abstract class AbstractWeapon implements IWeapon {
	private String name;
	private int simpleDamage;
	private int specialDamage;
	private float scaler;
	protected WeaponType weapontype;
	
	public AbstractWeapon(String name, int simpleDamage, int specialDamage, float scaler) {
		super();
		this.name = name;
		this.simpleDamage = simpleDamage;
		this.specialDamage = specialDamage;
		this.scaler = scaler;
	}

	public String getName() {
		return name;
	}

	public String setName(String name) {
		this.name = name;
		return this.name;
	}

	public int getSimpleDamage() {
		return simpleDamage;
	}

	public int setSimpleDamage(int simpleDamage) {
		this.simpleDamage = simpleDamage;
		return this.simpleDamage;
	}

	public int getSpecialDamage() {
		return specialDamage;
	}

	public int setSpecialDamage(int specialDamage) {
		this.specialDamage = specialDamage;
		return this.specialDamage;
	}

	public float getScaler() {
		return scaler;
	}

	public float setScaler(float scaler) {
		this.scaler = scaler;
		return this.scaler;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name: "+getName() +", Simple DMG: "+ getSimpleDamage() + ", Special DMG: "+ getSpecialDamage() + ", Scaler: "+ getScaler();
	}
	
	
	
	
}
