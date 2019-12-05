Project 5 Readme / UML

Class: Main

Universal Variables:

	+ ArrayList<String> resultList;
		List of stations to show when show station button is pressed
	+ Slider hammingDistSlider;
		Slider for the HammingDist
	+ Scene windowContent;
		Scene for window
	+ VBox windowLayout;
		Layout Format
	+ TextField prompt;
		Prompt to tell user to pick hammingDist for slider
	+ Button showStation;
		Button that when pressed displayes textArea of resultList Array
	+ TextArea listOfStations;
		TextArea that displays the content of resultList Array
	+ int hammingSliderValue;
		Int value of the slider 
	+ TextField compareWithPrompt;
		Prompt for the ComboBox that tells a user to choose a station
	+ ComboBox compareWith;
		Dropdown box with list of total stations
	+ Button calcHD;
		Button that when pressed displays calculation in distances TextArea
	+ TextArea distances;
		TextArea that shows the calculation of distances for the combobox value
	+ Button addStation;
		Button that when pressed adds user input into ComboBox
	+ TextField userInputStation;
		TextField that lets a user add a station
	+ Image gif;
		Gif of a sleepy duck
	+ ImageView imageView;
		Allows for gif to be displayed

Methods:

	+ addElementsToWindow()
		Method that adds JavaFx objects to the Scene 
	+ createSlider()
		Method that creates the slider for the Hamming Dist of stations and records the change in slider value
	+ showAndDisplayStations()
		Method that displays a list of stations based on the selected station and slider value
	 	Additionally displays the number of stations with a certain HammingDist based on the selected station
	+ addAStationAndUpdate()
		Method that adds a station based on user input and updates previous functions to work with the new station
	+ somethingCreative()
		Adds an image to the scene as a means of the free mode

Class: HammingDistCalc

Unviversal Variables:
	
	+ ArrayList<String> stationIDArray;
		Arraylist of Strings of the Station ID's

Methods:

	+ HammingDistCalc()
		Constructor that allows for access to methods
	+ calHammingDistList(String station, int hammingDist)
		Method to calculate an arraylist of stations with the same hamming dist as the parameter using loops
			String station: Station that is used as a comparator for the other stations
			int hamminfDist: Slider Value of the hammingDist
	+ calDistancesofStation(String station)
		Method that calculates the HammingDist of the parameter station to every station in the arraylist
			String station: Station that is used as a comparator for the other stations
	+ readFile()
		Reads each line and adds the first 4 substrings into the string arraylist
	+ returnStations()
		Returns the current String Arraylist of stations
	+ addStationtoArray(String station)
		Adds a station to the Arraylist of stations
			String station: Station that is added to the stationIDArray