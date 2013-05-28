import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Read the file specify by the user
 * @author JohnathanMBP
 *
 */
public class readfile {
	public int[] getInput(String filename) throws Exception {
		String inputString = null;
		
		File file = new File(filename);
		
		if (!file.exists()) 
			throw new Exception(filename + " does not exist.");
		if (!(file.isFile() && file.canRead())) 
			throw new Exception(file.getName() + " cannot be read from.");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			char current;
			
			while (fis.available() > 0) {
				current = (char) fis.read();
				if (current >= '1' && current <= '7') inputString = inputString + current;
			}
			fis.close();
			
			char[] inputChar = inputString.toCharArray();
			String inputFiltered = "";
			for (char c : inputChar)
				if (c >= '1' && c <= '7') inputFiltered = inputFiltered + c;
			
			int[] result = new int[inputFiltered.length()];
			 
			for (int i = 0; i < inputFiltered.length(); i++) 
				result[i] = Character.digit(inputFiltered.charAt(i), 10);
			
			return result;
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
