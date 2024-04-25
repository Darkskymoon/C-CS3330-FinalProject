package mu.edu.c.logger.GSON;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

/**
 * This method is an adapter to json to Gson. 
 * This uses the code presented in class (week13M-AdapterDP-Gson)
 * 
 */
public class GsonAdapter{
	private Gson gson;
	
	public GsonAdapter() {
		this.gson = new Gson();
	}
	/**
	 * reads in the first line of a json file
	 * @param fileName
	 * @return string of the read in line
	 */
	public String readJson(String fileName) {
		try {
			//Creates a new fileScanner
			Scanner fileScanner = new Scanner(new FileInputStream(fileName));
			String stringToReturn=null;
			//Checks to see if there is not anything in the file
			if(!fileScanner.hasNextLine()) {
				return null;
			}
			else {
				stringToReturn = fileScanner.nextLine();
			}
			
			fileScanner.close();
			return stringToReturn;
			//read in the file
//			byte[] bytes = Files.readAllBytes(Paths.get(fileName));
//			return new String(bytes);
		}catch (IOException e) {
			//error
			return null;
			
		}
	}
	
	/**
	 * This method reads in all of the Json in the file
	 * TODO:implement
	 * @param fileName the filepath string
	 * @return arraylist of all of the json objects (as strings)
	 */
	public ArrayList<String> readAllJson(String fileName) {
//		try {
//			Arraylist<String>
//			//open file scanner
//			Scanner fileScanner = new Scanner(new FileInputStream(fileName));
//			
//			//check to see if file is empty
//			if(!fileScanner.hasNextLine()){
//				return null;
//			}
//			
//			
//			//read in the lines
//			while(fileScanner.hasNextLine()) {
//				String string = fileScanner.nextLine();
//				
//				
//			}
//		}
		return null;
	}
	

	/**
	 * Writes Json to a file using gson.
	 * @param fileName the file to write to
	 * @param jsonContent the json string to write 
	 * @return boolean indicating success: true==success; false==failure
	 */
	public boolean writeJson(String fileName, String jsonContent) {
		try(FileWriter writer = new FileWriter(fileName)){
			writer.write(jsonContent+"\n");
			writer.close();
			return true;
		}catch (JsonIOException | IOException e) {
			e.printStackTrace();
			return false;
			
		}
	}

}
