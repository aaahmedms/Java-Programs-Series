package application4;

/*
 * A program that finds the product of a variable length list.
 */

public class ProductVarLength 
{

	public static void main(String[] args) 
	{ 
		/*regular number variables used as input for the product function to
		test variable length argument list.*/
		int num1 = 5;
		int num2 = 3;
		int num3 = 7;
		
		int productNum = productVariLength(num1); 
		System.out.println(num1 + " = " + productNum); 
		
		int productNum1 = productVariLength(num1, num2); 
		System.out.println("\n" + num1 + "*" + num2 + " = " + productNum1); 
		 
		int productNum2 = productVariLength(num1, num2, num3); 
		System.out.println("\n" + num1 + "*" + num2 + "*" + num3 + " = " + productNum2); 
		
	} // end method main

	/*A method that calculates the product of a series of integers that are passed to method 
	 product using a variable-length argument list. */
	public static int productVariLength(int ... num) 
	{
		int result = 1; //A variable that holds the final result
		
		//enhanced for loop that sets x to the values inputed from the arguments
		for(int x:num)
		{ 
			result *= x;
		}// end enhanced for loop
		
		return result;
	}// end method productVariLength

} // end class ProductVarLength
