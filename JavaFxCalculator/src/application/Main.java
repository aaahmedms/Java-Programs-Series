package application;

/*
 Objective:  A calculator application that utilizes the JavaFX GUI Libraries.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("CalculatorJavaFX.fxml"));
			Scene scene = new Scene(root); //set scene to fxml file
			scene.getStylesheets().add("/application/application.css"); //include css file for visual changes
            primaryStage.setTitle("CalculatorJavaFX"); //assign window title
			primaryStage.setScene(scene); //assign scene to fxml file
			primaryStage.show(); //display program on screen
		} catch(Exception e) {
			e.printStackTrace();
		}//end catch
	} //end method start
	
	/*
	*  Main method to start the Java application
	*/
	public static void main(String[] args) {
		launch(args); //this method prepares and launches the program
	}//end method main
}// end class Main
