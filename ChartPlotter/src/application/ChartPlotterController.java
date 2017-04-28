package application;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.chart.BarChart;

public class ChartPlotterController {
	
	//Access to objects in the fxml file ChartPlotter using the objects id
	@FXML
	private PieChart pieChrt;
	@FXML
	private LineChart<String, Double> lineChrt;
	@FXML
	private ScatterChart<String, Double> scatterChrt;
	@FXML
	private BarChart<String, Double> barChrt;

	/*
	 * Performs the action of opening a file and displaying the data in the file on a graph.
	 * Data must be in two columns.
	*/
	@SuppressWarnings("unchecked")
	@FXML
	public void btnActionPerformed(ActionEvent event) {
		FileChooser fc = new FileChooser();
		//Set initial directory for filechooser when looking for a file to users home folder
		fc.setInitialDirectory(new File(System.getProperty("user.home")));
		File f = fc.showOpenDialog(null); //This allows a user to find a file in a dialog consisting of directories
		
		//A seperate data series is created for each graph
		XYChart.Series<String, Double> series = new XYChart.Series<String, Double>();
		XYChart.Series<String, Double> series2 = new XYChart.Series<String, Double>();
		XYChart.Series<String, Double> series3 = new XYChart.Series<String, Double>();
		ObservableList<PieChart.Data> series4 =  FXCollections.observableArrayList();;
		
		//check if file is valid 
		if(f != null){
			try{
				/*
				 * Work-around, for some reason the animations are preventing the string values from displaying 
				 * on the x-axis of the charts unless the animation is disabled, so it has been disabled as such.
				*/
				//scatterChrt.setAnimated(false); 
				//barChrt.setAnimated(false);
				//lineChrt.setAnimated(false);
				//pieChrt.setAnimated(false);
				
				
				//Reads the file line by line and assigns the two strings as the dataset for the series
		        BufferedReader bufferedReader =  new BufferedReader(new FileReader(f));
		             
		            String line; //temporarily holds each line that is read in by buffer reader
		            while ((line = bufferedReader.readLine()) != null) {
		            	//Splits line that has been read in, into seperate words by whitespace and stores it in array
		                String[] words = line.split(" "); 
		                //Series variables append values stored in temporary array
		                series.getData().add(new XYChart.Data<String, Double>(words[0],Double.parseDouble(words[1])));
		                series2.getData().add(new XYChart.Data<String, Double>(words[0],Double.parseDouble(words[1])));
		                series3.getData().add(new XYChart.Data<String, Double>(words[0],Double.parseDouble(words[1])));
		                series4.add(new PieChart.Data(words[0],Double.parseDouble(words[1])));
			        }
		            
		            //Add the data series to each chart type
		            barChrt.getData().addAll(series);
		            scatterChrt.getData().addAll(series2);
		            lineChrt.getData().addAll(series3);
		            pieChrt.setData(series4);
		            
		            //close buffer reader to avoid resource leak
		            bufferedReader.close();
		            
			}catch(Exception e) {
				//If the file is not a valid readable file, print an error message in an alert box 
				e.printStackTrace();
				Alert alert = new Alert(AlertType.INFORMATION);
			    alert.setTitle("Error");
			    alert.setHeaderText(null);
			    alert.setContentText("File does not contain a valid data set.");
			    alert.show();
			}//end catch	
		}
	}//end method btnActionPerformed
	
	//A method that closes the application
	@FXML
	public void closeApplication(ActionEvent event) {
		 Platform.exit();
		 System.exit(0);
	}//end method closeApplication
	
	//A method that opens a help alert message for the user
	@FXML
	public void openHelp(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Information Dialog");
	    alert.setHeaderText(null);
	    alert.setContentText("Open the program using the 'Open File' button, or click on 'Open File' under the 'File' menu tab.");
	    alert.show();
	}//end method openHelp
}// end class ChartPlotterController
