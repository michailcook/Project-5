import java.awt.Event;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

	ArrayList<String> resultList;
	Slider hammingDistSlider;
	Scene windowContent;
	VBox windowLayout = new VBox(20);
	TextField prompt;
	Button showStation;
	TextArea listOfStations;
	int hammingSliderValue = 0;
	TextField compareWithPrompt;
	ComboBox compareWith;
	Button calcHD;
	TextArea distances;
	Button addStation;
	TextField userInputStation;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		ArrayList<String> calculations;
//		HammingDistCalc pre = new HammingDistCalc();
//		calculations = pre.calHammingDistList("WEST", 2);
//		for(int i = 0; i < calculations.size(); i++) {
//			System.out.println(calculations.get(i));
//		}
		
		launch(args);
	}

	@Override
	public void start(Stage projectWindow) throws Exception {
		// TODO Auto-generated method stub
		projectWindow.setTitle("Project 5");
		createSlider();
		showAndDisplayStations();
		addAStationAndUpdate();
		addElementsToWindow();
		projectWindow.setScene(windowContent);
		projectWindow.show();
		
			
		
		
		
	}
	
	/**
	 * Method that adds JavaFx objects to the Scene 
	 */
	public void addElementsToWindow() {
		
		windowContent = new Scene(windowLayout, 500, 500);
		windowLayout.getChildren().add(prompt);
		windowLayout.getChildren().add(hammingDistSlider);
		windowLayout.getChildren().add(showStation);
		windowLayout.getChildren().add(listOfStations);
		windowLayout.getChildren().add(compareWithPrompt);
		windowLayout.getChildren().add(compareWith);
		windowLayout.getChildren().add(calcHD);
		windowLayout.getChildren().add(distances);
		windowLayout.getChildren().add(addStation);
		windowLayout.getChildren().add(userInputStation);

		
		
	}
	
	/**
	 * Method that creates the slider for the Hamming Dist of stations
	 *  
	 */
	public void createSlider() {
		prompt = new TextField("Enter Hamming Distance.");
		prompt.setEditable(false);
		
		hammingDistSlider = new Slider(1,4,3);
		hammingDistSlider.setShowTickLabels(true);
		hammingDistSlider.setShowTickMarks(true);
		hammingDistSlider.setMajorTickUnit(1);
		hammingDistSlider.setMinorTickCount(0);
		hammingDistSlider.setBlockIncrement(1);
		hammingDistSlider.setSnapToTicks(true);
		hammingDistSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldVal, Number newVal) {
				// TODO Auto-generated method stub
				prompt.setText("Hamming Distance is " + newVal.intValue());
				hammingSliderValue = newVal.intValue();
				
				
				
			}
		});
		
	
	}
	
	public void showAndDisplayStations() throws IOException {
		
		HammingDistCalc hammingDistCalc = new HammingDistCalc();
		showStation = new Button();
		listOfStations = new TextArea();
		listOfStations.setEditable(false);
		showStation.setText("Show Station");
		
		compareWithPrompt = new TextField("Compare With: ");
		compareWithPrompt.setEditable(false);
		compareWith = new ComboBox(FXCollections.observableArrayList(hammingDistCalc.returnStations()));
		compareWith.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					
					resultList = hammingDistCalc.calHammingDistList(compareWith.getValue().toString(), hammingSliderValue);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		 
		showStation.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO add text from arrayList to text area from calHammingDistList
				listOfStations.clear();
				for(int i = 0; i < resultList.size(); i++) {
					listOfStations.appendText(resultList.get(i) + "\n");
				}
				
				
				
			}
		});
		
		distances = new TextArea();
		distances.setEditable(false);
		calcHD = new Button();
		calcHD.setText("Calculate HD");
		calcHD.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				distances.clear();
				try {
					distances.setText(hammingDistCalc.calDistancesofStation(compareWith.getValue().toString()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
	}
	
	public void addAStationAndUpdate() throws IOException {
		HammingDistCalc hDC = new HammingDistCalc();
		addStation = new Button();
		addStation.setText("Add Station");
		userInputStation = new TextField();
		userInputStation.setEditable(true);
		
		addStation.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				hDC.addStationtoArray(userInputStation.getText().substring(0,4).toUpperCase());
				compareWith.setItems(FXCollections.observableArrayList(hDC.returnStations()));
				
				
			}
		});
		
		
		showStation.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO add text from arrayList to text area from calHammingDistList
				listOfStations.clear();
				for(int i = 0; i < resultList.size(); i++) {
					listOfStations.appendText(resultList.get(i) + "\n");
				}
				
				
				
			}
		});
		
		calcHD.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				distances.clear();
				try {
					distances.setText(hDC.calDistancesofStation(compareWith.getValue().toString()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
	}

}
