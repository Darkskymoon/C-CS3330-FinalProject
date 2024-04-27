package mu.edu.c.logger;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import mu.edu.c.battles.Battle;
import mu.edu.c.entities.Enemy;
import mu.edu.c.entities.Player;
import mu.edu.c.logger.GSON.GsonAdapter;

public class BattleLoggerSingleton {
	//creates a single instance of the logger
		private static BattleLoggerSingleton instance = null;
		
		//Creates a filepath for the logger file
		private final static String logFilePath = "src/main/resources/battleLogger.json";
		
		//constructor 
		private BattleLoggerSingleton() {
			
		}
		
		/**
		 * This method creates a single instance of the logger. It returns the existing instance
		 * if an instance already exists. Otherwise it creates a new instance and returns that.
		 * @return instance of the logger
		 */
		public static BattleLoggerSingleton getInstance() {
			if(instance == null) {
				instance = new BattleLoggerSingleton();
			}
			return instance;
		}
		
		
		/**
		 * creates json objects of the battle and writes that to the file.
		 * @param character
		 * @return TODO
		 */
		public boolean logBattleData(Battle battle) {
			
			//convert the object to json string
			Gson gson = new Gson();
			String jsonString= gson.toJson(battle);
			
			GsonAdapter adapter = new GsonAdapter();
			
			//append to all battles
			boolean flag = adapter.writeJson(logFilePath, jsonString, 1);
			if(flag == false) {
				return false;
			}
			return true;
		}
		/**
		 * Reads in all of the battle stored in a file and converts them to objects
		 * @return an arraylist of battle objects representing the JSON battle log
		 */
		public ArrayList<Battle> readAllBattleData() {
			GsonAdapter adapter = new GsonAdapter();
			Gson gson = new Gson();
			
			ArrayList<String> battleStrings = new ArrayList<>();
			
			//reads in the file
			battleStrings = adapter.readAllJson(logFilePath);
			if(battleStrings == null) { //failure
				return null;
			}
			
			ArrayList<Battle> battleObjects = new ArrayList<>();
			
			//Iterates through the arraylist to turn all the strings into enemies
			Iterator<String> battleIterator =battleStrings.iterator();
			while(battleIterator.hasNext()) {
				battleObjects.add(readSingleBattle(battleIterator.next()));
				//BattleObjects.add(gson.fromJson(BattleIterator.next(), Battle.class));
				
			}
			
			//If the arraylist is empty, then return null to indicate error
			if(battleObjects.isEmpty()) { //failure
				return null;
			}
			
			//Finally, return the arraylist containing all the monsters
			return battleObjects;
		}
		
		/**
		 * reads in a single battle and converts it to a battle object
		 * @param txtJson json representing the battle
		 * @return constructed battle object or null if failed
		 */
		private Battle readSingleBattle(String txtJson) {
			//each battle consists of a player and an enemy
			
			
			//constructs needed variables
			JSONObject jsonParser;
			Player player;
			Enemy enemy;
			Battle battle;
			//gets all the needed loggers
			EnemyLoggerSingleton enemyLogger = EnemyLoggerSingleton.getInstance();
			CharacterLoggerSingleton charLogger = CharacterLoggerSingleton.getInstance();
			try {
				jsonParser = new JSONObject(txtJson);
				
				//get the player object
				JSONObject playerJson = jsonParser.getJSONObject("player");
				//convert the json to a string so that it can be passed to readCharacter
				String playerJsonTxt =playerJson.toString();
				
				player = charLogger.readCharacter(playerJsonTxt);
				
				//get the enemy object
				JSONObject enemyJson = jsonParser.getJSONObject("CurrentEnemy");
				String enemyJsonTxt = enemyJson.toString();
				enemy= enemyLogger.readEnemyFromJson(enemyJsonTxt);
				
				
			} catch(JSONException e) {
				return null;
			}
			
			if(enemy == null || player == null) {
				return null;
			}
			battle = new Battle(player, enemy);
			
			return battle;
		}


}

	