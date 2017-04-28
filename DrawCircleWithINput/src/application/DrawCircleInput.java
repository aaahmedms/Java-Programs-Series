package application;

/*
 Objective:  A program that takes user input and generates a circle based on the information
 *passed from the user.
 */

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class DrawCircleInput {
	
	//Objects for the GUI
	private JFrame frame;
	private JPanel panel; 
	private JTextField dimenText; //The display used to show the result after a circle generated
	private JButton btnRandomize; //Randomize button which performs the action of generating the circle
	private JTextField userRadius; //textfield that takes the radius inputted by the user 
	private JLabel lblRadius;  //a label that just holds text, this has no functional purpose
	private JTextField txtEnterXPos; //textfield that takes the x position inputted by the user 
	private JLabel lblX;  //a label that just holds text, this has no functional purpose
	private JTextField txtEnterYPos; //textfield that takes the y position inputted by the user 
	private JLabel lblY;  //a label that just holds text, this has no functional purpose

	/**
	 * Main method to start the Java application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawCircleInput window = new DrawCircleInput(); //create the application
					window.frame.setVisible(true);  //set the application to visible so it appears on screen
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}// end method main

	/**
	 * Constructor, Creates GUI
	 */
	public DrawCircleInput() {
		initialize(); //setup GUI
	}// end constructor

	/**
	 * Initialize frame and its components
	 */
	private void initialize() {
		//initialize frame
		frame = new JFrame();
		frame.setBounds(100, 100, 654, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Draw Circle Input");
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		//create JTextField that outputs the dimensions of the circle
		dimenText = new JTextField();
		dimenText.setHorizontalAlignment(SwingConstants.CENTER);
		dimenText.setText("Dimensions");
		frame.getContentPane().add(dimenText, BorderLayout.NORTH);
		dimenText.setColumns(10);
		dimenText.setEditable( false ); //This ensures textfield cannot be editted
		
		//create randomize circle object
		DrawCircle circleD = new DrawCircle(); //create object that draws circle
		frame.getContentPane().add(circleD);
		circleD.setLayout(null);
		
		//panel used to hold user input textfields
		panel = new JPanel();
		panel.setBounds(0, 84, 434, 32);
		frame.getContentPane().add(panel, BorderLayout.WEST);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		//assign constraints for gridbaglayout of panel
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{36, 86, 0};
		gbl_panel.rowHeights = new int[]{20, 0, 0, 0, 92, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		//A label that holds x position of current circle created
		lblRadius = new JLabel("Radius:");
		//assign constraints for gridbaglayout of radius label text
		GridBagConstraints gbc_lblRadius = new GridBagConstraints();
		gbc_lblRadius.anchor = GridBagConstraints.WEST;
		gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
		gbc_lblRadius.gridx = 0;
		gbc_lblRadius.gridy = 0;
		panel.add(lblRadius, gbc_lblRadius); //add label to  leftmost panel
		
		//field for user input to input the user radius
		userRadius = new JTextField();
		//assign constraints for gridbaglayout of user radius label text
		GridBagConstraints gbc_userRadius = new GridBagConstraints();
		gbc_userRadius.insets = new Insets(0, 0, 5, 0);
		gbc_userRadius.anchor = GridBagConstraints.NORTHWEST;
		gbc_userRadius.gridx = 1;
		gbc_userRadius.gridy = 0;
		panel.add(userRadius, gbc_userRadius); //add user radius input JTextfield to leftmost panel
		userRadius.setColumns(10);
		userRadius.setText("Enter radius...");
		
		//A label that holds x position of current circle created
		lblX = new JLabel("X:");
		//assign constraints for gridbaglayout of x position label text
		GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.insets = new Insets(0, 0, 5, 5);
		gbc_lblX.anchor = GridBagConstraints.EAST;
		gbc_lblX.gridx = 0;
		gbc_lblX.gridy = 1;
		panel.add(lblX, gbc_lblX); //add label to  leftmost panel
		
		//field for user input to input the x position 
		txtEnterXPos = new JTextField();
		txtEnterXPos.setText("Enter x Pos..");
		//assign constraints for gridbaglayout of x position user input
		GridBagConstraints gbc_txtEnterXPos = new GridBagConstraints();
		gbc_txtEnterXPos.insets = new Insets(0, 0, 5, 0);
		gbc_txtEnterXPos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterXPos.gridx = 1;
		gbc_txtEnterXPos.gridy = 1;
		panel.add(txtEnterXPos, gbc_txtEnterXPos); //add x position input JTextfield to leftmost panel
		txtEnterXPos.setColumns(10);
		
		//A label that holds y position of current circle created
		lblY = new JLabel("Y:");
		//assign constraints for gridbaglayout of y position label text
		GridBagConstraints gbc_lblY = new GridBagConstraints();
		gbc_lblY.insets = new Insets(0, 0, 5, 5);
		gbc_lblY.anchor = GridBagConstraints.EAST;
		gbc_lblY.gridx = 0;
		gbc_lblY.gridy = 2;
		panel.add(lblY, gbc_lblY); //add label to  leftmost panel
		
		//field for user input to input the y position 
		txtEnterYPos = new JTextField();
		txtEnterYPos.setText("Enter y Pos..");
		//assign constraints for gridbaglayout of y position user input
		GridBagConstraints gbc_txtEnterYPos = new GridBagConstraints();
		gbc_txtEnterYPos.insets = new Insets(0, 0, 5, 0);
		gbc_txtEnterYPos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterYPos.gridx = 1;
		gbc_txtEnterYPos.gridy = 2;
		panel.add(txtEnterYPos, gbc_txtEnterYPos); //add y position input JTextfield to leftmost panel
		txtEnterYPos.setColumns(10);

		//Randomize button which calls the randomize function which randomizes and draws the circle
		btnRandomize = new JButton("Generate Circle");
		btnRandomize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		 		//Call the randomize function to randomize circle
				circleD.randomCircle(circleD.getGraphics(),
						Float.parseFloat(userRadius.getText()),
						Float.parseFloat(txtEnterXPos.getText()),
						Float.parseFloat(txtEnterYPos.getText()));
				dimenText.setText(circleD.getValueText()); //Textfield shows dimensions of drawn circle on screen
			}catch(Exception e1){
				//if user does not input a valid number then error is shown and caught. JOptionPanes pops up error message
				JOptionPane.showMessageDialog(frame, "Please enter valid Input. (Integer or Double)","Error", JOptionPane.ERROR_MESSAGE);
			} //end catch
			}// end method actionPerformed
		});// end action listener
		frame.getContentPane().add(btnRandomize, BorderLayout.SOUTH);
	}// end method initialize
}// end class randomDraws

