package DataStructures.Stacks;

// by Sam Dunny

public class ArrayStack<T> implements StackInterface<T>{

	// instance variables
	private T[] stack;
	// head element is the first null element(head gets moved as items are moved)
	private int head;
	public static final int DEF_SIZE = 100;
	
	// default constructor
	public ArrayStack() {
		init(DEF_SIZE);
	}
	
	// parameterized constructor
	public ArrayStack(int size) {
		init(size);
	}
	
	// initializer function to set instance variables
	private void init(int size) {
		// head starts off at the beginning of the array (empty)
		head = 0;
		if (size >= 1)
			stack = (T[])(new Object[size]);
		else
			stack = (T[])(new Object[DEF_SIZE]);
	}
	
	// adds item to the top of the stack (if stack not full)
	public void push(T aData) {
		// head index is out of bounds, outgrew array size
		if (head >= stack.length)
			return;
		// add data to the stack
		stack[head] = aData;
		// increment head index
		head++;
	}
	
	// removes item from the top of the stack (if stack not empty), returns data at head
	public T pop() {
		// list is empty (first null element is at stack[0])
		if (head == 0)
			return null;
		// copy data at element behind first null element
		T ret = stack[head-1];
		// decrement head index
		head--;
		return ret;
	}
	
	// returns data at head, without removal
	public T peek() {
		if (head == 0)
			return null;
		return stack[head-1];
	}
	
	// prints out all the stack's data, starting at the head
	public void print() {
		for (int i = head-1; i >= 0; i--)
			System.out.println(stack[i]);
	}
}
