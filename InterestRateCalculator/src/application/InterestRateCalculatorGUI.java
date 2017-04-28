package application;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//An interest rate calculator

public class InterestRateCalculatorGUI {

	//Objects for the GUI
	private JFrame frame;
	private JTextField balance1; //textfield that holds the balance for saver1 that the user has inputted
	private JTextField rateInput; //textfield that takes the interest rate inputted by the user 
	private JTextArea logAS; //text area that shows all the users operations on the account
	private JRadioButton rdbtnSimpleInterest; //button used to set the calculator to calculate simple interest
	private JRadioButton rdbtnCompoundInterest; //button used to set the calculator to calculate compound interest
	
	private int isCompoundOrSimple; //flag to determine if user selected simple (integer 0) or compound interest (integer 1)
	
	
	/**
	 * Main method to start the Java application
	 */
	public static void main(String[] args) {
		InterestRateCalculatorFunc saver1 = new InterestRateCalculatorFunc(4000); // create InterestCalculator object
		InterestRateCalculatorFunc.modifyInterestRate(4); //set interest rate to default to 4%
		InterestRateCalculatorGUI window = new InterestRateCalculatorGUI(saver1);
		window.frame.setVisible(true);
	}// end method main

	/**
	 * Constructor, Creates GUI
	 */
	public InterestRateCalculatorGUI(InterestRateCalculatorFunc saver1) {
		initialize(saver1); //setup GUI
		logAS.setText("Program initialized.");
		rdbtnSimpleInterest.setSelected(true);
		isCompoundOrSimple = 0; //set default to simple interest
		balance1.setText(String.valueOf(saver1.getSavingsBalance()));
		rateInput.setText(String.valueOf(InterestRateCalculatorFunc.getAnnualInterestRate()));
	} // end constructor

	/**
	 * Initialize frame and its components
	 */
	private void initialize(InterestRateCalculatorFunc saver1) {
		//initialize frame
		frame = new JFrame();
		frame.setBounds(100, 100, 713, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setTitle("Simple and Compound Interest Calculator");
		
		//field for user input to hold the balance
		balance1 = new JTextField();
		balance1.setBounds(238, 50, 190, 20);
		balance1.setColumns(10);
		
		//field for user input to input the interest rate 
		rateInput = new JTextField();
		rateInput.setBounds(238, 81, 190, 20);
		rateInput.setColumns(10);
		
		//label is used for visual aesthetics to show text only, it contains the string Annual Interest Rate 
		JLabel lblNewLabel = new JLabel("Annual Interest Rate");
		lblNewLabel.setBounds(82, 82, 146, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		//label is used for visual aesthetics to show text only, it contains the string Initial Balance
		JLabel lblInitialBalance = new JLabel("Initial Balance");
		lblInitialBalance.setBounds(82, 51, 146, 14);
		lblInitialBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblInitialBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		//Radio button used to set the calculator to calculate simple interest. The button sets the interest flag to 0
		rdbtnSimpleInterest = new JRadioButton("Simple Interest");
		rdbtnSimpleInterest.setBounds(271, 108, 146, 23);
		rdbtnSimpleInterest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCompoundInterest.setSelected(false);
				isCompoundOrSimple = 0;
			}// end method actionPerformed
		}); // end action listener
		
		//Radio button used to set the calculator to calculate compound interest. The button sets the interest flag to 1
		rdbtnCompoundInterest = new JRadioButton("Compound Interest");
		rdbtnCompoundInterest.setBounds(271, 141, 157, 23);
		rdbtnCompoundInterest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSimpleInterest.setSelected(false);
				isCompoundOrSimple = 1;
			}// end method actionPerformed
		}); // end action listener
		
		
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
				//All calculations are posted onto a JTextArea for the user to see as the output
				saver1.setSavingsBalance(Double.parseDouble(balance1.getText()));
				InterestRateCalculatorFunc.modifyInterestRate(Double.parseDouble(rateInput.getText())/100); //set interest rate to user input in %
				if(isCompoundOrSimple == 0){
					logAS.setText(logAS.getText() + "\nInterest Rate = " + InterestRateCalculatorFunc.getAnnualInterestRate()*100 
						+ "%\nUser Initial Balance = $" + saver1.getSavingsBalance()
						+ "\nUser Monthly Balance with simple interest = $" + saver1.getBalanceWithInterestAdded()
						+ "\nUser Annual Balance with simple interest = $" + saver1.getYearlySimpleInterest()
						);
				}
				else{
					logAS.setText(logAS.getText() + "\nInterest Rate = " + InterestRateCalculatorFunc.getAnnualInterestRate()*100 
							+ "%\nUser Initial Balance = $" + saver1.getSavingsBalance()
							+ "\nUser Monthly Balance with compound interest = $" + saver1.getBalanceWithInterestAdded()
							+ "\nUser Annual Balance with compound interest = $" + saver1.getYearlycompountInterest()
							);
				}
			}catch(Exception e1){
				//if user does not input a number then error is shown and caught. JOptionPanes pops up error message
				JOptionPane.showMessageDialog(frame, "Please enter valid Input. (Integer or Double)","Error", JOptionPane.ERROR_MESSAGE);
			} //end catch
		 }// end method actionPerformed
	});  // end action listener
		btnNewButton.setBounds(271, 196, 89, 23);
		
		//label is used for visual aesthetics to show text only, it contains the string %
		JLabel label = new JLabel("%");
		label.setBounds(430, 81, 26, 20);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		//add all components to frame
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(balance1);
		frame.getContentPane().add(rateInput);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(lblInitialBalance);
		frame.getContentPane().add(rdbtnSimpleInterest);
		frame.getContentPane().add(rdbtnCompoundInterest);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(label);
		
		//displays users interaction with the program and shows modifications on the account have an operation is done
		logAS = new JTextArea();
		logAS.setEditable(false);
		logAS.setBounds(30, 249, 652, 161);
		
		//creates a scrollable JTextarea so user can see all operations that they have done
		JScrollPane  scrollBar = new JScrollPane(logAS);
		scrollBar.setBounds(30, 249, 652, 161);
		frame.getContentPane().add(scrollBar);
		
		//label is used for visual aesthetics to show text only, it contains the string Output:
		JLabel label_1 = new JLabel("Output:");
		label_1.setBounds(30, 229, 89, 14);
		frame.getContentPane().add(label_1);
	}
}
