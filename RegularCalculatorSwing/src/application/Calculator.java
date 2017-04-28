package application;

/*
 Objective:  A calculator application that utilizes the java GUI Libraries
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class Calculator {
	//Objects for the GUI
	private JFrame frame;
	private JTextField output; //The display used to show the result after an arithmetic operation
	private String holdString; //temporarily stores the operation and displays it to the user in the history label
	private Double result; //holds the final result after an arithmetic operation and is displayed on the JTextField output
	private String OperationType; //specifies the type of arithmetic operation indicated by a string
	private Boolean isDefaultZero; //a flag that checks if default value on output is zero, when any number btn is pressed switch value wit zero
	private DecimalFormat df;
	/**
	 *  Main method to start the Java application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator(); //create the application
					window.frame.setVisible(true); //set the application to visible so it appears on screen
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//end method main

	/**
	 * Constructor, Creates GUI
	 */
	public Calculator() {
		initialize(); //setup GUI
		result = 0.00; //on start of application, the default value is 0
		OperationType = ""; //operation type should be defaulted on start since nothing is happening
		//this is used to prevent scientific notation results during arithmetic operations
		df = new DecimalFormat("#"); 
        df.setMaximumFractionDigits(8);
	}// end constructor

	/**
	 * Initialize frame and its components
	 */
	private void initialize() {
		//initialize frame
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calculator");
		frame.getContentPane().setLayout(null);
		
		//A displays that outputs the result after an operation is done by the user 
		output = new JTextField();
		output.setText("0");
		isDefaultZero = true; //if user enters any value, it replaces zero
		output.setFont(new Font("Tahoma", Font.PLAIN, 14));
		output.setHorizontalAlignment(SwingConstants.RIGHT);
		output.setBounds(10, 34, 364, 26);
		frame.getContentPane().add(output);
		output.setColumns(10);
		
		//This label shows the current operation the user is doing, and is placed above the output textfield
		JLabel currOplbl = new JLabel("");
		currOplbl.setForeground(Color.GRAY);
		currOplbl.setHorizontalAlignment(SwingConstants.RIGHT);
		currOplbl.setBounds(10, 9, 364, 14);
		frame.getContentPane().add(currOplbl);
		
		//Squares the value of the number inserted by the user stored in the jtextfield output
		JButton sqrtBTN = new JButton("Sqrt");
		sqrtBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = Double.parseDouble(output.getText()); //convert number in textfield to double for calculations
				holdString = output.getText(); //hold current input and show it in current operations label, currOPlbl
				currOplbl.setText(holdString);
				String SQR = "\u221A";//sqrt symbol
				currOplbl.setText(SQR + currOplbl.getText() + " ");
				result = Math.sqrt(result);
				output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
				OperationType = ""; //set operation type to nothing
			}// end method actionPerformed
		});// end action listener
		sqrtBTN.setBounds(10, 70, 80, 32);
		frame.getContentPane().add(sqrtBTN);
		
		/*
		 * Sets operation type to power, and takes two inputs, one for the value, the other is inputted 
		* after to get the value of the power
		*/
		JButton powBTN = new JButton("Pow");
		powBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = Double.parseDouble(output.getText()); //convert number in textfield to double for calculations
				holdString = output.getText(); //hold current input and show it in current operations label, currOPlbl
				currOplbl.setText(holdString);
				currOplbl.setText(currOplbl.getText() + " ^");
				output.setText("0");
				isDefaultZero = true; //Default back to 0 so user can input any num value to replace it, including 0
				OperationType = "pow"; //Operation type is set to pow, the code below does the actual calculation
			}// end method actionPerformed
		});// end action listener
		powBTN.setBounds(100, 70, 80, 32);
		frame.getContentPane().add(powBTN);
		
		/*
		 Example scenario of how the percent button does the calculation works:
		 It works similarly to the windows calculators percentage button.
			percent = 5% = 5/100
			
			scenario 1:
			500 * percent
			=500 * 5%
			=500 * 0.05 
			=25
			
			scenario 2:
			2 + 5% = 0.1 <=> 2 * 5% = 0.1
		 */
		JButton modBTN = new JButton("%");
		modBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = result * (Double.parseDouble(output.getText()))/100; //get percentage of value in textfield, then convert to double for calculations
				output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
				OperationType = ""; //set operation type to nothing
				currOplbl.setText(""); 
				isDefaultZero = true; //Default back to 0 so user can input any num value to replace it, including 0
			}// end method actionPerformed
		});// end action listener
		modBTN.setBounds(192, 70, 80, 32);
		frame.getContentPane().add(modBTN);
		
		//Cancel or clears all operations and defaults all variables
		JButton cancelBTN = new JButton("C");
		cancelBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//set calculator back to default state
				result = 0.00;
				holdString = "";
				currOplbl.setText("");
				output.setText("0");
				isDefaultZero = true;
				OperationType = "";
			}// end method actionPerformed
		});// end action listener
		cancelBTN.setBounds(284, 70, 80, 32);
		frame.getContentPane().add(cancelBTN);
		
		/*
		 * Sets operation type to divide, which takes two inputs, one after the other, one for the value,
		 * the other is inputted after to divide with
		*/
		JButton divideBTN = new JButton("/");
		divideBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = Double.parseDouble(output.getText()); //convert number in textfield to double for calculations
				holdString = output.getText(); //hold current input and show it in current operations label, currOPlbl
				currOplbl.setText(holdString);
				currOplbl.setText(currOplbl.getText() + " /");
				output.setText("0"); 
				isDefaultZero = true; //Default back to 0 so user can input any num value to replace it, including 0
				OperationType = "divi"; //Operation type is set to divide, the code below does the actual calculation
			}// end method actionPerformed
		});// end action listener
		divideBTN.setBounds(284, 113, 80, 32);
		frame.getContentPane().add(divideBTN);
		
		//Button that outputs 0 to textfield
		JButton num0 = new JButton("0");
		num0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				output.setText(output.getText() + "0");
			}// end method actionPerformed
		});// end action listener
		num0.setBounds(100, 242, 80, 32);
		frame.getContentPane().add(num0);
		
		
		//Button that outputs 1 to textfield
		JButton num1 = new JButton("1");
		num1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if current value contains 0, replace it with this input
				if(isDefaultZero == true) 
				{
					output.setText("1");
					isDefaultZero = false;
				}
				else{
					output.setText(output.getText() + "1");
				}
			}// end method actionPerformed
		});// end action listener
		num1.setBounds(10, 199, 80, 32);
		frame.getContentPane().add(num1);
		
		//Button that outputs 2 to textfield
		JButton num2 = new JButton("2");
		num2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if current value contains 0, replace it with this input
				if(isDefaultZero == true)
				{
					output.setText("2");
					isDefaultZero = false;
				}
				else{
					output.setText(output.getText() + "2");
				}
			}// end method actionPerformed
		});// end action listener
		num2.setBounds(100, 199, 80, 32);
		frame.getContentPane().add(num2);
		
		//Button that outputs 3 to textfield
		JButton num3 = new JButton("3");
		num3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if current value contains 0, replace it with this input
				if(isDefaultZero == true)
				{
					output.setText("3");
					isDefaultZero = false;
				}
				else{
					output.setText(output.getText() + "3");
				}
			}// end method actionPerformed
		});// end action listener
		num3.setBounds(192, 199, 80, 32);
		frame.getContentPane().add(num3);
		
		//Button that outputs 4 to textfield
		JButton num4 = new JButton("4");
		num4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if current value contains 0, replace it with this input
				if(isDefaultZero == true)
				{
					output.setText("4");
					isDefaultZero = false;
				}
				else{
					output.setText(output.getText() + "4");
				}
			}// end method actionPerformed
		});// end action listener
		num4.setBounds(10, 156, 80, 32);
		frame.getContentPane().add(num4);
		
		//Button that outputs 5 to textfield
		JButton num5 = new JButton("5");
		num5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if current value contains 0, replace it with this input
				if(isDefaultZero == true)
				{
					output.setText("5");
					isDefaultZero = false;
				}
				else{
					output.setText(output.getText() + "5");
				}
			}// end method actionPerformed
		});// end action listener
		num5.setBounds(100, 156, 80, 32);
		frame.getContentPane().add(num5);
		
		//Button that outputs 6 to textfield
		JButton num6 = new JButton("6");
		num6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if current value contains 0, replace it with this input
				if(isDefaultZero == true)
				{
					output.setText("6");
					isDefaultZero = false;
				}
				else{
					output.setText(output.getText() + "6");
				}
			}// end method actionPerformed
		});// end action listener
		num6.setBounds(192, 156, 80, 32);
		frame.getContentPane().add(num6);
		
		//Button that outputs 7 to textfield
		JButton num7 = new JButton("7");
		num7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if current value contains 0, replace it with this input
				if(isDefaultZero == true)
				{
					output.setText("7");
					isDefaultZero = false;
				}
				else{
					output.setText(output.getText() + "7");
				}
			}// end method actionPerformed
		});// end action listener
		num7.setBounds(10, 113, 80, 32);
		frame.getContentPane().add(num7);
		
		//Button that outputs 8 to textfield
		JButton num8 = new JButton("8");
		num8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if current value contains 0, replace it with this input
				if(isDefaultZero == true)
				{
					output.setText("8");
					isDefaultZero = false;
				}
				else{
					output.setText(output.getText() + "8");
				}
			}// end method actionPerformed
		});// end action listener
		num8.setBounds(100, 113, 80, 32);
		frame.getContentPane().add(num8);
		
		//Button that outputs 9 to textfield
		JButton num9 = new JButton("9");
		num9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if current value contains 0, replace it with this input
				if(isDefaultZero == true)
				{
					output.setText("9");
					isDefaultZero = false;
				}
				else{
					output.setText(output.getText() + "9");
				}
			}// end method actionPerformed
		});// end action listener
		num9.setBounds(192, 113, 80, 32);
		frame.getContentPane().add(num9);
		
		//Button that outputs . to textfield, but only one can inputted to prevent awkward number typing
		JButton deciBTN = new JButton(".");
		deciBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if a . does not showing up in the output text (from previous arithmetic operations), then user can input a .
				if(!output.getText().contains(".")){
					output.setText(output.getText() + ".");
					isDefaultZero = false;
				}
			}// end method actionPerformed
		});// end action listener
		deciBTN.setBounds(10, 242, 80, 32);
		frame.getContentPane().add(deciBTN);
		
		/*
		 * Sets operation type to subtraction, which takes two inputs one after the other, one for the value, 
		 * the other is inputted after to subtract with
		*/
		JButton subtBTN = new JButton("-");
		subtBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = Double.parseDouble(output.getText()); //convert number in textfield to double for calculations
				holdString = output.getText(); //hold current input and show it in current operations label, currOPlbl
				currOplbl.setText(holdString);
				currOplbl.setText(currOplbl.getText() + " -");
				output.setText("0");
				isDefaultZero = true;//Default back to 0 so user can input any num value to replace it, including 0
				OperationType = "sub"; //Operation type is set to subtract, the code below does the actual calculation
			}// end method actionPerformed
		});// end action listener
		subtBTN.setBounds(284, 199, 80, 32);
		frame.getContentPane().add(subtBTN);
		
		/*
		 * Sets operation type to addition, which takes two inputs one after the other, one for the value, 
		 * the other is inputted after to subtract with
		*/
		JButton addBTN = new JButton("+");
		addBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = Double.parseDouble(output.getText()); //convert number in textfield to double for calculations
				holdString = output.getText();//hold current input and show it in current operations label, currOPlbl
				currOplbl.setText(holdString);
				currOplbl.setText(currOplbl.getText() + " +");
				output.setText("0");
				isDefaultZero = true; //Default back to 0 so user can input any num value to replace it, including 0
				OperationType = "add"; //Operation type is set to add, the code below does the actual calculation
			}// end method actionPerformed
		});// end action listener
		addBTN.setBounds(284, 242, 80, 32);
		frame.getContentPane().add(addBTN);
		
		
		/*
		 * Sets operation type to multiplication, which takes two inputs one after the other, one for the value, 
		 * the other is inputted after to subtract with
		*/
		JButton multiplyBTN = new JButton("*");
		multiplyBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = Double.parseDouble(output.getText());  //convert number in textfield to double for calculations
				holdString = output.getText(); //hold current input and show it in current operations label, currOPlbl
				currOplbl.setText(holdString);
				currOplbl.setText(currOplbl.getText() + " *");
				output.setText("0");
				isDefaultZero = true; //Default back to 0 so user can input any num value to replace it, including 0
				OperationType = "multi";  //Operation type is set to multiply, the code below does the actual calculation
			}// end method actionPerformed
		});// end action listener
		multiplyBTN.setBounds(284, 156, 80, 32);
		frame.getContentPane().add(multiplyBTN);
		
		//Most arithmitic operations are done here, then outputted on JTextfield output based on the operation type
		JButton equalsBTN = new JButton("=");
		equalsBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//If operation type is addition, add value from result then output it
				if(OperationType.equals("add")){
					//df.format allows us to prevent outputting scientific notation
					result = result + Double.parseDouble(output.getText());
					output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
					OperationType = "";
					currOplbl.setText("");
					isDefaultZero = true;
				}
				//If operation type is subtraction, subtract value from result then output it
				else if(OperationType.equals("sub")){
					result = result - Double.parseDouble(output.getText());
					output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
					OperationType = "";
					currOplbl.setText("");
					isDefaultZero = true;
				}
				//If operation type is multiplication, multiply value from result then output it
				else if(OperationType.equals("multi")){
					result = result * Double.parseDouble(output.getText());
					output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
					OperationType = "";
					currOplbl.setText("");
					isDefaultZero = true;
				}
				//If operation type is division, divide value from result then output it
				else if(OperationType.equals("divi")){
					result = result / Double.parseDouble(output.getText());
					output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
					OperationType = "";
					currOplbl.setText("");
					isDefaultZero = true;
				}
				//If operation type is power, output power of a value based on the input from the user
				else if(OperationType.equals("pow")){
					result = Math.pow(result, Double.parseDouble(output.getText()));
					output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
					OperationType = "";
					currOplbl.setText("");
					isDefaultZero = true;
				}
			}// end method actionPerformed
		});// end action listener
		equalsBTN.setBounds(192, 242, 80, 32);
		frame.getContentPane().add(equalsBTN);
		
		
	}// end method initialize
}// end class Calculator
