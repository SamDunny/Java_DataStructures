package DataStructures.Queues;

// by Sam Dunny

/* 	(1) interfaces cannot be constructed or instantiated,
 * 	    but they can be implemented in object classes
 * 	(2) any class that implements QueueInterface will
 * 	    have the following functionality (to override)
 */
public interface QueueInterface <T> {

	// adds a node with aData
	public void enqueue(T aData);
	
	// removes and returns first node's data
	public T dequeue();
	
	// returns first node's data but doesn't remove the item
	public T peek();
	
	// prints all items in queues' data
	public void print();
}
