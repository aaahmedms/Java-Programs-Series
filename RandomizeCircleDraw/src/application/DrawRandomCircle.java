package application;

/*
Objective:  A program that displays a circle of random size and calculates and displays
 *the area, radius, diameter and circumference.
 */

import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class DrawRandomCircle {
	
	//Objects for the GUI
	private JFrame frame;
	private JTextArea resultsText;
	private static JButton btnRandomize;

	/**
	 * Main method to start the Java application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawRandomCircle window = new DrawRandomCircle(); //create the application
					window.frame.setVisible(true);  //set the application to visible so it appears on screen
					btnRandomize.doClick(); //Initiate a button click on start of program to draw random circle
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}// end method main

	/**
	 * Constructor, Creates GUI
	 */
	public DrawRandomCircle() {
		initialize(); //setup GUI
	}// end constructor

	/**
	 * Initialize frame and its components
	 */
	private void initialize() {
		//initialize frame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("DrawRandomCircle");
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		//create JTextField that outputs the dimensions of the circle
		resultsText = new JTextArea();
		resultsText.setBackground(SystemColor.scrollbar);
		resultsText.setText("Results");
		frame.getContentPane().add(resultsText, BorderLayout.NORTH);
		resultsText.setColumns(10);
		resultsText.setEditable( false ); //This ensures textfield cannot be editted
		resultsText.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//create randomize circle object
		DrawCircle circleD = new DrawCircle(); //create Jpanel object that draws circle
		frame.getContentPane().add(circleD); //add Jpanel object to frame

		//Randomize button which calls the randomize function which randomizes and draws the circle on a JPanel
		btnRandomize = new JButton("Randomize Circle");
		btnRandomize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 		//Call the randomize function to randomize circle on JPanel
				circleD.randomCircle(circleD.getGraphics());
				resultsText.setText(circleD.getValueText());
			}// end method actionPerformed
		});// end action listener
		frame.getContentPane().add(btnRandomize, BorderLayout.SOUTH);
	}// end method initialize
}// end class randomDraws

//SupressWarnings ("serial") is used since there is no intention of serializing the class
//In order to draw the circle, we need to use a component that supports it, in this case its JPanel
@SuppressWarnings("serial")
class DrawCircle extends JPanel {
	 private int radius; //Instance variable for radius of circle
	 private String valueText; //Instance variable that stores the circles dimensions
	 
	//Override the paint component
	   public void paintComponent(Graphics g)
	   {  
		   super.paintComponents(g);
		   
		   ; //Randomize a circle and draw on panel when object is created on start of application
		   randomCircle(g);
	   }
	   
	 //A method that randomly draws circles in different dimensions
	   void randomCircle(Graphics g) 
	   {
		   super.paintComponent(g); //clear screen
		   radius = ( int )( 1 + Math.random() * 100 );
		   g.drawOval( 200, 100, radius, radius ); 
		   valueText = 
					"Area: " + this.getArea() +
					", Radius: " + this.getRadius() +
					", Diameter: " + this.getDiameter() +
					", Circumference: " + this.getCircumference(); 
	   }//end method randomCircle  
	   
	   // return the diameter of the circle
	   public int getDiameter()  {  return ( 2 * radius );  }
	   
	   // return the circumference of the circle
	   public int getCircumference()
	   {  return ( int )( 2 * Math.PI * radius );  }
	   
	   // return the area of the circle
	   public int getArea()
	   {  return ( int )( radius * radius * Math.PI );  }
	   
	   // return the radius of the circle
	   public int getRadius()  {  return radius;  }
	   
	   // return the string value of the circles dimensions
	   public String getValueText()  {  return valueText;  }
			
}// end class DrawCircle
