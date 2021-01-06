// by Sam Dunny

import java.util.Scanner;
public class MazeGameFE {

	// create scanner as public static so it is available universally
	public static Scanner keyboard = new Scanner(System.in);
	// create new MazeGame as public static so it is available universally
	public static MazeGame game = new MazeGame();
	// give up variable
	public static String GIVE_UP = "Give Up";
	
	// main method
	public static void main(String[] args) {
		
		// create game pay-ability loop and condition
		boolean playGame = true;
		while (playGame) {
			System.out.println("Welcome to the Maze in the Dark!");
			// always start with fresh game board
			game.reset();
			
			// create game loop and condition
			boolean gameOver = false;
			while (!gameOver) {
				// print the movement options and take in user input
				game.printMoveOptions();
				System.out.println(GIVE_UP);
				String input = keyboard.nextLine();
				
				// user quits
				if (input.equalsIgnoreCase(GIVE_UP)) {
					gameOver = true;
					game.printFullMaze();
				}
				// user moves
				else
					game.move(input);
				
				// user wins
				if (game.getWin()) {
					System.out.println("You Win!");
					game.printFullMazeWithPath();
					gameOver = true;
				}
			}
			// play another round prompt
			System.out.println("Enter \"yes\" to play again!");
			playGame = keyboard.nextLine().equalsIgnoreCase("yes");
		}
		System.out.println("Good Bye!");
	}

}
