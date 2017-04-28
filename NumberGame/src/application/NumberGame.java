package application;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

//A number game using Swing

public class NumberGame {
	
	//Objects for the GUI
	private JFrame frame;
	private JTextField userInput; //textfield that holds the users input
	private JLabel highOrlowLabel; //label used to show if user input value is too high or too low from random number
	private JLabel lblCorrect; //label that appears if user guesses correct number
	private JButton btnRestart; //button that restarts the game
	private JButton submitValBtn;  //button that is used to submit the users value inputted in text field
	private int inputNum; //user input value
	private int max; //maximum value for random number generator
	private int min; //minimum value for random number generator
	private int randomNum; //the random value
	
	/**
	 * Main method to start the Java application
	 */
	public static void main(String[] args) {
			NumberGame window = new NumberGame();
			window.frame.setVisible(true);
	} //end method main

	/**
	 * Constructor, Creates GUI
	 */
	public NumberGame() {
		initialize(); //setup GUI
		startGame(); //method used to start the game
	} // end constructor

	/**
	 * Initialize frame and its components
	 */
	private void initialize() {
		//initialize frame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Guessing Game");
		frame.setResizable(true);
		
		//Text field created to allow user input
		userInput = new JTextField();
		userInput.setBounds(115, 132, 155, 20);
		frame.getContentPane().add(userInput);
		userInput.setColumns(10);
		
		//label is used for visual aesthetics to show text only, it contains the string Input Guess: 
		JLabel lblInputGuess = new JLabel("Input Guess:");
		lblInputGuess.setBounds(40, 135, 71, 14);
		frame.getContentPane().add(lblInputGuess);
		
		//label is used for visual aesthetics to show text only, it contains a string that holds a message specified 
		JLabel lblIn = new JLabel("<html> I have a number between 1 and 1000. Can you guess my number ? </html>");
		lblIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIn.setBounds(56, 65, 331, 55);
		frame.getContentPane().add(lblIn);
		
		//This label shows whether the users guess is too high or too low
		highOrlowLabel = new JLabel("HighOrLow");
		highOrlowLabel.setHorizontalAlignment(SwingConstants.CENTER);
		highOrlowLabel.setBounds(161, 163, 78, 14);
		frame.getContentPane().add(highOrlowLabel);
		
		//if the user makes the correct guess, the text on this JLabel is set to CORRECT!
		lblCorrect = new JLabel("Correct!");
		lblCorrect.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorrect.setForeground(new Color(154, 205, 50));
		lblCorrect.setBounds(243, 95, 71, 14);
		frame.getContentPane().add(lblCorrect);
		
		//Restarts the game by calling the startGame() method
		btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGame();
			}// end method actionPerformed
		});// end action listener
		btnRestart.setBounds(21, 217, 89, 23);
		frame.getContentPane().add(btnRestart);
		
		//The user input which submits the value the user has guessed between 1 and 1000
		submitValBtn = new JButton("Submit");
		submitValBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
				inputNum = Integer.parseInt(userInput.getText()); //convert users string response to an Integer
				
				//if users guess is too high set background color of frame to red
				if(inputNum > randomNum){
					highOrlowLabel.setText("Too High");
					frame.getContentPane().setBackground(Color.RED);
				}
				//if users guess is too low set background color of frame to blue
				else if (inputNum < randomNum){
					highOrlowLabel.setText("Too Low");
					frame.getContentPane().setBackground(Color.BLUE);
				}
				/*if users guesses correctly set text on the correct label to CORRECT! and end game, 
				 *until user clicks restart
				 */
				else{
					highOrlowLabel.setText("");
					lblCorrect.setText("Correct!");
					userInput.setEnabled(false);
					submitValBtn.setEnabled(false);
					btnRestart.setEnabled(true);
					frame.getContentPane().setBackground(Color.WHITE);
				}
				
			} catch(Exception e1){
				//if user does not input a number then error is shown and caught. JOptionPanes pops up error message
				JOptionPane.showMessageDialog(frame, "Please enter valid Input. (Integer)","Error", JOptionPane.ERROR_MESSAGE);
			} //end catch
		 } // end method actionPerformed
		}); // end action listener
		submitValBtn.setBounds(275, 131, 95, 23);
		frame.getContentPane().add(submitValBtn);
	}  // end method initialize
	
	private void startGame() {
		//random number generator
				max = 1000;
				min = 1;
				randomNum = (int )(Math.random() * max + min);
		//Set all buttons and text back to Default settings to when user started the game
				highOrlowLabel.setText("");
				lblCorrect.setText("");
				userInput.setEnabled(true);
				submitValBtn.setEnabled(true);
				btnRestart.setEnabled(false);
	}  // end method startGame
}// end class NumberGame
