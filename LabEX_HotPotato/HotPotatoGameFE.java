// by Sam Dunny

import java.util.Scanner;
public class HotPotatoGameFE {

	/* Static methods can call static attributes 
	 * Static methods can call other static methods
	 * Static methods cannot call non-static methods or properties
	 */
	
	// create static keyboard scanner (so we can uses it universally)
	public static Scanner keyboard = new Scanner(System.in);
	// create static HotPotatoGame instance (so we can uses it universally)
	public static HotPotatoGame hpg = new HotPotatoGame();
	
	// create static int ranges that cannot be modified (so we can uses it universally)
	public static final int MIN_TIME = 1;
	public static final int MAX_TIME = 10;
	
	// main method, runs game
	public static void main(String[] args) {
	
		// print greeting message
		greeting();
		
		// create game play-ability loop and condition
		boolean playGame = true;
		while (playGame) {
			
			/* although this gets called in our constructor,
			 * we need to ensure the time is reset every game iteration
			 * 	(1) resets potato's time to a new random value*/
			hpg.resetTime();
			
			// prompt the user to enter a valid number of players
			int numberOfPlayers = getNumberOfPlayers();
			
			// add number of players to the queue
			addPlayers(numberOfPlayers);
			
			// create game cycle and condition
			boolean gameOver = false;
			while (!gameOver) {
				
				// retrieves the first player (dequeues player from list)
				String player = hpg.getCurrentPlayer();
				
				// prompts player for a valid amount of time to hold the potato
				System.out.println(player + ", enter a time to hold the potato from " + MIN_TIME + " to " + MAX_TIME);
				
				// stores answer, determines validity (sets to max time as default)
				int time = keyboard.nextInt();
				keyboard.nextLine();
				if (time < MIN_TIME || time > MAX_TIME) {
					System.out.println("Incorrect value. Assuming time is " + MAX_TIME);
					time = MAX_TIME;
				}
				
				// if a player entered a time that decremented the potato's time below 0, player eliminated
				if (hpg.hasLost(time)) {
					System.out.println("Player " + player + " has been eliminated!");
					// resets potato's time to new random value
					hpg.resetTime();
				}
				else {
					// enqueues player back to the end of the list
					hpg.addPlayer(player);
				}
				
				// set game cycle condition based on how many players are left in the queue
				gameOver = hpg.getWin();
			}
			
			// game cycle has ended, retrieves first (and only) player
			System.out.println("The winner is " + hpg.getCurrentPlayer() + "!");
			
			// determine game play-ability loop condition based on user input
			System.out.println("Enter \"yes\" to play again!");
			String input = keyboard.nextLine();
			playGame = input != null && input.equalsIgnoreCase("yes");
		}
		
		// game has ended, 
		salutation();
	}
	
	// prints a greeting message
	public static void greeting() {
		System.out.println("Welcome to the Hot Potato Game!!");
	}
	
	// prints a departure message
	public static void salutation() {
		System.out.println("Goodbye!");
	}
	
	// prompts the user to enter a player amount > 1, returns that value
	public static int getNumberOfPlayers() {
		int num = 0;
		while(num <= 1) {
			System.out.println("Enter number of players (must be greater than 1)");
			num = keyboard.nextInt();
			keyboard.nextLine();
		}
		return num;
	}
	
	/* adds specified number of players to the queue
	 * 	(1) prompts the user for valid player names
	 * 	(2) enqueues the player*/
	public static void addPlayers(int num) {
		int i = 0;
		while (i < num) {
			System.out.println("Enter your name player " + i);
			String input = keyboard.nextLine();
			// does not allow null or empty names
			if (input == null || input.isEmpty()) {
				System.out.println("Invalid input");
				// does not iterate, instead restarts this cycle to get valid player name
				continue;
			}
			else {
				// enqueues the player
				hpg.addPlayer(input);
			}
			// increment (only happens if player has been enqueued)
			i++;
		}
	}

}