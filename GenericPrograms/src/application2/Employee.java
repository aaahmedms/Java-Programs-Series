package application2;

public class Employee 
{

	private String fName; // instance variable which contains the first name
	private String lName; // instance variable which contains the last name
	private double mSalary; // instance variable which contains the monthly salary
	
	//constructor which initializes all variables using the parameters passed during object creation
	public Employee (String conFname, String conLname, double conMsalary)
	{
		//initialize all instance variables
		fName = conFname; 
		lName = conLname; 
		mSalary = conMsalary; 
		
		// if the monthly salary is positive, set value, else do not set its value
		conMsalary = (conMsalary < 0) ? 0 : conMsalary;

	} // end constructor
	
	// method created to set the Employee's first name
	public void setFName (String fName)
	{
		this.fName = fName;	
		
	} // end method setFName
	
	// method created to get the Employee's first name
	public String getFName ()
	{
		return fName;
	} // end method getFName
	
	// method created to set the Employee's last name
	public void setLName (String lName)
	{
		this.lName = lName;
	} // end method setLName
	
	// method created to get the Employee's last name
	public String getLName ()
	{
		return lName;
	} // end method getLName
	
	// method created to set the Employee's monthly salary
	public void setMonthSalary (double mSalary)
	{
		this.mSalary = mSalary;	
	} // end method setMonthSalary
	
	// method created to get the Employee's monthly salary
	public double getMonthSalary ()
	{
		return mSalary;
	} // end method getMonthSalary
	
	// method to to get the Employee's annual salary
	public double getAnnualSalary(double raiseRate)
	{
		//Employee's yearly salary with a raise. By default with no raise, the raiseRate should be 0.
		return (mSalary * (raiseRate+1) * 12);
	} // end method getAnnualSalary
	
} // end class Employee
