package application2;

public class EmployeeTest 
{

		public static void main(String[] args) 
		{
			//object creation and initialization
			Employee employ1 = new Employee( "Bruce", "Wayne", 10000 );
			Employee employ2 = new Employee( "Clark", "Kent", 4000 );
			double raise = 0; //for first test a 0% raise is included
			
			// show the yearly salary for the Employee objects created with no raise
			System.out.println( "With no raise:" );
			System.out.println( employ1.getFName() + " " + employ1.getLName() + " Annual Salary: \n" + employ1.getAnnualSalary(raise) );
			System.out.println( employ2.getFName() + " " + employ2.getLName() + " Annual Salary: \n" + employ2.getAnnualSalary(raise) );
			
			//  show the yearly salary with a 10% raise
			raise = 0.1; //10% in decimal is 0.1
			System.out.println( "\nWith 10% raise:" );
			System.out.println( employ1.getFName() + " " + employ1.getLName() + " Annual Salary: \n" + employ1.getAnnualSalary(raise) );
			System.out.println( employ2.getFName() + " " + employ2.getLName() + " Annual Salary: \n" + employ2.getAnnualSalary(raise) );
		} // end method main

} // end class EmployeeTest
