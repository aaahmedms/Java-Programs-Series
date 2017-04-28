package application;

/*
 Objective:  Write an application that draws an 8-by-8 grid. Use Graphics method drawLine. 
 */

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class drawGrid {

	//Objects for the GUI
	private JFrame frame;

	/**
	 * Main method to start the Java application
	 */
	public static void main(String[] args) {
					drawGrid window = new drawGrid(); //create the application
					window.frame.setVisible(true); //set the application to visible so it appears on screen
	}// end method main

	/**
	 * Constructor, Creates GUI
	 */
	public drawGrid() {
		initialize(); //setup GUI
	} // end constructor

	/**
	 * Initialize frame and its components
	 */
	private void initialize() {
		//initialize frame
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("8x8 Grid Draw");
		frame.add(new DrawPanel());
	}// end method initialize
}// end class drawGrid


@SuppressWarnings("serial")
class DrawPanel extends JPanel {
	//paint grid
		public void paintComponent( Graphics g ){
		   super.paintComponents(g);
		   
		   //starting x position of grid
		   int x = 60; 
		   
		   //starting y position of grid. if this is modified, the updated y in the for loop has to be changed to same value
		   int y = 60; 
		   
		   /*A nested for loop is used to draw squares vertically to form a grid. After each column is done, the
		   *next set of squares are created 15 pixels to the right of first column of squares to form a new set of 
		   *squares vertically
		   */
		   //(x1,y1,x2,y2) coordinates on grid
		   for ( int row = 1; row <= 8; row++ ){ 
			   for ( int column = 1; column <= 8; column++){ 
				   g.drawLine( 30+x, 30+y, 15+x, 30+y ); //bottom line of square
				   g.drawLine( 30+x, 15+y, 30+x, 30+y ); //right line of square
				   g.drawLine( 15+x, 30+y, 15+x, 15+y ); //left line
				   g.drawLine( 15+x, 15+y, 30+x, 15+y ); //top line of square
				   y += 15;
			   }//end inner for loop
			   y = 60; //reset back to first squares y position
			   x += 15; //translate 15  pixels to the right
		   }//end outter for loop   
		   
		}	
}// end class DrawPanel

