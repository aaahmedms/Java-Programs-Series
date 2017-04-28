package application;

/*
 Objective: An application that randomly draws characters in different fonts, sizes and colors.
 *Another way to randomly draw letters.
 */

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class randomDraws {
	
	//Objects for the GUI
	private JFrame frame;

	/**
	 * Main method to start the Java application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					randomDraws window = new randomDraws(); //create the application
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
	public randomDraws() {
		initialize();  //setup GUI
	}// end constructor

	/**
	 * Initialize frame and its components
	 */
	private void initialize() {
		//initialize frame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Character Randomizer");
		singleCharPanel singleChar = new singleCharPanel(); //create Jpanel object that draws character
		frame.add(singleChar); //add Jpanel object to frame
		
		//Randomize button which calls the randomize function which randomizes and draws the character on a JPanel
		JButton btnNewButton = new JButton("Randomize");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Call the randomize function to randomize character on JPanel
				singleChar.randomCharacter(singleChar.getGraphics());
			} // end method actionPerformed
		}); // end action listener
		frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
	} // end method initialize
}// end class randomDraws


//In order to draw the character, we need to use a component that supports it, in this case its JPanel
//SupressWarnings ("serial") is used since there is no intention of serializing the class
@SuppressWarnings("serial")
class singleCharPanel extends JPanel {
	
	//Override the paint component
	public void paintComponent( Graphics g ){
		   super.paintComponents(g);
		   randomCharacter(g); //Randomize a character and draw on panel when object is created
	}
	
	//A method that randomly draws characters in different fonts, sizes and colors
	   void randomCharacter(Graphics charact) {  
		   super.paintComponent(charact); //clear screen
		   
		    int max = 255; //255 is max value for each rgb value in the color spectrum
			int min = 0;  //0 is min value for each rgb value in the color spectrum
			
			String[] allFontTypes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); //get all font types
			int[] fontStyles ={ Font.BOLD, Font.ITALIC, Font.PLAIN }; //store font styles, this is used for randomizing font styles
			
	        int r = (int)(Math.random() * max + min); //red
	        int g = (int)(Math.random() * max + min); //green
	        int b = (int)(Math.random() * max + min); //blue
	        int randomSize = (int)(Math.random() * 200 + 10); //assign a randomized font size
			int randomStyle = (int)(Math.random() * 2 + 0); //assign a randomized font style from 0-2, referencing the integer array above
			charact.setColor(new java.awt.Color(r, g, b)); //set text colour of drawString to a random color based on randomized values r,g,b
	        Font randomFont = new Font(allFontTypes[(int)(Math.random()*50)], fontStyles[randomStyle], randomSize); //choose a random font type
	        charact.setFont(randomFont); //set font of drawString to a random Font, using the Font object 
	        
	        //random letter from the alphabet is generated
	        Random r1 = new Random(); //create random object
	        char chart = (char)(r1.nextInt(26) + 'a'); //randomize a character from a to z
	        charact.drawString(String.valueOf(chart),160, 150); //Draw the character on JPanel

	    } //end method randomize    
} // end class singleCharPanel
