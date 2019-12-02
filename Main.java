import java.awt.Event;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//Stage is the window
//Scene is the content inside

public class Main extends Application {

	Button button;
	Slider slider;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage projectWindow) throws Exception {
		// TODO Auto-generated method stub
		projectWindow.setTitle("Project 5");
		
		button = new Button();
		button.setText("Click me");
		//you can set eventHandlers on the object that you made
		button.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		});
		
		slider = new Slider(1,5,3);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(1);
		slider.setMinorTickCount(0);
		slider.setBlockIncrement(1);
		slider.setSnapToTicks(true);
		//This listener shows a change in slider values
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldVal, Number newVal) {
				// TODO Auto-generated method stub
				System.out.println("value: " + newVal.intValue());
				
			}
		});

		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		layout.getChildren().add(slider);
		
		Scene scene = new Scene(layout, 500, 500);
		projectWindow.setScene(scene);
		projectWindow.show();
		
	}

}
