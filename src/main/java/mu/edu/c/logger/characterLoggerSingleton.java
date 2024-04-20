package mu.edu.c.logger;

import com.google.gson.Gson;

import mu.edu.c.entities.Enemy;
import mu.edu.c.entities.Entity;
import mu.edu.c.logger.GSON.GsonAdapter;

//Author: Zoe 
public class characterLoggerSingleton {
	//creates a single instance of the logger
	private static characterLoggerSingleton instance = null;
	
	//Creates a filepath for the logger file
	private final static String logFilePath = "./main/resources/characterLogger.txt";
	
	//constructor 
	private characterLoggerSingleton() {
		
	}
	
	/**
	 * This method creates a single instance of the logger. It returns the existing instance
	 * if an instance already exists. Otherwise it creates a new instance and returns that.
	 * @return instance of the logger
	 */
	public static characterLoggerSingleton getInstance() {
		if(instance == null) {
			instance = new characterLoggerSingleton();
		}
		return instance;
	}
	
	
	/**
	 * creates json objects of the character and writes that to the file.
	 * @param character
	 * @return
	 */
	public boolean logCharacterData(Character character) {
		
		//convert the object to json string
		Gson gson = new Gson();
		String jsonString= gson.toJson(character);
		
		GsonAdapter adapter = new GsonAdapter();
		adapter.writeJson(this.logFilePath, jsonString);
		
		return false;
	}
	
	

}