//SupressWarnings ("serial") is used since there is no intention of serializing the class
//In order to draw the circle, we need to use a component that supports it, in this case its JComponent
@SuppressWarnings("serial")
class DrawCircle extends JComponent {
	 private float radius; //Instance variable for radius of circle
	 private String valueText; //Instance variable that stores the circles dimensions
	   
	 //A method that randomly draws circles in different dimensions
	   void randomCircle(Graphics g,float userRadius,float x,float y) 
	   {	   
		   Graphics2D gt = (Graphics2D)g;
		   //clear screen
		   gt.setColor(new Color(0, 0, 0, 0)); //set to transparent
		   gt.clearRect(0, 0, getWidth(), getHeight());
		   gt.setColor(Color.BLACK); //set colour back to black before drawing circle
		   radius = userRadius; //set circles radius to users inputted radius
		   Ellipse2D.Double generCircle = new Ellipse2D.Double(x,y,radius,radius); //setup circle parameters
		   gt.draw(generCircle); //draw circle
		   //Store dimensions in the string text 
		   valueText = 
					"Area: " + this.getArea() +
					", Radius: " + this.getRadius() +
					", Diameter: " + this.getDiameter() +
					", Circumference: " + this.getCircumference(); 
	   }//end method randomCircle  
	   
	   // return the diameter of the circle
	   public float getDiameter()  {  return ( 2 * radius );  }
	   
	   // return the circumference of the circle
	   public float getCircumference()
	   {  return (float) ( 2 * Math.PI * radius );  }
	   
	   // return the area of the circle
	   public float getArea()
	   {  return  (float) (radius * radius * Math.PI) ;  }
	   
	   // return the radius of the circle
	   public float getRadius()  {  return radius;  }
	   
	   // return the string value of the circles dimensions
	   public String getValueText()  {  return valueText;  }
			
}// end class DrawCircle
