package application;

/*
 Objective: An application that randomly draws characters in different fonts, sizes and colors.
 *Another way to randomly draw letters
 */

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Random;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class randomDraws2 {
	
	//Objects for the GUI
	private JFrame frame;
	private JLabel charLbl;
	/**
	 * Main method to start the Java application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					randomDraws2 window = new randomDraws2(); //create the application
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
	public randomDraws2() {
		initialize();  //setup GUI
		randomize();
	}// end constructor

	/**
	 * Constructor, Creates GUI
	 */
	private void initialize() {
		//initialize frame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Character Randomizer");
		
		charLbl = new JLabel("text");
		charLbl.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(charLbl);
		
		//Randomize button which calls the randomize function which randomizes the character on label
		JButton btnNewButton = new JButton("Randomize");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Call the randomize function to randomize character on label text
				randomize();
			} // end method actionPerformed
		}); // end action listener
		frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
	} // end method initialize
	
	//A method that randomly draws characters in different fonts, sizes and colors
	   void randomize() {  
		    int max = 255; //255 is max value for each rgb value in the color spectrum
			int min = 0;  //0 is min value for each rgb value in the color spectrum
			
			String[] allFontTypes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); //get all font types
			int[] fontStyles ={ Font.BOLD, Font.ITALIC, Font.PLAIN }; //store font styles, this is used for randomizing font styles
			
	        int r = (int)(Math.random() * max + min); //red
	        int g = (int)(Math.random() * max + min); //green
	        int b = (int)(Math.random() * max + min); //blue
	        int randomSize = (int)(Math.random() * 200 + 10); //assign a randomized font size
			int randomStyle = (int)(Math.random() * 2 + 0); //assign a randomized font style from 0-2, referencing the integer array above
			charLbl.setForeground(new java.awt.Color(r, g, b)); //set text colour of label to a random color based on randomized values r,g,b
	        Font randomFont = new Font(allFontTypes[(int)(Math.random()*50)], fontStyles[randomStyle], randomSize); //choose a random font type
	        charLbl.setFont(randomFont); //set font of label to a random Font, using the Font object 
	        
	        //random letter from the alphabet is generated
	        Random r1 = new Random(); //create random object
	        char chart = (char)(r1.nextInt(26) + 'a'); //randomize a character from a to z
	        charLbl.setText(String.valueOf(chart)); //set label text to char

	    } //end method randomize   
	   
}// end class randomDraws



 
