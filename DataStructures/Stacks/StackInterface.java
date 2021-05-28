package DataStructures.Stacks;

// by Sam Dunny

/* 	(1) interfaces cannot be constructed or instantiated,
 * 	    but they can be implemented in object classes
 * 	(2) any class that implements QueueInterface will
 * 	    have the following functionality (to override)
 */
public interface StackInterface <T> {

	// adds an item with aData to the head of the stack
	public void push(T aData);
	
	// removes an item from the head of the stack
	public T pop();
	
	// returns the data from the head of the stack, but does not remove
	public T peek();
	
	// prints all data of the stack
	public void print();
}
