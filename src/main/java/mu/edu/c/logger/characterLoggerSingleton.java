package mu.edu.c.logger;

import mu.edu.c.entities.Entity;

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
	
	public boolean logCharacterData(Entity entity) {
		return false;
	}

}
