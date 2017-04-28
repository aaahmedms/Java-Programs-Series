package application;

//A regular test program to try different drawing methods under the java.awt graphics library

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class ok {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("8x8 Grid Draw");
		frame.add(new drawPanel());

		frame.setVisible(true);
		
		int i = 0;
		
		System.out.println(++i);

	}
	
}

class drawPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g){
		super.paintComponents(g);
		g.setColor(Color.red);
		g.drawOval(20, 20, 40, 50);//(x,y,width,height)
		g.drawRect(40, 80, 40, 50);//(x,y,width,height)
		g.drawArc(80, 140, 30, 40, 0, 180); //(x,y,start Angle,Arc Angle)
											//start angle is where the arc is going to start
		
		//to draw a circle with arc
		g.drawArc(120, 180, 30, 40, 0, 225); //(x,y,start Angle,Arc Angle)
	}
	
}
