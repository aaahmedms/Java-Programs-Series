package application;

/*
 * Modified version of the example class Account provided from assignment 1 problem 1 to 
 * include method debit, which withdraws money from the Account.
 */

//Account class with a constructor to validate and
//initialize instance variable of balance type double

public class Account
{
	private double balance;	// instance variable that stores the balance
	private String isExceed;
	
		// constructor
		public Account ( double initialBalance ) 
		{
			// validate that initialBalance is greater than 0.0;
			// if it is not, balance is initialized to the default value 0.0
			if ( initialBalance > 0.0 )
				balance = initialBalance;
			
		} // end Account constructor
		
		
		// credit (add) an amount to the account
		public void credit( double amount )
		{
			balance = balance + amount;	// add amount to balance
		} // end method credit
		
		// debit method which allows withdrawal from the account
		public void debit( double amount )
		{
			// amount debited cannot exceed the Accounts balance, if it does, balance is left unchanged
			if(amount <= balance || amount == 0){
				//amount is kept the same
				isExceed = "";
			}
			else{
				//because the amount debited is greater then the balance, it has exceeded the balance,print message
				amount = 0;
				isExceed = "Debit amount exceeded account balance.\n";
			}
			
			
		
			balance -= amount;
		} // end method debit
		
		// return the account balance
		public double getBalance()
		{
			return balance; // gives the value of balance to the calling method
		} // end method getBalance
		
		// return string if debit amount exceeds account balance
		public String getProblem()
		{
			return isExceed; // gives the value of balance to the calling method
		} // end method getBalance
		
}//end class Account
