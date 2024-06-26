package mu.edu.c.logger;

import com.google.gson.Gson;

import mu.edu.c.entities.EntityFactoryMethod;
import mu.edu.c.entities.Player;
import mu.edu.c.logger.GSON.GsonAdapter;
import mu.edu.c.weapons.IWeapon;
import mu.edu.c.weapons.WeaponFactoryMethod;

import org.json.*;



//Author: Zoe 
public class CharacterLoggerSingleton {
	//creates a single instance of the logger
	private static CharacterLoggerSingleton instance = null;
	
	//Creates a filepath for the logger file
	private final static String logFilePath = "src/main/resources/characterLogger.json";
	
	//constructor 
	private CharacterLoggerSingleton() {
		
	}
	
	/**
	 * This method creates a single instance of the logger. It returns the existing instance
	 * if an instance already exists. Otherwise it creates a new instance and returns that.
	 * @return instance of the logger
	 */
	public static CharacterLoggerSingleton getInstance() {
		if(instance == null) {
			instance = new CharacterLoggerSingleton();
		}
		return instance;
	}
	
	/**
	 * creates json objects of the character and writes that to the file.
	 * @param character
	 * @return
	 */
	public boolean logCharacterData(Player player) {
		if(player == null) {
			return false;
		}
		
		//convert the object to json string
		Gson gson = new Gson();
		String jsonString= gson.toJson(player);
		
		GsonAdapter adapter = new GsonAdapter();
		
		//overwrite previous character
		boolean flag = adapter.writeJson(logFilePath, jsonString, 0);
		return flag;
	}
	
	/**
	 *
	 * This reads the current character from the logged character file.
	 * @return null if failed, player if successful
	 */
	public Player readCharacterData() {
		GsonAdapter adapter = new GsonAdapter();
		
		//gets the jsontxt
		String jsontxt =adapter.readJson(logFilePath);
		Player player =readCharacter(jsontxt);
		return player;
	}
	
	/**
	 * creates a player object based on a Json string
	 * @param jsontxt string to turn into a player
	 * @return Player object
	 */
	public Player readCharacter(String jsontxt) {
		if(jsontxt ==null) { //nothing to read in
			return null;
		}

		//initialize variables for the player object
		int attributePoints=0;
		float hp =0;
		float maxHP =0;
		int strength =0 ;
		int defense=0;
		int brains=0;
		String name=null;
		int xp=0;
		
		//create a json object out of the jsontxt
		JSONObject jsonParser;
		try {
			jsonParser = new JSONObject(jsontxt);
	
			//get attributes of player
			attributePoints = jsonParser.getInt("attributePoints");
			//get hp
			hp = jsonParser.getFloat("hp");
			maxHP = jsonParser.getFloat("maxHP");
			
			//get stats
			strength = jsonParser.getInt("strength");
			defense=jsonParser.getInt("defense");
			brains = jsonParser.getInt("brains");

			//get name
			name = jsonParser.getString("name");
			
			//get xp
			xp =jsonParser.getInt("xp");
		} catch (JSONException e) { //error of some sort
			return null;
		}
		
		//Gets the weapon
		WeaponFactoryMethod weaponFactory = new WeaponFactoryMethod();
		IWeapon weapon = weaponFactory.parseCharacterWeapon(jsonParser);
		
		
		//create player
		Player player =null;
		EntityFactoryMethod entityFactory = new EntityFactoryMethod();
		if(weapon!=null) {//if weapon is not null, create a player with the weapon
			player= entityFactory.createPlayerWithWeapon(maxHP, strength, defense, brains, name, weapon);
		}
		else { //if no weapon is found, create a player without the weapon
			player = entityFactory.createPlayer(maxHP, strength, defense, brains,name);
		}
	
		return player;
		
	}

}
