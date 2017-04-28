package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;

public class CalculatorJavaFXController {
	@FXML
	private TextField operation; //shows all arithmetic user operations
	@FXML
	private TextField output; //acts as a display for all inputs
	
	private String holdString; //temporarily stores the operation and displays it to the user in the history label
	private Double result; //holds the final result after an arithmetic operation and is displayed on the JTextField output
	private String OperationType; //specifies the type of arithmetic operation indicated by a string
	private Boolean isDefaultZero; //a flag that checks if default value on output is zero, when any number btn is pressed switch value wit zero
	private DecimalFormat df; //assigns proper formatting of values outputted as decimal to the textfield
	
	/**
	 * Constructor, Initializes all variables
	 */
	public CalculatorJavaFXController() {
		isDefaultZero = false;
		result = 0.00; //on start of application, the default value is 0
		OperationType = ""; //operation type should be defaulted on start since nothing is happening
		//this is used to prevent scientific notation results during arithmetic operations
		df = new DecimalFormat("#"); 
        df.setMaximumFractionDigits(8);
	}// end constructor
	
	// Event Listener on Button.onAction
	@FXML
	public void actionPerformedSqrt(ActionEvent event) {
		result = Double.parseDouble(output.getText()); //convert number in textfield to double for calculations
		holdString = output.getText(); //hold current input and show it in current operations label, currOPlbl
		operation.setText(holdString);
		String SQR = "\u221A";//sqrt symbol
		operation.setText(SQR + operation.getText() + " ");
		result = Math.sqrt(result);
		output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
		OperationType = ""; //set operation type to nothing	
	} //end method actionPerformedSqrt
	
	// Event Listener on Button.onAction
	@FXML
	public void actionPerformedPow(ActionEvent event) {
		result = Double.parseDouble(output.getText()); //convert number in textfield to double for calculations
		holdString = output.getText(); //hold current input and show it in current operations label, currOPlbl
		operation.setText(holdString);
		operation.setText(operation.getText() + " ^");
		output.setText("0");
		isDefaultZero = true; //Default back to 0 so user can input any num value to replace it, including 0
		OperationType = "pow"; //Operation type is set to pow, the code below does the actual calculation
	} //end method actionPerformedPow
	
	// Event Listener on Button.onAction
	@FXML
	public void actionPerformedPercent(ActionEvent event) {
		result = result * (Double.parseDouble(output.getText()))/100; //get percentage of value in textfield, then convert to double for calculations
		output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
		OperationType = ""; //set operation type to nothing
		operation.setText(""); 
		isDefaultZero = true; //Default back to 0 so user can input any num value to replace it, including 0
	} //end method actionPerformedPercent
	
	// Event Listener on Button.onAction
	@FXML
	public void actionPerformedClear(ActionEvent event) {
		//set calculator back to default state
		result = 0.00;
		holdString = "";
		operation.setText("");
		output.setText("0");
		isDefaultZero = true;
		OperationType = "";
	} //end method actionPerformedClear
	
	// Event Listener on Button.onAction
	@FXML
	public void actionPerformedDivide(ActionEvent event) {
		result = Double.parseDouble(output.getText()); //convert number in textfield to double for calculations
		holdString = output.getText(); //hold current input and show it in current operations label, currOPlbl
		operation.setText(holdString);
		operation.setText(operation.getText() + " /");
		output.setText("0"); 
		isDefaultZero = true; //Default back to 0 so user can input any num value to replace it, including 0
		OperationType = "divi"; //Operation type is set to divide, the code below does the actual calculation	
	}//end method actionPerformedDivide
	
	// Event Listener on Button.onAction
		@FXML
		public void actionPerformed0(ActionEvent event) {
			//if current value contains 0, replace it with this input
			if(isDefaultZero == true)
			{
				output.setText("0");
				isDefaultZero = false;
			}
			else{
				output.setText(output.getText() + "0");
			}
		}//end method actionPerformed0
		
		// Event Listener on Button.onAction
			@FXML
			public void actionPerformed1(ActionEvent event) {
				//if current value contains 0, replace it with this input
				if(isDefaultZero == true)
				{
					output.setText("1");
					isDefaultZero = false;
				}
				else{
					output.setText(output.getText() + "1");
				}
			}//end method actionPerformed1
			
			// Event Listener on Button.onAction
			@FXML
			public void actionPerformed2(ActionEvent event) {
				//if current value contains 0, replace it with this input
				if(isDefaultZero == true)
				{
					output.setText("2");
					isDefaultZero = false;
				}
				else{
					output.setText(output.getText() + "2");
				}
			}//end method actionPerformed2
			
			// Event Listener on Button.onAction
			@FXML
			public void actionPerformed3(ActionEvent event) {
				//if current value contains 0, replace it with this input
				if(isDefaultZero == true)
				{
					output.setText("3");
					isDefaultZero = false;
				}
				else{
					output.setText(output.getText() + "3");
				}
			}//end method actionPerformed3
			
	// Event Listener on Button.onAction
	@FXML
	public void actionPerformed4(ActionEvent event) {
		//if current value contains 0, replace it with this input
		if(isDefaultZero == true)
		{
			output.setText("4");
			isDefaultZero = false;
		}
		else{
			output.setText(output.getText() + "4");
		}
	}//end method actionPerformed4
	
