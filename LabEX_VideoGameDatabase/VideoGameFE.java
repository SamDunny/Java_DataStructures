// by Sam Dunny

import java.io.*;
import java.util.*;

public class VideoGameFE {

	// create scanner keyboard for user input
	public static Scanner keyboard = new Scanner(System.in);
	// create linked list for games
	public static GenLinkedList<VideoGame> gameList = new GenLinkedList<VideoGame>();
	public static GenLinkedList<VideoGame> results = new GenLinkedList<VideoGame>();
	
	// prints all user options, returns choice
	public static int usrPrompt() {
		System.out.println("Enter 1 to load the video game database");
		System.out.println("Enter 2 to search the database");
		System.out.println("Enter 3 to print current results");
		System.out.println("Enter 4 to print current results to file");
		System.out.println("Enter 0 to quit");
		int usrInp = keyboard.nextInt();
		// must use after .nextInt() to finish the line
		keyboard.nextLine();
		return usrInp;
	}
		
	// prints out values currently in gameList
	public static void printDatabase(GenLinkedList<VideoGame> tmp) {
		// reset current to print all items
		tmp.reset();
		
		// traverse list
		while (tmp.hasMore()) {
			System.out.println(tmp.getCurrent().printValues());
			tmp.gotoNext();
		}
		System.out.println();
	}
	
	// main method
	public static void main(String[] args) {
		// welcome message
		System.out.println("Welcome to the video game database!");
		
		// variable for user input
		int choice;
		// variable for while-loop continuation
		boolean running = true;
		
		// runs as long as user wants
		while (running) {
			choice = usrPrompt();
			
			// determine course of action based on user input
			switch(choice) {
			
				// load video game database
				case 1:
					// get user filename input
					System.out.println("Enter the file name");
					String fileName = keyboard.nextLine();
					
					// try-catch block for 'fileNotFound' exception
					try {
						// create new file scanner
						Scanner fileScanner = new Scanner(new File(fileName));
						
						// go through input file until EOF
						while (fileScanner.hasNextLine()) {
							String line = fileScanner.nextLine();
							
							// create 2 element array to split name and console values (on tab)
							String[] values = line.split("\\t");
							
							// create new video game object with array values, add to linked list
							VideoGame temp = new VideoGame(values[0], values[1]);
							gameList.add(temp);
						}
						
						// close the file scanner
						fileScanner.close();
					}
					// catch block, in cases of "File Not Found"
					catch (IOException e) {
						System.out.println(e);
					}				
					break;
				
				// search database
				case 2:
					// take in user input, convert to lower case
					System.out.println("Enter the name of the game or '*' for all names");
					String usr_name_search_cc = keyboard.nextLine();
					String usr_name_search = usr_name_search_cc.toLowerCase();
					
					// take in user input, convert to lower case
					System.out.println("Enter the name of the console or '*' for all consoles");
					String usr_cons_search_cc = keyboard.nextLine();
					String usr_cons_search = usr_cons_search_cc.toLowerCase();
					
					/* [1] both name and console are asterisks
					 * [2] name is asterisk, console is not
					 * [3] console is asterisk, name is not
					 * [4] neither name nor asterisk are asterisks
					 */
					
					// ensure we are starting from the first item in the list
					gameList.reset();
					
					// clear results list
					results.reset();
					while (results.hasMore()) {
						results.removeCurrent();
					}
					
					// name was asterisk
					if (usr_name_search.equals("*")) {
						// [1] console was asterisk, adding all items from gameList
						if (usr_cons_search.equals("*")) {
							while (gameList.hasMore()) {
								// add current item to results list
								results.add(gameList.getCurrent());
								// going to next node (i++ essentially)
								gameList.gotoNext();
							}
							printDatabase(results);
							break;
						}
						
						// [2] only name was asterisk
						while (gameList.hasMore()) {
							// if the current items name or console contain the user search query, found item
							if (gameList.getCurrent().getConsole().toLowerCase().contains(usr_cons_search)) {
								// add current item to results list
								results.add(gameList.getCurrent());
							}
							// going to next node (i++ essentially)
							gameList.gotoNext();
						}
						printDatabase(results);
						break;
					}
					
					// [3] console was asterisk, name was not
					if (usr_cons_search.equals("*")) {
						while (gameList.hasMore()) {
							// if the current items name or console contain the user search query, found item
							if (gameList.getCurrent().getName().toLowerCase().contains(usr_name_search)) {
								// add current item to results list
								results.add(gameList.getCurrent());
							}
							
							// going to next node (i++ essentially)
							gameList.gotoNext();
						}
						
						printDatabase(results);
						break;
					}
					
					// [4] traverse list while you still have nodes left
					while (gameList.hasMore()) {
						// if the current items name or console contain the user search query, found item
						if (gameList.getCurrent().getName().toLowerCase().contains(usr_name_search) &&
								gameList.getCurrent().getConsole().toLowerCase().contains(usr_cons_search)) {
							// add current item to results list
							results.add(gameList.getCurrent());
						}
						
						// going to next node (i++ essentially)
						gameList.gotoNext();
					}
					
					printDatabase(results);
					break;
					
				// print current results
				case 3:
					// notify user is results list is empty
					if (results.getLength() == 0)
						System.out.println("No results yet");
					
					// otherwise, print list
					printDatabase(results);
					break;
					
				// print current results to a file
				case 4:
					// retrieve user input
					System.out.println("Enter the file name to print out.");
					String usr_file = keyboard.nextLine();
					System.out.println("Append to file? True or false.");
					String usr_append = keyboard.nextLine();
					
					// TODO finish this
					
					// user is appending to file
					if (usr_append.equalsIgnoreCase("true")) {
						
					}
					// user is creating/overwriting new file
					else if (usr_file.equalsIgnoreCase("false")) {
						try {
							PrintWriter printToFile = new PrintWriter(new FileOutputStream(new File(usr_file)));
						}
						// catch block, in cases of "File Not Found"
						catch (IOException e) {
							System.out.println(e);
						}
					}					
					// user entered invalid response
					else {
						System.out.println("Invalid option");
					}
					
					// try-catch block for 'fileNotFound' exception
					try {
						Writer fileWriter = new FileWriter(usr_file);
					}
					// catch block, in cases of "File Not Found"
					catch (IOException e) {
						System.out.println(e);
					}
					break;
					
				// quit
				case 0:
					running = false;
					break;
					
				// user did not enter valid number
				default:
					System.out.println("Invalid Input, please try again");
					break;
			}
		}
		System.out.println("Goodbye!");
		keyboard.close();
	}
	
	

}
