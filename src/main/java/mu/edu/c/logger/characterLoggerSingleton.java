package mu.edu.c.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;

import mu.edu.c.entities.Enemy;
import mu.edu.c.entities.Entity;
import mu.edu.c.entities.Player;
import mu.edu.c.logger.GSON.GsonAdapter;

//Author: Zoe 
public class characterLoggerSingleton {
	//creates a single instance of the logger
	private static characterLoggerSingleton instance = null;
	
	//Creates a filepath for the logger file
	private final static String logFilePath = "src/main/resources/characterLogger.json";
	
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
	public boolean logCharacterData(Player player) {
		
		//convert the object to json string
		Gson gson = new Gson();
		String jsonString= gson.toJson(player);
		
		GsonAdapter adapter = new GsonAdapter();
		
		//overwrite previous character
		adapter.writeJson(logFilePath, jsonString, 0);
		
		return false;
	}
	
	/**
	 * This reads the current character from the logged character file. It uses the code discussed in class
	 * @return false if unsuccessful, true if successful
	 */
	public Player readCharacterData() {
		GsonAdapter adapter = new GsonAdapter();
		Gson gson = new Gson();
		//gets the jsontxt
		String jsontxt =adapter.readJson(logFilePath);
		System.out.println(jsontxt);
		
		//creates a player object from the json
		Player player = gson.fromJson(jsontxt, Player.class);
		return player;

	}

}