	// Event Listener on Button.onAction
	@FXML
	public void actionPerformed5(ActionEvent event) {
		//if current value contains 0, replace it with this input
		if(isDefaultZero == true)
		{
			output.setText("5");
			isDefaultZero = false;
		}
		else{
			output.setText(output.getText() + "5");
		}
	}//end method actionPerformed5
	
	// Event Listener on Button.onAction
	@FXML
	public void actionPerformed6(ActionEvent event) {
		//if current value contains 0, replace it with this input
		if(isDefaultZero == true)
		{
			output.setText("6");
			isDefaultZero = false;
		}
		else{
			output.setText(output.getText() + "6");
		}
	}//end method actionPerformed6
	
	// Event Listener on Button.onAction
		@FXML
		public void actionPerformed7(ActionEvent event) {
			//if current value contains 0, replace it with this input
			if(isDefaultZero == true)
			{
				output.setText("7");
				isDefaultZero = false;
			}
			else{
				output.setText(output.getText() + "7");
			}
		}//end method actionPerformed7
		
		// Event Listener on Button.onAction
		@FXML
		public void actionPerformed8(ActionEvent event) {
			//if current value contains 0, replace it with this input
			if(isDefaultZero == true)
			{
				output.setText("8");
				isDefaultZero = false;
			}
			else{
				output.setText(output.getText() + "8");
			}
		}//end method actionPerformed8
		
		// Event Listener on Button.onAction
		@FXML
		public void actionPerformed9(ActionEvent event) {
			//if current value contains 0, replace it with this input
			if(isDefaultZero == true)
			{
				output.setText("9");
				isDefaultZero = false;
			}
			else{
				output.setText(output.getText() + "9");
			}
		}//end method actionPerformed9
		
	// Event Listener on Button.onAction
	@FXML
	public void actionPerformedMulti(ActionEvent event) {
		result = Double.parseDouble(output.getText());  //convert number in textfield to double for calculations
		holdString = output.getText(); //hold current input and show it in current operations label, currOPlbl
		operation.setText(holdString);
		operation.setText(operation.getText() + " *");
		output.setText("0");
		isDefaultZero = true; //Default back to 0 so user can input any num value to replace it, including 0
		OperationType = "multi";  //Operation type is set to multiply, the code below does the actual calculation
	} //end method actionPerformedMulti
	
	// Event Listener on Button.onAction
	@FXML
	public void actionPerformedMinus(ActionEvent event) {
		result = Double.parseDouble(output.getText()); //convert number in textfield to double for calculations
		holdString = output.getText(); //hold current input and show it in current operations label, currOPlbl
		operation.setText(holdString);
		operation.setText(operation.getText() + " -");
		output.setText("0");
		isDefaultZero = true;//Default back to 0 so user can input any num value to replace it, including 0
		OperationType = "sub"; //Operation type is set to subtract, the code below does the actual calculation
	}//end method actionPerformedMinus
	
	// Event Listener on Button.onAction
	@FXML
	public void actionPerformedDecim(ActionEvent event) {
		//if a . does not showing up in the output text (from previous arithmetic operations), then user can input a .
		if(!output.getText().contains(".")){
			output.setText(output.getText() + ".");
			isDefaultZero = false;
		}
	}//end method actionPerformedDecim
	
	// Event Listener on Button.onAction
	@FXML
	public void actionPerformedEqual(ActionEvent event) {
		//If operation type is addition, add value from result then output it
		if(OperationType.equals("add")){
			//df.format allows us to prevent outputting scientific notation
			result = result + Double.parseDouble(output.getText());
			output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
			OperationType = "";
			operation.setText("");
			isDefaultZero = true;
		}
		//If operation type is subtraction, subtract value from result then output it
		else if(OperationType.equals("sub")){
			result = result - Double.parseDouble(output.getText());
			output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
			OperationType = "";
			operation.setText("");
			isDefaultZero = true;
		}
		//If operation type is multiplication, multiply value from result then output it
		else if(OperationType.equals("multi")){
			result = result * Double.parseDouble(output.getText());
			output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
			OperationType = "";
			operation.setText("");
			isDefaultZero = true;
		}
		//If operation type is division, divide value from result then output it
		else if(OperationType.equals("divi")){
			result = result / Double.parseDouble(output.getText());
			output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
			OperationType = "";
			operation.setText("");
			isDefaultZero = true;
		}
		//If operation type is power, output power of a value based on the input from the user
		else if(OperationType.equals("pow")){
			result = Math.pow(result, Double.parseDouble(output.getText()));
			output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
			OperationType = "";
			operation.setText("");
			isDefaultZero = true;
		}
	}//end method actionPerformedEqual
	
	// Event Listener on Button.onAction
	@FXML
	public void actionPerformedPlus(ActionEvent event) {
		result = Double.parseDouble(output.getText()); //convert number in textfield to double for calculations
		holdString = output.getText();//hold current input and show it in current operations label, currOPlbl
		operation.setText(holdString);
		operation.setText(operation.getText() + " +");
		output.setText("0");
		isDefaultZero = true; //Default back to 0 so user can input any num value to replace it, including 0
		OperationType = "add"; //Operation type is set to add, the code below does the actual calculation
	}//end method actionPerformedPlus
	
}// end class CalculatorJavaFXController
