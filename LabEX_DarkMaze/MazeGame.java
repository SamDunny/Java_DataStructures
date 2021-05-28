package LabEX_DarkMaze;

// by Sam Dunny

import java.util.Random;
public class MazeGame {

	// constant variables for maze construction
	public static final int MAZE_SIZE = 10;
	public static final int OBST_AMT = (MAZE_SIZE * MAZE_SIZE)/10;
	public static final char EMPTY = '_';
	public static final char OBST = 'X';
	public static final char PLAYER = 'O';
	public static final char PATH = '#';
	public static final String NORTH = "Go North";
	public static final String SOUTH = "Go South";
	public static final String EAST = "Go East";
	public static final String WEST = "Go West";
	public static final String BACK = "Go Back";
	
	// instance variables
	// arranged in y,x format
	private StackInterface<int[]> locations;
	// 2 element array for coordinates {y,x}
	private int[] currLoc;
	// arranged in y,x format
	private char[][] maze;
	
	// default constructor
	public MazeGame() {
		this.init();
	}
	
	// initializes all instance variables
	private void init() {
		maze = new char[MAZE_SIZE][MAZE_SIZE];
		for (int i = 0; i < maze.length; i++)
			for (int j = 0; j < maze[i].length; j++)
				maze[i][j] = EMPTY;
		this.addObstacles();
		maze[0][0] = PLAYER;
		currLoc = new int[] {0,0};
		locations = new LinkedListStack<int[]>();
	}
	
	// adds obstacles to maze to unique locations in maze (excluding player spawn)
	private void addObstacles() {
		Random r = new Random();
		for (int i = 0; i < OBST_AMT; i++) {
			int x = r.nextInt(MAZE_SIZE);
			int y = r.nextInt(MAZE_SIZE);
			
			if (maze[y][x] != EMPTY || (x == 0 && y == 0))
				continue;
			maze[y][x] = OBST;
		}
	}
	
	// prints valid movement options (including 'back' in cases of returning somewhere)
	public void printMoveOptions() {
		int currY = currLoc[0];
		int currX = currLoc[1];
		int[] prevLoc = locations.peek();
		
		// North option
		// if index is in bounds and not an an obstacle
		if (isValid(currY-1) && maze[currY-1][currX] != OBST) {
			// if we are visiting a previous location
			if (prevLoc != null && currY-1 == prevLoc[0] && currX == prevLoc[1])
				System.out.println(BACK);
			// else, going somewhere new
			else
				System.out.println(NORTH);
		}
		// South option
		// if index is in bounds and not an an obstacle
		if (isValid(currY+1) && maze[currY+1][currX] != OBST) {
			// if we are visiting a previous location
			if (prevLoc != null && currY+1 == prevLoc[0] && currX == prevLoc[1])
				System.out.println(BACK);
			// else, going somewhere new
			else
				System.out.println(SOUTH);
		}
		// East option
		// if index is in bounds and not an an obstacle
		if (isValid(currX+1) && maze[currY][currX+1] != OBST) {
			// if we are visiting a previous location
			if (prevLoc != null && currY == prevLoc[0] && currX+1 == prevLoc[1])
				System.out.println(BACK);
			// else, going somewhere new
			else
				System.out.println(EAST);
		}
		// West option
		// if index is in bounds and not an an obstacle
		if (isValid(currX-1) && maze[currY][currX-1] != OBST) {
			// if we are visiting a previous location
			if (prevLoc != null && currY == prevLoc[0] && currX-1 == prevLoc[1])
				System.out.println(BACK);
			// else, going somewhere new
			else
				System.out.println(WEST);
		}
	}
	
	// takes in direction and moves if valid
	public void move(String input) {
		// 'picking' up player
		maze[currLoc[0]][currLoc[1]] = EMPTY;
		int currY = currLoc[0];
		int currX = currLoc[1];
		
		// create a 'copy' location array so we can push our current location onto the locations stack
		int[] copyLoc = {currLoc[0], currLoc[1]};
		
		// moving North
		if (input.equalsIgnoreCase(NORTH)) {
			if (isValid(currY-1) && maze[currY-1][currX] != OBST) {
				locations.push(copyLoc);
				// update current location
				currLoc[0]--;
			}
			else
				System.out.println("Invalid Move");
		}
		// moving South
		else if (input.equalsIgnoreCase(SOUTH)) {
			if (isValid(currY+1) && maze[currY+1][currX] != OBST) {
				locations.push(copyLoc);
				// update current location
				currLoc[0]++;
			}
			else
				System.out.println("Invalid Move");
		}
		// moving East
		else if (input.equalsIgnoreCase(EAST)) {
			if (isValid(currX+1) && maze[currY][currX+1] != OBST) {
				locations.push(copyLoc);
				// update current location
				currLoc[1]++;
			}
			else
				System.out.println("Invalid Move");
		}
		// moving West
		else if (input.equalsIgnoreCase(WEST)) {
			if (isValid(currX-1) && maze[currY][currX-1] != OBST) {
				locations.push(copyLoc);
				// update current location
				currLoc[1]--;
			}
			else
				System.out.println("Invalid Move");
		}
		// moving back
		else if (input.equalsIgnoreCase(BACK)) {
			// there are locations still in the stack, so we can move backward
			if (locations.peek() != null) {
				int[] prevLoc = locations.pop();
				currLoc[0] = prevLoc[0];
				currLoc[1] = prevLoc[1];
			}
			else
				System.out.println("Invalid move (at start)");
		}
		else
			System.out.println("Invalid move");
		// 'setting' player down
		maze[currLoc[0]][currLoc[1]] = EMPTY;
	}
	
	// returns true if index is within maze size bounds
	private boolean isValid(int index) {
		return index >= 0 && index < maze.length;
	}
	
	// returns true if player reaches opposing corner
	public boolean getWin() {
		return currLoc[0] == maze.length-1 && currLoc[1] == maze.length-1;
	}
	
	// calls the .init method
	public void reset() {
		this.init();
	}
	
	// prints all maze index values
	public void printFullMaze() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				System.out.print(maze[i][j]);;
			}
			System.out.println();
		}
	}
	
	// prints the traveled locations stack, then prints full maze
	public void printFullMazeWithPath() {
		while(locations.peek() != null) {
			int[] temp = locations.pop();
			maze[temp[0]][temp[1]] = PATH;
		}
		this.printFullMaze();
	}
}
