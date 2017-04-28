package application;

/*
 Objective: an application to draw complete graphs on n vertices, where n = 1, . . . .,5
 */

import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DrawCompleteGraph {
	
	//Objects for the GUI
	private JFrame frame;
	
	/**
	* Main method to start the Java application
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawCompleteGraph window = new DrawCompleteGraph(); //create the application
					window.frame.setVisible(true); //set the application to visible so it appears on screen
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}// end method main

	/**
	 *  Constructor, Creates GUI
	 */
	public DrawCompleteGraph() {
		initialize(); //setup GUI
	}// end constructor

	/**
	 * Initialize frame and its components
	 */
	private void initialize() {
		//initialize frame
		frame = new JFrame();
		frame.setBounds(100, 100, 597, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Draw Complete Graph");
		DrawGraph compGraph = new DrawGraph();
		frame.getContentPane().add(compGraph, BorderLayout.CENTER);
		compGraph.setLayout(new BorderLayout(0, 0));
		
		//panel used to draw the complete graph
		JPanel panel = new JPanel();
		frame.add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createLineBorder(Color.black));

		//Button that assigns the number of verticies to 1
		JButton btnNewButton_1 = new JButton("n vertices = 1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				compGraph.generCompleteGraph(compGraph.getGraphics(),1); //redraw complete graph with 1 vertex
			}// end method actionPerformed
		});// end action listener
		panel.add(btnNewButton_1); //add button to  leftmost panel
		
		//Button that assigns the number of verticies to 2
		JButton btnNewButton = new JButton("n vertices = 2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compGraph.generCompleteGraph(compGraph.getGraphics(),2); //redraw complete graph with 2 vertices
			}// end method actionPerformed
		});// end action listener
		panel.add(btnNewButton);//add button to  leftmost panel
		
		//Button that assigns the number of verticies to 3
		JButton btnNewButton_2 = new JButton("n vertices = 3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compGraph.generCompleteGraph(compGraph.getGraphics(),3); //redraw complete graph with 3 vertices
			}// end method actionPerformed
		});// end action listener
		panel.add(btnNewButton_2);//add button to  leftmost panel
		
		//Button that assigns the number of verticies to 4
		JButton btnNewButton_3 = new JButton("n vertices = 4");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compGraph.generCompleteGraph(compGraph.getGraphics(),4); //redraw complete graph with 4 vertices
			}// end method actionPerformed
		});// end action listener
		panel.add(btnNewButton_3);//add button to  leftmost panel
		
		//Button that assigns the number of verticies to 5
		JButton btnNewButton_4 = new JButton("n vertices = 5");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compGraph.generCompleteGraph(compGraph.getGraphics(),5); //redraw complete graph with 5 vertices
			}// end method actionPerformed
		});// end action listener
		panel.add(btnNewButton_4);//add button to leftmost panel
		
		//Panel at the top of GUI, it simple holds a JLabel for aesthetics
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black));
		frame.add(panel_1, BorderLayout.NORTH); //add panel to top of frame, this simply holds a JLabel
		
		//a label that just holds title text on top of GUI, this has no functional purpose
		JLabel lblOutput = new JLabel("Output");
		panel_1.add(lblOutput); //add to top panel
		
	}// end method initialize
}// end class DrawCompleteGraph

//SupressWarnings ("serial") is used since there is no intention of serializing the class
//In order to draw the lines, we need to use a component that supports it, in this case its JPanel
@SuppressWarnings("serial")
class DrawGraph extends JPanel {
	
	private int n; //determines the number of vertices to draw on the grid for the complete graph

	
	   //Generate graph by drawing it
		public void paintComponent( Graphics g ){
		   super.paintComponents(g);
		   generCompleteGraph(g,5); //draw complete graph with 5 vertices
		}	
		
		//method used to draw the complete graph
		void generCompleteGraph(Graphics g,int nNew) { 
			super.paintComponent(g); //clear screen when a button that determines the vertices is pressed 
			
			   int[] storeX = new int[10]; //array stores x position of vertices (ovals that are drawn)
			   int[] storeY = new int[10]; //array stores y position of vertices (ovals that are drawn)
			   int x,y; //x,y are incremented by a number to get position of next vertex before drawing it
			   
			   /*
			    * width and height of each vertex of the graph, this value is subtracted from the position
			    * when drawing lines, to get exact coordinates of vertices when drawing a line from vertex to vertex
			    */
			   int width,height; 
			   
			   width = 10; //width of 10 pixels for oval that is drawn
			   height = 10; //height of 10 pixels for oval that is drawn
			   x = 35; //value added to x position of drawn vertex
			   y = 70; //value added to y position of drawn vertex
			   int tempY = 0; //holds temporary y position of middle vertex if n = 5
			   
			   /*
			    * starting y position of vertex, we need this since the y-position of a 
			   *  vertex has varying values that go up and down on a grid
			   */
			   int startPosY = 240; 
			   n = nNew; //determines the number of vertices to draw on the grid for the complete graph
			   
			   for(int i = 0; i < n; i++){
				//the 3rd node is the middle vertex on a pentagon, the positioning isnt mirroed like the other nodes  
				   if(i == 2){
					   g.fillOval(100+x, startPosY+tempY, width, height); //(x,y,width,height)
					   //we need to to use (hight/2) and (width/2) to position the lines when drawing them, this prevents misplacement of lines
					   storeX[i] = (100+x)+(width/2); 
					   storeY[i] = (240+tempY)+(height/2);
				   }
				   else{
					   g.fillOval(100+x, startPosY-y, width, height); //(x,y,width,height)
					   //we need to to use (hight/2) and (width/2) to position the lines when drawing them, this prevents misplacement of lines
					   storeX[i] = (100+x)+(width/2); 
					   storeY[i] = (240-y)+(height/2);
				   }
				   //If it does not equal the center vertex, then draw regular vertices on the grid
					if(i != 1){  
					   x += 35;
					   y = y*(-1) + 70;
					}
					//if center vertex (out of 5 vertices, the middle one) then add larger value to y to draw center vertex
					else{
						x += 35;
						tempY = y - 120; //we subtract middle vertex by this value to have it placed above the other vertices
						y = 70;
					}
			   }//end for loop
			   
			  /*
			   * Using the arrays that stored the x and y position of each vertex, a line is drawn from that vertex, 
			   * to the next.
			   * Two arrays are used to cycle between all vertices and draw a line between each vertex to every vertex.
			   */
			   for(int i = 0; i < n; i++){
				   for(int j = 0; j < n; j++){
					   g.drawLine(storeX[i], storeY[i],storeX[j], storeY[j]);
				   }//end inner for loop
			   }//end outter for loop
			   
		}//end method generCompleteGraph
}// end class DrawPanel
