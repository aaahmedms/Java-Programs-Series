package application;

/*
Objective: An application in JavaFX that plots different charts after reading in a file containing a data set.
 *The dataset has two tab delimited columns.
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
			Parent root = FXMLLoader.load(getClass().getResource("ChartPlotter.fxml"));
			Scene scene = new Scene(root); //set scene to fxml file
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); //include css file for visual changes
			primaryStage.setTitle("ChartPlotterJavaFX"); //assign window title
			primaryStage.setScene(scene); //assign scene to fxml file
			primaryStage.show(); //display program on screen
		} catch(Exception e) {
			e.printStackTrace(); 
		}//end catch
	}//end method start
	
	/*
	*  Main method to start the Java application
	*/
	public static void main(String[] args) {
		launch(args); //this method prepares and launches the program
	}//end method main
}// end class Main
