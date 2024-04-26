package mu.edu.c.logger;

import java.util.ArrayList;
import java.util.Iterator;

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
			
			ArrayList<Battle> BattleObjects = new ArrayList<>();
			
			//Iterates through the arraylist to turn all the strings into enemies
			Iterator<String> BattleIterator =battleStrings.iterator();
			while(BattleIterator.hasNext()) {
				BattleObjects.add(gson.fromJson(BattleIterator.next(), Battle.class));
				
			}
			
			//If the arraylist is empty, then return null to indicate error
			if(BattleObjects.isEmpty()) { //failure
				return null;
			}
			
			//Finally, return the arraylist containing all the monsters
			return BattleObjects;
		}


}
