package application1;

/* -------------------------------- Problem 1 -------------------------------- */

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class lambdaOne {
	private static JFrame frame;
	
	public static void main(String[] args) {
	//for single lined lambdas, return and curly braces are not required but have been included for readability
		productLambda product = (double a, double b) -> {return a * b;}; //problem (a) explicitly list the type for parameters
		productLambda product2 = (a, b) -> {return a * b;}; //problem (b) do no list the type of each parameter
		productLambda product3 =  (a, b) ->  a * b; //problem (c) value is implicitly returned
		printMessage messge = () -> {return "Welcome to lambdas!";}; //problem (d) no argument lambda that returns a string
		
		//output
		System.out.println("a) " + product.foo(3,4));
		System.out.println("b) " + product2.foo(2,3));
		System.out.println("c) " + product3.foo(3,3));
		System.out.println("d) " + messge.foo());
		
		//problem (e) A constructor reference for ArrayList
		Factory<ArrayList<String>> f1 = ArrayList<String>::new;
	    System.out.println("e) Value stored in constructor reference to arraylist: " + f1.toString());

		//Problem (f) Reimplement button using a lambda as the event handler
	    System.out.println("f)Opening swing gui to test lambda expression handling for buttons..");
	    
	    //Create a jframe to hold the jbutton
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Lambda Button");
		
		//create a jbutton to test the lambda expression
		JButton btnNewButton = new JButton("test lambda");
		btnNewButton.addActionListener(e -> JOptionPane.showMessageDialog (null," Lambda button pressed.."));
		btnNewButton.setBounds(160, 120, 120, 40);
		frame.getContentPane().add(btnNewButton);

	}//end method main

}//end class lambdaOne

//Interfaces used for lambda expressions
interface Factory<T> { T make(); }

interface productLambda {
	double foo(double a, double b);
}

interface printMessage {
	String foo();
}