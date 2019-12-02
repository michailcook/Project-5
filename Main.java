import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//Stage is the window
//Scene is the content inside

public class Main extends Application {

	Button button;
	
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
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout, 500, 500);
		projectWindow.setScene(scene);
		projectWindow.show();
		
	}

}
