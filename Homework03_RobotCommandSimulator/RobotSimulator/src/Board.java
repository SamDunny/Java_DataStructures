package Homework03_RobotCommandSimulator.RobotSimulator.src;

// by Sam Dunny

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//2-dimensional arrays are indexed [row][columns]

/* _	= empty space
 * X	= occupied space
 * O	= robot
 */

public class Board {
	
	// instance variables
	private char[][] board;
	private int x_bounds;
	private int y_bounds;
	private char robot = 'O';
	
	// robot coordinates
	private int robotRow = 0;
	private int robotCol = 0;
	
	// default constructor
	public Board() {
		this.board = null;
		this.x_bounds = 0;
		this.y_bounds = 0;
	}
	
	// parameterized constructor
	public Board(String fileName, int x_dimensions, int y_dimensions) {
		this.x_bounds = x_dimensions;
		this.y_bounds = y_dimensions;
		this.board = new char[y_bounds][x_bounds];
		// try-catch block for 'fileNotFound' exception
		try {
			// create new file scanner
			Scanner boardScanner = new Scanner(new File(fileName));
			
			int y_index = 0;
			
			// go through input file until EOF
			while (boardScanner.hasNextLine()) {
				// takes in line, converts it to 2d array
				char[] temp = boardScanner.nextLine().toCharArray();
				
				for (int i = 0; i < temp.length; i++) {
					//System.out.print("COORDS: [" + i + "," + y_index + "]  ");
					board[y_index][i] = temp[i];
				}
				//System.out.println();
				
				y_index++;
				
			}
			
			// place robot at starting coordinates
			board[robotRow][robotCol] = robot;
			
			// close the file scanner
			boardScanner.close();
		}
		// catch block, in cases of "File Not Found"
		catch (IOException e) {
			System.out.println(e);
		}
	}
	
	// accessors
	public int getRobotRowCoords() {
		return robotRow;
	}
	public int getRobotColCoords() {
		return robotCol;
	}
	public int getRowBounds() {
		return this.y_bounds;
	}
	public int getColBounds() {
		return this.x_bounds;
	}
	
	// mutators
	public void setRobotRowCoords(int pos) {
		this.robotRow = pos;
	}
	public void setRobotColCoords(int pos) {
		this.robotCol = pos;
	}
	
	// print function
	public void print() {
		for (int i = 0; i < y_bounds; i++) {
			for (int j = 0; j < x_bounds; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	// returns true if robot did not crash or go OOB
	public boolean processCommand(String cmd) {
		if (cmd.equalsIgnoreCase("Move Up"))
			return moveRobotUp();
		if (cmd.equalsIgnoreCase("Move Down"))
			return moveRobotDown();
		if (cmd.equalsIgnoreCase("Move Right"))
			return moveRobotRight();
		if (cmd.equalsIgnoreCase("Move Left"))
			return moveRobotLeft();
		else {
			System.out.println("INVALID ROBOT COMMAND");
			// assume a crash
			return false;
		}
	}
	
	// move up command
	public boolean moveRobotUp() {
		// going up a row, staying in same column
		int nextRow = getRobotRowCoords() - 1;
		int nextCol = getRobotColCoords();
		
		// the next coordinate is out of bounds
		if (nextRow < 0)
			return false;
		
		// the next coordinate is an X, you crash
		if (Character.compare(Character.toLowerCase(board[nextRow][nextCol]), 'x') == 0) {
			return false;
		}
		
		// clear our current space
		board[getRobotRowCoords()][getRobotColCoords()] = '_';
		
		// set valid valid coordinates
		setRobotRowCoords(nextRow);
		setRobotColCoords(nextCol);
		
		// move to next space
		board[getRobotRowCoords()][getRobotColCoords()] = robot;
		
		print();
		
		return true;
	}
	
	// move down command
	public boolean moveRobotDown() {
		// going down a row, staying in same column
		int nextRow = getRobotRowCoords() + 1;
		int nextCol = getRobotColCoords();
				
		// the next coordinate is out of bounds
		if (nextRow >= getRowBounds())
			return false;
				
		// the next coordinate is an X, you crash
		if (Character.compare(Character.toLowerCase(board[nextRow][nextCol]), 'x') == 0) {
			return false;
		}
				
		// clear our current space
		board[getRobotRowCoords()][getRobotColCoords()] = '_';
		
		// set valid valid coordinates
		setRobotRowCoords(nextRow);
		setRobotColCoords(nextCol);
		
		// move to next space
		board[getRobotRowCoords()][getRobotColCoords()] = robot;
		
		print();
		
		return true;
	}
		
	// move right command
	public boolean moveRobotRight() {
		// going up a column, staying in same row
		int nextRow = getRobotRowCoords();
		int nextCol = getRobotColCoords() + 1;
						
		// the next coordinate is out of bounds
		if (nextCol >= getColBounds())
			return false;
				
		// the next coordinate is an X, you crash
		if (Character.compare(Character.toLowerCase(board[nextRow][nextCol]), 'x') == 0) {
			return false;
		}
						
		// clear our current space
		board[getRobotRowCoords()][getRobotColCoords()] = '_';
		
		// set valid valid coordinates
		setRobotRowCoords(nextRow);
		setRobotColCoords(nextCol);
				
		// move to next space
		board[getRobotRowCoords()][getRobotColCoords()] = robot;
		
		print();
		
		return true;
	}
		
	// move left command
	public boolean moveRobotLeft() {
		// going down a column, staying in same row
		int nextRow = getRobotRowCoords();
		int nextCol = getRobotColCoords() - 1;
								
		// the next coordinate is out of bounds
		if (nextCol < 0)
			return false;
				
		// the next coordinate is an X, you crash
		if (Character.compare(Character.toLowerCase(board[nextRow][nextCol]), 'x') == 0) {
			return false;
		}
								
		// clear our current space
		board[getRobotRowCoords()][getRobotColCoords()] = '_';
		
		// set valid valid coordinates
		setRobotRowCoords(nextRow);
		setRobotColCoords(nextCol);
						
		// move to next space
		board[getRobotRowCoords()][getRobotColCoords()] = robot;
		
		print();
		
		return true;
	}
}