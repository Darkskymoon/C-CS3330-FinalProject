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
	

	/**
	 * Writes Json to a file using gson.
	 * @param fileName the file to write to
	 * @param jsonContent the json string to write 
	 * @return boolean indicating success: true==success; false==failure
	 */
	public boolean writeJson(String fileName, String jsonContent) {
		try(FileWriter writer = new FileWriter(fileName)){
			writer.write(jsonContent);
			return true;
		}catch (JsonIOException | IOException e) {
			e.printStackTrace();
			return false;
			
		}
	}

}
