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

	public void setName(String name) {
		this.name = name;
	}

	public int getSimpleDamage() {
		return simpleDamage;
	}

	public void setSimpleDamage(int simpleDamage) {
		this.simpleDamage = simpleDamage;
	}

	public int getSpecialDamage() {
		return specialDamage;
	}

	public void setSpecialDamage(int specialDamage) {
		this.specialDamage = specialDamage;
	}

	public float getScaler() {
		return scaler;
	}

	public void setScaler(float scaler) {
		this.scaler = scaler;
	}
	
	
}
