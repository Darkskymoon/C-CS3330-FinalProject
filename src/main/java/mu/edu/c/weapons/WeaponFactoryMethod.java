package mu.edu.c.weapons;

import org.json.JSONException;
import org.json.JSONObject;

public class WeaponFactoryMethod {
	/**
	 * Constructor for the weapon factory
	 */
	public WeaponFactoryMethod() {
		
	}
	
	/**
	 * Creates a weapon based on pre-existing values
	 * @param weaponType The type of weapon that should be created
	 * @param weaponName The name of the weapon
	 * @param simpleDmg The simple damage amount of a weapon
	 * @param specialDamage The special damage amount of a weapon
	 * @param scaler TODO: What is scaler
	 * @return The newly created weapon or null on failure
	 */
	public IWeapon createWeapon(WeaponType weaponType, String weaponName, int simpleDmg, int specialDamage, float scaler ) {
		IWeapon weapon;
		if(weaponType !=null) {
			//Weapon is a sword
			if(weaponType.equals(WeaponType.SWORD)) {
				weapon = createSwordWeapon(weaponName, simpleDmg, specialDamage, scaler);
			}
			else if (weaponType.equals(WeaponType.MAGIC)){ //Weapon is a magic weapon
				weapon = createMagicWeapon(weaponName, simpleDmg, specialDamage, scaler);
			}
			else { //Weapon doesn't conform to one of the above types
				weapon = null;
			}
		}else { //The weapon type doesn't exist
			weapon = null;
		}
		
	
		return weapon;
		
	}
	
	/**
	 * Reads a weapon in based on a JSONObject that contains a weapon object to read from
	 * @param jsonToRead the json of the character as a JSONObject
	 * @return the parsed weapon object
	 */
	public IWeapon parseCharacterWeapon(JSONObject jsonToRead) {
		//parse weapon strategy
		WeaponType weaponType;
		String weaponName;
		int simpleDmg;
		int specialDamage;
		float scaler;
		IWeapon weapon;
		if(jsonToRead == null) { //No Json to even read from
			return null;
		}
		try {
			//Read in the values of the weapon
			JSONObject weaponJson = jsonToRead.getJSONObject("weaponStrategy");
		
			//get weapon name 
			weaponName =weaponJson.getString("name");
			//get weapon simple damage
			simpleDmg = weaponJson.getInt("simpleDamage");
			//get weapon special damage
			specialDamage = weaponJson.getInt("specialDamage");
			//get weapon scalar
			scaler = weaponJson.getFloat("scaler");
			//get weapon type
			weaponType =weaponJson.getEnum(WeaponType.class, "weapontype");
		}catch (JSONException e){ //Something went wrong with reading
			//set weapon values to null and -1 to indicate nothing had been read in
			weaponType = null;
			weaponName = null;
			simpleDmg = -1;
			specialDamage =-1;
			scaler=-1;
			return null;
		}
		
		//builds the weapon from the json
	
		weapon = createWeapon(weaponType, weaponName, simpleDmg, specialDamage, scaler);
		
		return weapon;
	}
	
	/**
	 * Creates a sword weapon based on pre-existing values
	 * @param weaponName the name of the weapon
	 * @param simpleDmg the simple damage value 
	 * @param specialDamage the special damage value
	 * @param scaler TODO What is scaler
	 * @return The newly created sword
	 */
	private IWeapon createSwordWeapon(String weaponName, int simpleDmg, int specialDamage, float scaler) {
		return new SwordWeapon(weaponName, simpleDmg, specialDamage, scaler);
	}
	
	/**
	 * Creates a magic weapon based on pre-existing values
	 * @param name The name of the weapon
	 * @param simpleDamage the simple damage value
	 * @param specialDamage the special damage value
	 * @param scaler TODO what is scaler
	 * @return the newly created magic weapon
	 */
	private IWeapon createMagicWeapon(String name, int simpleDamage, int specialDamage, float scaler) {
		return new MagicWeapon(name, simpleDamage, specialDamage, scaler);
	}

}
