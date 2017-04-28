package application;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AccountGUI {

	//Objects for the GUI
	private JFrame frame;
	private JTextField debitField; //textfield that holds the debit value the user would like to input
	private JTextField creditField; //textfield that holds the credit value the user would like to input
	private JTextArea logBox; //text area that shows all the users operations on the account
	private JLabel showbalanLBL; //label that shows the balance of the user
	
	/**
	 * Main method to start the Java application
	 */
	public static void main(String[] args) {
		//object creation of Account and initialization of the GUI
		Account account1 = new Account(50.00); // create Account object
		AccountGUI window = new AccountGUI(account1);
		window.frame.setVisible(true);
	} // end method main

	/**
	 * Constructor, Creates GUI
	 */
	public AccountGUI(Account account) {
		initialize(account); //setup GUI
		logBox.setText(logBox.getText() + "account balance: $" + account.getBalance() + "\n"); //show starting balance in operations window
	}  // end constructor

	/**
	 * Initialize frame and its components
	 */
	private void initialize(Account account) {
		//initialize frame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Accounting Program");
		frame.setResizable(true);
		
		//Debit button which performs the action of debiting the account
		JButton btnDebit = new JButton("Debit");
		btnDebit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					//All transaction operations related to debiting is posted onto a JTextArea for the user to see
					logBox.setText(logBox.getText() + "subtracting " + Double.parseDouble(debitField.getText()) + " to account balance\n");
					account.debit(Double.parseDouble(debitField.getText()));
					logBox.setText(logBox.getText() + "account balance: " + account.getBalance() + "\n");
					showbalanLBL.setText("Balance: " + account.getBalance()); //update balance label on the top of GUI
					logBox.setText(logBox.getText() + account.getProblem()); 
					//if debit exceed string is returned, then pop up exceeded balance message
					if(account.getProblem().length() > 0){
						JOptionPane.showMessageDialog(frame, "Debit amount exceeded account balance.");
					}
				} //end try
				catch(Exception e1){
					//if user does not input a number then error is shown and caught. JOptionPanes pops up error message
					JOptionPane.showMessageDialog(frame, "Please enter valid Input. (Integer or Double)","Error", JOptionPane.ERROR_MESSAGE);
				} //end catch
			} // end method actionPerformed
		}); // end action listener
		btnDebit.setBounds(278, 55, 89, 23);
		frame.getContentPane().add(btnDebit);
		
		//Credit button which performs the action of crediting the account
		JButton btnCredit = new JButton("Credit");
		btnCredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					//All transaction operations related to crediting is posted onto a JTextArea for the user to see as the output
					logBox.setText(logBox.getText() + "Adding " + Double.parseDouble(creditField.getText()) + " to account balance\n");
					account.credit(Double.parseDouble(creditField.getText()));
					logBox.setText(logBox.getText() + "account balance: " + account.getBalance() + "\n");
					showbalanLBL.setText("Balance: " + account.getBalance()); //update balance label on the top of GUI
				}catch(Exception e1){
					//if user does not input a number then error is shown and caught. JOptionPanes pops up error message
					JOptionPane.showMessageDialog(frame, "Please enter valid Input. (Integer or Double)","Error", JOptionPane.ERROR_MESSAGE);
				} //end catch
			} // end method actionPerformed
		});  // end action listener
		btnCredit.setBounds(278, 89, 89, 23);
		frame.getContentPane().add(btnCredit);
		
		//field for user input for debiting the account
		debitField = new JTextField("0");
		debitField.setBounds(89, 58, 179, 20);
		frame.getContentPane().add(debitField);
		debitField.setColumns(10);
		

		//field for user input for crediting the account
		creditField = new JTextField("0");
		creditField.setColumns(10);
		creditField.setBounds(89, 90, 179, 20);
		frame.getContentPane().add(creditField);
		
		//label is used for visual aesthetics to show text only, it contains the string Amount 
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(33, 59, 46, 14);
		frame.getContentPane().add(lblAmount);
		
		//label is used for visual aesthetics to show text only, it contains the string Amount
		JLabel label = new JLabel("Amount");
		label.setBounds(33, 93, 46, 14);
		frame.getContentPane().add(label);
		
		//shows users balance on top of GUI
		showbalanLBL = new JLabel("Balance:");
		showbalanLBL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		showbalanLBL.setBounds(23, 21, 380, 23);
		showbalanLBL.setText("Balance: " + Double.toString(account.getBalance()));
		frame.getContentPane().add(showbalanLBL);
		
		//displays users interaction with the program and shows modifications on the account have an operation is done
		logBox = new JTextArea();
		logBox.setEditable(false);
		logBox.setBounds(23, 156, 377, 95);
		logBox.setColumns(10);
		
		//creates a scrollable JTextarea so user can see all operations that they have done
		JScrollPane  scrollBar = new JScrollPane(logBox);
		scrollBar.setBounds(23, 156, 377, 95);
		frame.getContentPane().add(scrollBar);
		
		//label is used for visual aesthetics to show text only, it contains the string Operations
		JLabel lblOperations = new JLabel("Operations:");
		lblOperations.setBounds(23, 131, 89, 14);
		frame.getContentPane().add(lblOperations);
	}  // end method initialize
} // end class AccountGUI
