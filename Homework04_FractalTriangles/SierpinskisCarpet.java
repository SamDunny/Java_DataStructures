package Homework04_FractalTriangles;

// by Sam Dunny

import java.awt.*;
import javax.swing.*;
import java.util.*;

// extending Canvas in order to create new Canvas Object sp
public class SierpinskisCarpet extends Canvas {

	public static void main(String[] args) {
		// constructing new frame
		JFrame frame = new JFrame("Sierpinski's Carpet");
		
		// setting frame size
		frame.setSize(900,900);
		
		// declaring new SierpinskisCarpet object (which is extended from Canvas)
		SierpinskisCarpet sp = new SierpinskisCarpet();
		
		// adding our object to the window, and 'drawing' it, adding exit option
		frame.add(sp);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// paint never gets called locally, but is used by frame object, and needs to be overridden for our purposes
	public void paint(Graphics g) {
		drawCarpet(0, 0, this.getSize().height, g);
	}
	
	// recursively draws squares based on beginning (x,y) and side sub-length
	public void drawCarpet(int x, int y, int side, Graphics g) {
		int sub = side / 3;
		g.fillRect(x + sub, y + sub, sub, sub);
		if (sub >= 3) {
			// Top Left
			drawCarpet(x, y, sub, g);
			// Top Middle
			drawCarpet(x+sub, y, sub, g);
			// Top Left
			drawCarpet(x+(2*sub), y, sub, g);
			// Middle Right
			drawCarpet(x, y+sub, sub, g);
			// Middle Left
			drawCarpet(x+(2*sub), y+sub, sub, g);
			// Bottom Left
			drawCarpet(x, y+(2*sub), sub, g);
			// Bottom Middle
			drawCarpet(x+sub, y+(2*sub), sub, g);
			// Bottom Left
			drawCarpet(x+(2*sub), y+(2*sub), sub, g);
		}
	}

}