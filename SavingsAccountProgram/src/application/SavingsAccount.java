package application;

public class SavingsAccount 
{
	static private double annualInterestRate;  //instance static variable which contains yearly interest rate
	private double savingsBalance; // instance variable which contains savings balance
	
	//constructor which initializes all variables using the parameters passed during object creation
	public SavingsAccount (double conSavingsBalance)
	{
		//initialize all instance variables
		savingsBalance = conSavingsBalance;
	} // end constructor
	
	// method created to calculate the monthly interest on an account
	public double calculateMonthlyInterest ()
	{
		return (savingsBalance*annualInterestRate/12);
	} // end method calculateMonthlyInterest
	
	 //static method that sets the annual interest rate to a new value
	 public static void modifyInterestRate(double newValue)    
	 {
	     annualInterestRate = newValue;            
	 } // end method modifyInterestRate
	 
	// method created to get the annual interest rate
	public static double getAnnualInterestRate()
	{
		return annualInterestRate; 
	} // end method getAnnualInterestRate
	 
	// method created to get the Savings account balance
	public double getSavingsBalance()
	{
		return savingsBalance; 
	} // end method getSavingsBalance
	
	// method created to set the Savings account balance
	public void setSavingsBalance(double newValue)
	{
		savingsBalance = newValue; 
	} // end method setSavingsBalance
	
	// method created to get the savings balance with interest
	public double withInterestAdded()
	{
		return getSavingsBalance()+calculateMonthlyInterest();
	} // end method withInterestAdded

	
} // end class SavingsAccount
 