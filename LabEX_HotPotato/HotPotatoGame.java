// by Sam Dunny

import java.util.Random;
public class HotPotatoGame {

	// range for all random time values (10-30)
	public static final int MIN_RAND_TIME = 10;
	public static final int MAX_RAND_TIME = 21;
	
	// instance variables
	// create a queue of players (string type)
	QueueInterface<String> players;
	/* keeps track of current time of the hot potato 
	 * 	(1) can be decremented after each person holds it
	 * 	(2) can be reset to a new random time*/
	private int currentTime;
	
	// default constructor
	public HotPotatoGame() {
		// calls initializer function
		init();
	}
	
	// initialization function, sets instance variables
	private void init() {
		// create new LinkListQeueu
		players = new LinkedListQueue<String>();
		// separating reset functionality to be used outside of the class
		this.resetTime();
	}
	
	// calculates new random value (in range of 10-30)
	public void resetTime() {
		Random r = new Random();
		// selects values from 10 to 30
		this.currentTime = r.nextInt(MAX_RAND_TIME) + MIN_RAND_TIME;
	}

	// enqueues new player with given name
	public void addPlayer(String aName) {
		if (aName == null)
			return;
		players.enqueue(aName);
	}
	
	// dequeues player at the start of the queue (using circular logic)
	public String getCurrentPlayer() {
		return players.dequeue();
	}
	
	// determines if a time has been entered that decrements the potato's time past 0
	public boolean hasLost(int time) {
		this.currentTime -= time;
		return this.currentTime <= 0;
	}
	
	// returns true if there is only 1 player left in the queue
	public boolean getWin() {
		return players.size() <= 1;
	}
}