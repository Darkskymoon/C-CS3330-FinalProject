package mu.edu.c.logger.GSON;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GsonAdapterTest {

	private String testGsonPath ="src/test/resources/testGson.json";
	private GsonAdapter adapter=null;
	@BeforeEach
	public void init() throws Exception {
		adapter = new GsonAdapter();
		try {
			//clears the log
			FileWriter overwriter = new FileWriter(testGsonPath);
			overwriter.write("");
			overwriter.close();
		}catch(Exception e) {
			throw e;
		}
	}

	
	/**
	 * reads in a single file from the json file
	 * @throws Exception
	 */
	@Test
	void testReadJson() throws Exception {
		//clears the file
		try {
			//clears the log
			FileWriter overwriter = new FileWriter(testGsonPath);
			overwriter.write("");
			overwriter.close();
		}catch(Exception e) {
			throw e;
		}
		//checks reading an empty file
		assertEquals(null, adapter.readJson(testGsonPath));
		
		try {
			//clears the log
			FileWriter overwriter = new FileWriter(testGsonPath);
			overwriter.write("This is a test of the reader");
			overwriter.close();
		}catch(Exception e) {
			throw e;
		}
		assertEquals(true, adapter.readJson(testGsonPath).equals("This is a test of the reader"));
		//test failure 
		assertEquals(null, adapter.readJson("src/test/resources/testGsonFailure"));
	}
	
	@Test
	void testReadAllJson() throws Exception{
		//clears the file
		try {
			//clears the log
			FileWriter overwriter = new FileWriter(testGsonPath);
			overwriter.write("");
			overwriter.close();
		}catch(Exception e) {
			throw e;
		}
		assertEquals(null, adapter.readAllJson(testGsonPath));
		
		try {
			//clears the log
			FileWriter overwriter = new FileWriter(testGsonPath);
			overwriter.write("This is a test of the reader\n");
			overwriter.write("This is the second line\n");
			overwriter.write("This is the third line");
			overwriter.close();
		}catch(Exception e) {
			throw e;
		}
		ArrayList<String> allJson = adapter.readAllJson(testGsonPath);
		if(allJson.size()!=3) {
			fail("Incorrectly read in json");
		}
		assertEquals(true, allJson.get(0).equals("This is a test of the reader"));
		assertEquals(true, allJson.get(1).equals("This is the second line"));
		assertEquals(true, allJson.get(2).equals("This is the third line"));
		
		assertEquals(null, adapter.readAllJson("src/test/resources/testGsonFailure"));
	}
	
	@Test
	public void testWriteJson() throws Exception{
//		writeJson(String fileName, String jsonContent, int option
		//test overwrite
		assertEquals(true, adapter.writeJson(testGsonPath, "This is a test", 0));
		assertEquals(true, adapter.writeJson(testGsonPath, "Test 1 - append", 1));
		assertEquals(true, adapter.writeJson(testGsonPath, "Test 2 - append", 1));
		assertEquals(true, adapter.writeJson(testGsonPath, "Test 3 - append", 1));
		assertEquals(false, adapter.writeJson("src/test/resources/testGsonFailure", "This should fail", 0));
	}
	

}
