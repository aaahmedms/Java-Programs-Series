package application;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SavingsAccountGUI {
	
	//Objects for the GUI
	private JFrame frame;
	private JTextField balance1; //textfield that holds the balance for saver1 that the user has inputted
	private JTextField balance2; //textfield that holds the balance for saver2 that the user has inputted
	private JTextField rateInput; //textfield that takes the interest rate inputted by the user 
	private JLabel b1lbl; //balance1 label, aesthetic use only
	private JLabel b1lbl2; //balance2 label, aesthetic use only
	private JLabel lblInterestRate; //interest rate label, aesthetic use only
	private JLabel percentaglbl; //percentage label, aesthetic use only
	private JLabel outplbl; //output label, aesthetic use only
	private JLabel lblSaver1; //saver1 label, aesthetic use only
	private JLabel lblSaver2; //saver2 label, aesthetic use only
	private JLabel msgLbl; //Program instruction label, aesthetic use only
	private JButton btnSubmit; //button that is used to submit the users value inputted in the text fields
	private JTextArea logAS; //text area that shows all the users operations on the account


	/**
	 * Main method to start the Java application
	 */
	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount(2000); // create Account object
		SavingsAccount saver2 = new SavingsAccount(3000); // create Account object
		SavingsAccount.modifyInterestRate(0.04); //set interest rate to 4%
		SavingsAccountGUI window = new SavingsAccountGUI(saver1,saver2);
		window.frame.setVisible(true);
	}// end method main

	/**
	 * Constructor, Creates GUI
	 */
	public SavingsAccountGUI(SavingsAccount saver1,SavingsAccount saver2) {
		initialize(saver1,saver2); //setup GUI
	} // end constructor

	/**
	 * Initialize frame and its components
	 */
	private void initialize(SavingsAccount saver1,SavingsAccount saver2) {
		//initialize frame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Savings Account Program");
		frame.setResizable(true);
		
		//field for user input to hold the balance of saver1
		balance1 = new JTextField();
		balance1.setBounds(101, 66, 114, 20);
		balance1.setColumns(10);
		balance1.setText(String.valueOf(saver1.getSavingsBalance()));
		frame.getContentPane().add(balance1);
		
		//field for user input to hold the balance of saver2
		balance2 = new JTextField();
		balance2.setText("0.0");
		balance2.setColumns(10);
		balance2.setBounds(305, 66, 114, 20);
		balance2.setText(String.valueOf(saver2.getSavingsBalance()));
		frame.getContentPane().add(balance2);
		
		//field for user input to input the interest rate 
		rateInput = new JTextField();
		rateInput.setBounds(144, 125, 114, 20);
		rateInput.setColumns(10);
		rateInput.setText(String.valueOf(SavingsAccount.getAnnualInterestRate()*100));
		frame.getContentPane().add(rateInput);
		
		//label is used for visual aesthetics to show text only, it contains the string Balance: $ 
		b1lbl = new JLabel("Balance: $");
		b1lbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		b1lbl.setBounds(25, 64, 77, 20);
		frame.getContentPane().add(b1lbl);
		
		//label is used for visual aesthetics to show text only, it contains the string Interest Rate:
		lblInterestRate = new JLabel("Interest Rate:");
		lblInterestRate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInterestRate.setBounds(154, 105, 104, 20);
		frame.getContentPane().add(lblInterestRate);
		
		//label is used for visual aesthetics to show text only, it contains a string which shows the instructions
		msgLbl = new JLabel("Input the balance and the the interest rate, then press submit.");
		msgLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		msgLbl.setBounds(25, 0, 392, 33);
		frame.getContentPane().add(msgLbl);
		
		//Submit button which performs the action of calculating the balance with annual interest added
		btnSubmit = new JButton("Calculate");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
				//All calculations are posted onto a JTextArea for the user to see as the output
				saver1.setSavingsBalance(Double.parseDouble(balance1.getText()));
				saver2.setSavingsBalance(Double.parseDouble(balance2.getText()));
				SavingsAccount.modifyInterestRate(Double.parseDouble(rateInput.getText())/100); //set interest rate to user input in %
				logAS.setText(logAS.getText() + "Interest Rate = " + SavingsAccount.getAnnualInterestRate()*100 + "%\nSaver1 Balance = " + saver1.withInterestAdded() + "\nSaver2 Balance = " + saver2.withInterestAdded() + "\n");
			}catch(Exception e1){
				//if user does not input a number then error is shown and caught. JOptionPanes pops up error message
				JOptionPane.showMessageDialog(frame, "Please enter valid Input. (Integer or Double)","Error", JOptionPane.ERROR_MESSAGE);
			} //end catch
		 }// end method actionPerformed
	});  // end action listener
		btnSubmit.setBounds(162, 148, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		//label is used for visual aesthetics to show text only, it contains the string Output:
		outplbl = new JLabel("Output:");
		outplbl.setBounds(25, 171, 89, 14);
		frame.getContentPane().add(outplbl);
		
		//label is used for visual aesthetics to show text only, it contains the string Balance:
		b1lbl2 = new JLabel("Balance: $");
		b1lbl2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		b1lbl2.setBounds(230, 66, 77, 20);
		frame.getContentPane().add(b1lbl2);
		
		//label is used for visual aesthetics to show text only, it contains the string Saver1
		lblSaver1 = new JLabel("Saver1");
		lblSaver1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSaver1.setBounds(32, 35, 59, 20);
		frame.getContentPane().add(lblSaver1);
		
		//label is used for visual aesthetics to show text only, it contains the string Saver2
		lblSaver2 = new JLabel("Saver2");
		lblSaver2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSaver2.setBounds(236, 35, 59, 20);
		frame.getContentPane().add(lblSaver2);
		
		//label is used for visual aesthetics to show text only, it contains the string %
		percentaglbl = new JLabel("%");
		percentaglbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		percentaglbl.setBounds(261, 125, 26, 20);
		frame.getContentPane().add(percentaglbl);
		
		//displays users interaction with the program and shows modifications on the account have an operation is done
		logAS = new JTextArea();
		logAS.setEditable(false);
		logAS.setBounds(30, 185, 377, 74);
		
		//creates a scrollable JTextarea so user can see all operations that they have done
		JScrollPane  scrollBar = new JScrollPane(logAS);
		scrollBar.setBounds(30, 185, 377, 74);
		frame.getContentPane().add(scrollBar);
	}// end method initialize

}// end class AccountGUI
