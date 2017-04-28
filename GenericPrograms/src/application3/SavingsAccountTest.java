package application3;

public class SavingsAccountTest 
{
	//main method begins execution of Java application
	public static void main(String[] args) 
	{
		SavingsAccount saver1 = new SavingsAccount(2000.00);   //instantiate savingsAccount object 1
		SavingsAccount saver2 = new SavingsAccount(3000.00);  //instantiate savingsAccount object 2
		SavingsAccount.modifyInterestRate(0.04); //set interest rate to 4%
		
		System.out.printf("Interest Rate = %.0f%%\nSaver1 Balance = %.2f\nSaver2 Balance = %.2f\n\n",SavingsAccount.getAnnualInterestRate()*100,saver1.withInterestAdded(),saver2.withInterestAdded());

        SavingsAccount.modifyInterestRate(0.05); //set interest rate to 5%

        System.out.printf("Interest Rate = %.0f%%\nSaver1 Balance = %.2f\nSaver2 Balance = %.2f\n\n",SavingsAccount.getAnnualInterestRate()*100,saver1.withInterestAdded(),saver2.withInterestAdded());

	} // end method main

} // end class SavingsAccountTest
