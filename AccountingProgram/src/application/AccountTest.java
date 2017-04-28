package application;

import java.util.Scanner;

/*
 * Modified version of the example class AccountTest provided from assignment 1 problem 1 to 
 * demonstrate method debit, which withdraws money from the Account.
 */

//Inputting and outputting floating-point numbers with Account objects.

public class AccountTest 
{
		//main method begins execution of Java application
		public static void main(String[] args) 
		{
			Account account1 = new Account( 50.00 ); // create Account object
			Account account2 = new Account( -7.53 ); // create Account object
			
			// display initial balance of each object
			System.out.printf( "account1 balance: $%.2f\n", account1.getBalance() );
			System.out.printf( "account2 balance: $%.2f\n\n", account2.getBalance() );
			
			// create Scanner to obtain input from command window
			Scanner input = new Scanner ( System.in );
			double depositAmount; // deposit amount read from user
			
			System.out.print( "Enter amount to debit for account1: " ); // prompt
			depositAmount = input.nextDouble(); // obtain user input
			System.out.printf("subtracting %.2f to account1 balance\n\n", depositAmount );
			account1.debit(depositAmount); // deduct from account1 balance
			
			// display balances
			System.out.printf( "account1 balance: $%.2f\n", account1.getBalance() );
			System.out.printf( "account2 balance: $%.2f\n\n", account2.getBalance() );
			
			System.out.print( "Enter amount to debit for account2: "); // prompt
			depositAmount = input.nextDouble(); // obtain user input
			System.out.printf( "\nsubtracting %.2f from account2 balance\n\n", depositAmount );
			account2.debit( depositAmount ); //deduct from account2 balance
			
			// display balances
			System.out.printf( "account1 balance: $%.2f\n", account1.getBalance() );
			System.out.printf( "account2 balance: $%.2f\n", account2.getBalance() );
			
			//close input
			input.close();
			
		} // end main
	
} // end class AccountTest
