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
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage projectWindow) throws Exception {
		// TODO Auto-generated method stub
		projectWindow.setTitle("Project 5");
		createSlider();
		showAndDisplayStations();
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
	}
	
	/**
	 * Method that creates the slider for the Hamming Dist of stations
	 *  
	 */
	public void createSlider() {
		prompt = new TextField("Enter Hamming Distance.");
		prompt.setEditable(false);
		
		hammingDistSlider = new Slider(1,5,3);
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
	}

}
