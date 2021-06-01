package Homework04_FractalTriangles;

// by Sam Dunny

import java.awt.*;
import javax.swing.*;
import java.util.*;

// extending Canvas in order to create new Canvas Object sp
public class FractalTriangle extends Canvas {

	public static void main(String[] args) {
		// constructing new frame
		JFrame frame = new JFrame("Sierpinski's Carpet");
		
		// setting frame size
		frame.setSize(900,900);
		
		// declaring new SierpinskisCarpet object (which is extended from Canvas)
		FractalTriangle sp = new FractalTriangle();
		
		// adding our object to the window, and 'drawing' it, adding exit option
		frame.add(sp);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// paint never gets called locally, but is used by frame object, and needs to be overridden for our purposes
	public void paint(Graphics g) {
		drawTriangle(0, 0, this.getSize().height, g);
	}
	
	// recursively draws squares based on beginning (x,y) and side sub-length
	public void drawTriangle(int x, int y, int window_dim, Graphics g) {
		double half_dim = (double)window_dim / 2.0;
        
        // points for upwards triangle
        int[] x_points = {(int)half_dim, 0, window_dim};
        int[] y_points = {0, window_dim, window_dim};

        // first triangle is always black
        g.fillPolygon(x_points, y_points, 3);

        // call recursive function to draw upside down triangles
        drawFractal(half_dim/2.0, half_dim, half_dim, g);
	}

    public void drawFractal(double x, double y, double side, Graphics g) {
        double sub = side / 2.0;
        int[] x_points = {(int)x, (int)(x + side), (int)(x + sub)};
        int[] y_points = {(int)y, (int)y, (int)(y + side)};

        Random r = new Random();

        Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW,
                          Color.GREEN, Color.BLUE, Color.PINK, Color.CYAN};

        // set new color (will set new color anytime window changes)
        g.setColor(colors[r.nextInt(colors.length)]);

        g.fillPolygon(x_points, y_points, 3);

		if (sub >= 4) {

            // Top
            drawFractal(x + (sub/2), y - sub, sub, g);

            // Right
            drawFractal(x - (sub/2), y + sub, sub, g);

            // Left
            drawFractal(x + (1.5 * sub), y + sub, sub, g);
		}
    }

}