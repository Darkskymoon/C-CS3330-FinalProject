package mu.edu.c.logger;

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
			adapter.writeJson(logFilePath, jsonString);
			
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
		
		//TODO: implement
		public Enemy[] readAllEnemyData() {
			return null;
		}

}
