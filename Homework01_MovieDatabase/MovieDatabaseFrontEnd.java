// by Sam Dunny

package Homework01_MovieDatabase;

import java.util.*;

public class MovieDatabaseFrontEnd {

    // create scanner keyboard for user input
	public static Scanner keyboard = new Scanner(System.in);

	// create linked list for games
	public static MovieDatabase movieDB = new MovieDatabase();
	
	// prints all user options, returns choice
	public static int usrPrompt() {
		System.out.println("\nEnter 1 to Add a Movie");
		System.out.println("Enter 2 to Remove a Movie by Title");
		System.out.println("Enter 3 to Search for Movies by Title");
		System.out.println("Enter 4 to Print All Movies");
		System.out.println("Enter 9 to quit\n");
		int usrInp = keyboard.nextInt();
		// must use after .nextInt() to finish the line
		keyboard.nextLine();
		return usrInp;
	}

    // main method
	public static void main(String[] args) {

        // welcome message
		System.out.println("Welcome to the movie database!");
		
		// variable for user input
		int choice;

		// variable for while-loop continuation
		boolean running = true;
		
		// runs as long as user wants
		while (running) {

            // prompt the user for their choice, store answer
			choice = usrPrompt();
			
			// determine course of action based on user input
			switch(choice) {

                // Add a Movie
				case 1:
                    System.out.println("Enter the movie's name");
                    String anAddition = keyboard.nextLine();
                    movieDB.addMovie(anAddition);
                    break;

                // Remove a Movie by Title
                case 2:
                    System.out.println("Enter the movie's name for removal");
                    String aDeletion = keyboard.nextLine();
                    movieDB.removeMovie(aDeletion);
                    break;

                // Search for Movies by Title
                case 3:
                    System.out.println("Enter the movie's name");
                    String aSearch = keyboard.nextLine();
                    if (movieDB.inDatabase(aSearch))
                        System.out.println(aSearch + " is in your Collection");
                    else
                        System.out.println(aSearch + " is NOT in your Collection");
                    break;

                // Print All Movies
                case 4:
                    System.out.println("Your Collection:");
                    movieDB.print();
                    break;

                // quit
                case 9:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid Input, please try again");
					break;

            }

        }

        System.out.println("Exiting database, no memory saved");
    }
    
}
