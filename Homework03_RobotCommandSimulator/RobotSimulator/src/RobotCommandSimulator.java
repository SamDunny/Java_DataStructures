// by Sam Dunny

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RobotCommandSimulator {

	// board dimensions
	public static int BOARD_DIM = 10;
	
	// create linked list queue for commands read from text file
	public static LinkedListQueue<String> commandList = new LinkedListQueue<String>();
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to the Robot Simulator");
		boolean simulation_Running = true;
		
		while (simulation_Running) {
		
			System.out.println("Enter file for the Board");
			String boardFile = keyboard.nextLine();
			System.out.println("Enter file for the Robot Commands");
			String commandFile = keyboard.nextLine();
			
			// initialize new board object, given file name and dimensions
			Board gameBoard = new Board(boardFile, BOARD_DIM, BOARD_DIM);
			
			// try-catch block for 'fileNotFound' exception
			try {
				// create new file scanner
				Scanner commandScanner = new Scanner(new File(commandFile));
				
				// go through input file until EOF
				while (commandScanner.hasNextLine()) {
					String cmd = commandScanner.nextLine();
					
					// add command to queue (FIFO)
					if (!cmd.equalsIgnoreCase(""))
						commandList.enqueue(cmd);
				}
				// close the file scanner
				commandScanner.close();
			}
			// catch block, in cases of "File Not Found"
			catch (IOException e) {
				System.out.println(e);
			}
			
			// at this point, we have initialized board with robot and an initialized command list queue
			gameBoard.print();
			System.out.println("\nSimulation Begin");
			int command_cnt = 0;
	
			// as long as the head of the list isn't null, keep dequeue-ing
			while(commandList.peek() != null) {
				// get next command
				String curr_cmd = commandList.dequeue();
				System.out.println("Command " + command_cnt);
				
				// process command, return status (true means good command, false means crash or OOB)
				boolean run_condition = gameBoard.processCommand(curr_cmd);
				
				// we crashed, end simulation
				if (run_condition == false) {
					System.out.println("CRASH");
					break;
				}
				System.out.println();
				command_cnt++;	
			}
			
			// prompt user to decide to quit or keep running
			System.out.println("Simulation end");
			System.out.println("Quit? Enter \"true\" to quit or hit enter to run another simulation");
			String usr_rsp = keyboard.nextLine();
			if (usr_rsp.equalsIgnoreCase("true")) {
				simulation_Running = false;
			}
			else if (usr_rsp.isEmpty()) {
				simulation_Running = true;
			}
			else {
				System.out.println("Invalid input, Quitting");
				simulation_Running = false;
			}
		}
		
		keyboard.close();
	}

}
