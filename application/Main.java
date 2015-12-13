package application;
	
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
//import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;


public class Main extends Application implements Initializable  { 
	@FXML Button submitButton;
	@FXML TextField textField;
	@FXML TextArea textArea;
	
	
    private Driver driver;
	
	@FXML
    private void handleButtonAction(ActionEvent event) {
		if (driver.getStage() < 3)
			driver.Login();
			
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		textArea.appendText("Are you a student or parent?: ");
		driver = new Driver(textField,textArea);
	}
}
