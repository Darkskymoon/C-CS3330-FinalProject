package mu.edu.c.logger.GSON;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
	 * reads in a json file
	 * @param fileName
	 * @return
	 */
	public String readJson(String fileName) {
		try {
			//read in the file
			byte[] bytes = Files.readAllBytes(Paths.get(fileName));
			return new String(bytes);
		}catch (IOException e) {
			//error
			return null;
			
		}
	}
	

	public boolean writeJson(String fileName, String jsonContent) {
		//filewriter is passed true to APPEND rather than overwrite
		try(FileWriter writer = new FileWriter(fileName, true)){
			gson.toJson(jsonContent, writer);
			return true;
		}catch (JsonIOException | IOException e) {
			return false;
			
		}
	}

}
