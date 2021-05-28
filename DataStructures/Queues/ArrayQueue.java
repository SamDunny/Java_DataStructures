package DataStructures.Queues;

// by Sam Dunny

public class ArrayQueue <T> implements QueueInterface<T> {

	// instance variables
	private T[] queue;
	// index of first element
	private int headIndex;
	// index of first null element (1 past the last element)
	private int tailIndex;
	
	// creating default size that is accessible out of the class, but cannot be modified
	public static final int DEF_SIZE = 100;
	
	// default constructor
	public ArrayQueue() {
		init(DEF_SIZE);
	}
	
	// parameterized constructor
	public ArrayQueue(int size) {
		init(size);
	}
	
	// initialization function, sets array size
	private void init(int size) {
		headIndex = 0;
		tailIndex = 0;
		if (size >= 1)
			/* all objects inherit from Object, so we are creating 
			 * Object[] and then type-casting to T */
			queue = (T[])(new Object[size]);
		else
			queue = (T[])(new Object[DEF_SIZE]);
	}
	
	// adds a node with aData
	public void enqueue(T aData) {
		// checking to see if queue is not empty and full (using circular indexing)
		if (queue[headIndex] != null && headIndex == tailIndex)
			return;
		// otherwise, add item to the end and move the tailIndex reference (circular-ly, hence the %)
		queue[tailIndex] = aData;
		tailIndex = (tailIndex + 1) % queue.length;
	}
	
	// removes and returns first node's data
	public T dequeue() {
		// save reference to first node's data
		T ret = queue[headIndex];
		// move the headIndex reference (circular-ly, hence the %)
		headIndex = (headIndex + 1) % queue.length;
		return ret;
	}
	
	// returns first node's data but doesn't remove the item
	public T peek() {
		// returns data T found at queue[first element]
		return queue[headIndex];
	}
	
	// prints all items in queues' data
	public void print() {
		// prints out first element (as we cannot find it using circular indexing the first time)
		System.out.print(queue[headIndex]);
		// loop through queue using circular indexing until we reach the last index
		for (int i = (headIndex + 1) % queue.length; i != tailIndex; i = (i + 1) % queue.length)
			System.out.print(" " + queue[i]);
		System.out.println();
	}
}