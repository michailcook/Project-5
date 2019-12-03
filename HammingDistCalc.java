import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HammingDistCalc {

	int capacity = 5;
	String[] stationIDArray = new String[capacity];
	
	public HammingDistCalc() throws IOException {
		readFile();
		returnStations();
	}
	
//	public String[] calHammingDistList() throws IOException {
//		readFile();
//	}
//	
	/**
	 * Reads each line and adds the first 4 substrings into the string array
	 * @throws IOException
	 */
	public void readFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		String line = br.readLine();
		for(int i = 0; line != null; i++) {
		
			
			line = line.trim();	
			if (i == capacity) {
				
				expandArray();
			
			}
			

			stationIDArray[i] = line.substring(0,4);
			line = br.readLine();
		
		}
		br.close();
	}
	
	public void expandArray() {
		int i;
		String temp[] = new String[capacity * 2];
		for (i = 0; i < stationIDArray.length; i++) {

			temp[i] = stationIDArray[i];

		}
		this.capacity = capacity * 2;
		this.stationIDArray = temp;

	}
	
	public String[] returnStations() {
		
		return stationIDArray;
	}
	

}
