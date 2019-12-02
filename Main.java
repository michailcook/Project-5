import java.awt.Event;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {

	Slider hammingDistSlider;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage projectWindow) throws Exception {
		// TODO Auto-generated method stub
		projectWindow.setTitle("Project 5");
		projectWindow.show();
		
			
		
		
		
	}
	
	/*
	 * Method that creates the slider for the 
	 */
	public void createSlider() {
		TextField prompt = new TextField("Enter Hamming Distance.");
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
				
				
			}
		});
		

		
	}

}
