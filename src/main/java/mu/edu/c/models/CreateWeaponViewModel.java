package mu.edu.c.models;

import mu.edu.c.entities.Player;
import mu.edu.c.logger.CharacterLoggerSingleton;
import mu.edu.c.weapons.IWeapon;
import mu.edu.c.weapons.WeaponFactoryMethod;
import mu.edu.c.weapons.WeaponType;

public class CreateWeaponViewModel {
	private String weaponName;
	private int weaponTypeIndex;
	private int weaponSimpleDamage;
	private int weaponSpecialDamage;
	private float weaponScaler;
	private Boolean loggerIsPopulated = true;
	
	// checks if the character logger is empty
	private CharacterLoggerSingleton logger = CharacterLoggerSingleton.getInstance();
	private Player currentPlayer = logger.readCharacterData();
	private WeaponFactoryMethod weaponFactoryWeapon = new WeaponFactoryMethod();
		
	/**
	 * @return returns false if character data is empty, true if operation was a success
	 * */
	public Boolean equipCharacterWithWeapon() {
		if (currentPlayer != null) {
			//gets weapon type enum from the weapon index returned by view
			WeaponType weaponType = WeaponType.values()[weaponTypeIndex];
			// create a new weapon
			IWeapon newWeapon = weaponFactoryWeapon.createWeapon(weaponType, weaponName, weaponSimpleDamage, weaponSpecialDamage, weaponScaler);
			// adds weapon to current player
			currentPlayer.setWeaponStrategy(newWeapon);
			//saves character data
			logger.logCharacterData(currentPlayer);
			// returns a flag indicating that the operation was a success
			return loggerIsPopulated;
		}
		// returns a flag indicating that the character page is empty and that a character has to be created
		loggerIsPopulated = false;
		return loggerIsPopulated;
	}
	
	public void setWeaponTypeIndex(int weaponTypeIndex) {
		this.weaponTypeIndex = weaponTypeIndex;
	}

	public void setWeaponSimpleDamage(int weaponSimpleDamage) {
		this.weaponSimpleDamage = weaponSimpleDamage;
	}

	public void setWeaponSpecialDamage(int weaponSpecialDamage) {
		this.weaponSpecialDamage = weaponSpecialDamage;
	}

	public void setWeaponScaler(float weaponScaler) {
		this.weaponScaler = weaponScaler;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}
	
	public void setPopulated(Boolean flag) {
		this.loggerIsPopulated = flag;
	}
	
	public boolean getPopulated() {
		return this.loggerIsPopulated;
	}
	

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
}
