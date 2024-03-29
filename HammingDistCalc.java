import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HammingDistCalc {

	
	public ArrayList<String> stationIDArray = new ArrayList();
	
	
	/**
	 * Constructor that allows for access to methods
	 * @throws IOException
	 */
	public HammingDistCalc() throws IOException {
		readFile();
		returnStations();
		
	}
	
	/**
	 * Method to calculate an arraylist of stations with the same hamming dist as the parameter using loops
	 * @param station Station that is used as a comparator for the other stations
	 * @param hammingDist Slider Value of the hammingDist
	 * @return an arraylist of stations with the same hamming dist as the parameter
	 * @throws IOException
	 */
	public ArrayList<String> calHammingDistList(String station, int hammingDist) throws IOException {
		
		ArrayList<String> stationsWithSameHammingDist = new ArrayList();
		int hammingDistTemp = 0;
		for(int i = 0; i < stationIDArray.size(); i++) {
			
			char[] charOfStationID = stationIDArray.get(i).toCharArray();
			char[] charOStationPara = station.toCharArray();
			
			for(int j = 0; j < charOfStationID.length; j++) {
				
				if(charOfStationID[j] != charOStationPara[j]) {
					hammingDistTemp = hammingDistTemp + 1;
					
				}
			}
			
			if(hammingDist == hammingDistTemp) {
				stationsWithSameHammingDist.add(stationIDArray.get(i));
				
				
			}
			
			hammingDistTemp = 0;
			
		}
		
		
		return stationsWithSameHammingDist;
	}
	
	/**
	 * Method that calculates the HammingDist of the parameter station to every station in the arraylist
	 * @param station Station that is used as a comparator for the other stations
	 * @return String of Station calculations
	 * @throws IOException
	 */
	public String calDistancesofStation(String station) throws IOException {
		
		
		int distanceOfZero = 0;
		int distanceOfOne = 0;
		int distanceOfTwo = 0;
		int distanceOfThree = 0;
		int distanceOfFour = 0;
		int hammingDistTemp = 0;
		for(int i = 0; i < stationIDArray.size(); i++) {
			
			char[] charOfStationID = stationIDArray.get(i).toCharArray();
			char[] charOStationPara = station.toCharArray();
			
			for(int j = 0; j < charOfStationID.length; j++) {
				
				if(charOfStationID[j] != charOStationPara[j]) {
					hammingDistTemp = hammingDistTemp + 1;
					
				}
			}
			
			switch(hammingDistTemp){
			
			case 0:
				distanceOfZero = distanceOfZero + 1;
				break;
				
			case 1:
				distanceOfOne = distanceOfOne + 1;
				break;
				
			case 2:
				distanceOfTwo = distanceOfTwo + 1;
				break;
			
			case 3:
				distanceOfThree = distanceOfThree + 1;
				break;
				
			case 4:
				distanceOfFour = distanceOfFour + 1;
				break;
			}
			
			hammingDistTemp = 0;
			
		}
		
		String calculations = "Distance 0: " + distanceOfZero + "\nDistance 1: "
				+ distanceOfOne + "\nDistane 2: " + distanceOfTwo;
		
		String calculationsPart2 = "\nDistance 3: " + distanceOfThree + 
				"\nDistance 4: " + distanceOfFour;
		
		return calculations + calculationsPart2;
		
		
	}
	
	/**
	 * Reads each line and adds the first 4 substrings into the string arraylist
	 * @throws IOException
	 */
	public void readFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		String line = br.readLine();
		for(int i = 0; line != null; i++) {
		
			
			line = line.trim();	
			
			stationIDArray.add(line.substring(0,4));
			line = br.readLine();
		
		}
		br.close();
	}
	
	
	/**
	 * Returns the current String Arraylist of stations
	 * @return
	 */
	public ArrayList<String> returnStations() {
		
		return stationIDArray;
	}
	
	/**
	 * Adds a station to the Arraylist of stations
	 */
	public void addStationtoArray(String station) {
		
		stationIDArray.add(station);
	}

}
