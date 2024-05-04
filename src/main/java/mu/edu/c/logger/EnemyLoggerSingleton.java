package mu.edu.c.logger;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import mu.edu.c.entities.Enemy;
import mu.edu.c.entities.EntityFactoryMethod;
import mu.edu.c.entities.Player;
import mu.edu.c.logger.GSON.GsonAdapter;
import mu.edu.c.weapons.IWeapon;
import mu.edu.c.weapons.MagicWeapon;
import mu.edu.c.weapons.SwordWeapon;
import mu.edu.c.weapons.WeaponFactoryMethod;
import mu.edu.c.weapons.WeaponType;

public class EnemyLoggerSingleton {
	//creates a single instance of the logger
		private static EnemyLoggerSingleton instance = null;
		
		//Creates a filepath for the logger file
		private final static String logFilePath = "src/main/resources/enemyLogger.json";
		
		//constructor 
		private EnemyLoggerSingleton() {
			
		}
		
		/**
		 * This method creates a single instance of the logger. It returns the existing instance
		 * if an instance already exists. Otherwise it creates a new instance and returns that.
		 * @return instance of the logger
		 */
		public static EnemyLoggerSingleton getInstance() {
			if(instance == null) {
				instance = new EnemyLoggerSingleton();
			}
			return instance;
		}
		
		
		/**
		 * creates json objects of the Enemy and writes that to the file.
		 * @param enemy object to write to the file
		 * @return
		 */
		public boolean logEnemyData(Enemy enemy) {
			if(enemy == null) {
				return false;
			}
			
			//convert the object to json string
			Gson gson = new Gson();
			String jsonString= gson.toJson(enemy);
			
			GsonAdapter adapter = new GsonAdapter();
			
			//append the Json to the file
			boolean flag = adapter.writeJson(logFilePath, jsonString, 1);
			return flag;
		}
		
//		/**
//		 * This reads in the first enemy from the logged Enemy file. It uses the code discussed in class
//		 * @return false if unsuccessful, true if successful
//		 */
//		public Enemy readFirstEnemyData() {
//			GsonAdapter adapter = new GsonAdapter();
//			Gson gson = new Gson();
//			//gets the jsontxt
//			String jsontxt =adapter.readJson(logFilePath);
//			
//			//creates a enemy object from the json
//			Enemy enemy = gson.fromJson(jsontxt, Enemy.class);
//			return enemy;
//
//		}
		
		/**
		 * Reads in all of the enemies stored in a file and converts them to objects
		 * @return an arraylist of enemy objects representing the JSON Enemy log
		 */
		public ArrayList<Enemy> readAllEnemyData() {
			GsonAdapter adapter = new GsonAdapter();
			Gson gson = new Gson();
			
			ArrayList<String> Enemies = new ArrayList<>();
			
			//reads in the file
			Enemies = adapter.readAllJson(logFilePath);
			
			//Enemies is empty/readAllJson failed - initialize the file
			if(Enemies==null) {
				ResetEnemyFile();
				Enemies = adapter.readAllJson(logFilePath);
				if(Enemies ==null) { //if still empty at this point, return null. Something else went wrong
					return null;
				}
						
			}
			
			
			ArrayList<Enemy> EnemyObjects = new ArrayList<>();
			
			//Iterates through the arraylist to turn all the strings into enemies
			Iterator<String> enemyIterator =Enemies.iterator();
			while(enemyIterator.hasNext()) {
				EnemyObjects.add(readEnemyFromJson(enemyIterator.next()));
//				EnemyObjects.add(gson.fromJson(enemyIterator.next(), Enemy.class));
				
			}
			
			//If the arraylist is somehow empty, then return null to indicate error
			if(EnemyObjects.isEmpty()) {
				return null;
			}
			
			//Finally, return the arraylist containing all the monsters
			return EnemyObjects;
		}
		
		
		/**
		 * converts a json string to an enemy.
		 * @param jsontxt the text to convert
		 * @return Enemy object from the text
		 */
		public Enemy readEnemyFromJson(String jsontxt) {
			//json is null or empty - automatic failure
			if(jsontxt ==(null) || jsontxt.length()==0) {
				return null;
			}
			
			//Initialize all needed variables
			JSONObject jsonParser;
			float hp = -1;
			float maxHP = -1;
			int strength = -1;
			int defense = -1;
			int brains = -1;
			String name = null;
			ArrayList<String> descriptors = new ArrayList<>();
			
			//weapon variables
			IWeapon weapon = null;
			
			try{
				//create a json object out the text
				jsonParser = new JSONObject(jsontxt);
				
				//gets the stats
				hp=jsonParser.getFloat("hp");
				maxHP = jsonParser.getFloat("maxHP");
				strength = jsonParser.getInt("strength");
				defense = jsonParser.getInt("defense");
				brains = jsonParser.getInt("brains");
				
				//gets the name
				name = jsonParser.getString("name");
				
				//gets descriptors
				JSONArray tempDescriptors = jsonParser.getJSONArray("descriptors");
				
				for(int i =0; i<tempDescriptors.length(); i++) {
					try {
						String singleDescriptor = tempDescriptors.getString(i);
						descriptors.add(singleDescriptor);
					} catch (ClassCastException e) {
						return null;
					}
				}

			}catch(JSONException e) {
				return null;
			}
			
			//reads in the weapon info
			WeaponFactoryMethod weaponFactory = new WeaponFactoryMethod();
			weapon = weaponFactory.parseCharacterWeapon(jsonParser);
			

			//create Enemy
			EntityFactoryMethod entityFactory =new EntityFactoryMethod();
			Enemy enemy=entityFactory.createEnemy(maxHP, strength, defense, brains, name, descriptors, weapon);
			
			return enemy;
		}
		
		
		
		/**
		 * Resets the enemy Json file to contain all of the base monsters
		 * NOTE: this will erase everything else in the file.
		 * @return true if success, false if failure
		 */
		private boolean ResetEnemyFile() {
			//create the base enemy objects
			Enemy Enemy[]= {new Enemy(1, 2, 3, 4, "Zombie"),
					new Enemy(15, 5, 15, 15, "Vampire"),
					new Enemy(14, 8, 12, 4, "Skeleton"),
					new Enemy(12, 10, 10, 11, "Orc"),
					new Enemy(1,2,8,8, "Goblin"),
					new Enemy(12,12,20,12, "Dragon"),
					new Enemy(16, 5,13,5, "Warlock"),
					new Enemy(12, 14, 13, 2, "Bear"),
					new Enemy(10, 5, 8,3, "Killer Rabbit"),
					new Enemy(12, 10, 10, 10, "Werewolf")};
			
			//put the enemy objects in the logger
			for(int i=0; i<Enemy.length; i++) {
				boolean flag =logEnemyData(Enemy[i]);
				if(flag ==false) {
					return false;
				}
				
			}
			return true;	
			
		}

}
