package application;

public class InterestRateCalculatorFunc 
{
	static private double annualInterestRate;  //instance static variable which contains yearly interest rate
	private double initialBalance; // instance variable which contains savings balance
	
	//constructor which initializes all variables using the parameters passed during object creation
	public InterestRateCalculatorFunc (double conSavingsBalance)
	{
		//initialize all instance variables
		initialBalance = conSavingsBalance;
	} // end constructor
	
	// method created to calculate the monthly interest on an account
	public double calculateMonthlyInterest ()
	{
		return (initialBalance*annualInterestRate/12);
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
		return initialBalance; 
	} // end method getSavingsBalance
	
	// method created to set the Savings account balance
	public void setSavingsBalance(double newValue)
	{
		initialBalance = newValue; 
	} // end method setSavingsBalance
	
	// method created to get the savings balance with interest
	public double getBalanceWithInterestAdded()
	{
		return getSavingsBalance()+calculateMonthlyInterest();
	} // end method getBalanceWithInterestAdded
	
	// method created to get the annual simple interest
	public double getYearlySimpleInterest()
	{
		return (getSavingsBalance()+calculateMonthlyInterest())*12;
	} // end method yearlySimpleInterest
	
	// method created to get the annual compound interest
	public double getYearlycompountInterest()
	{
		double compoundSum = 0;
		for(int i = 0; i < 12; i++){
			compoundSum = compoundSum + (getSavingsBalance()+(calculateMonthlyInterest()+(calculateMonthlyInterest()*1+annualInterestRate)));
		}
		return compoundSum;
	} // end method yearlySimpleInterest

	
} // end class SavingsAccount
 