package mu.edu.c.logger;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;

import mu.edu.c.entities.Enemy;
import mu.edu.c.entities.Player;
import mu.edu.c.logger.GSON.GsonAdapter;

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
			
			//convert the object to json string
			Gson gson = new Gson();
			String jsonString= gson.toJson(enemy);
			
			GsonAdapter adapter = new GsonAdapter();
			
			//append the Json to the file
			adapter.writeJson(logFilePath, jsonString, 1);
			
			return false;
		}
		
		/**
		 * This reads in the first enemy from the logged Enemy file. It uses the code discussed in class
		 * @return false if unsuccessful, true if successful
		 */
		public Enemy readFirstEnemyData() {
			GsonAdapter adapter = new GsonAdapter();
			Gson gson = new Gson();
			//gets the jsontxt
			String jsontxt =adapter.readJson(logFilePath);
			
			//creates a player object from the json
			Enemy enemy = gson.fromJson(jsontxt, Enemy.class);
			return enemy;

		}
		
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
				EnemyObjects.add(gson.fromJson(enemyIterator.next(), Enemy.class));
				
			}
			
			//If the arraylist is somehow empty, then return null to indicate error
			if(EnemyObjects.isEmpty()) {
				return null;
			}
			
			//Finally, return the arraylist containing all the monsters
			return EnemyObjects;
		}
		
		/**
		 * Resets the enemy Json file to contain all of the base monsters
		 * NOTE: this will erase everything else in the file.
		 */
		private void ResetEnemyFile() {
			//create the base enemy objects
			Enemy Enemy[]= {new Enemy(1, 2, 3, 4, "Zombie"),
					new Enemy(2, 5, 10, 15, "Vampire"),
					new Enemy(14, 8, 3, 4, "Skeleton"),
					new Enemy(12, 10, 5, 11, "Orc"),
					new Enemy(1,2,3,4, "Goblin"),
					new Enemy(12,12,12,12, "Dragon"),
					new Enemy(16, 5,5,5, "Warlock"),
					new Enemy(12, 14, 2, 2, "Bear"),
					new Enemy(10, 5, 2,3, "Killer Rabbit"),
					new Enemy(12, 10, 10, 10, "Werewolf")};
			
			//put the enemy objects in the logger
			for(int i=0; i<Enemy.length; i++) {
				logEnemyData(Enemy[i]);
				
			}

			
			
			
		}

}
