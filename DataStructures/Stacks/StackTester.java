package DataStructures.Stacks;

// by Sam Dunny

public class StackTester {

	public static void main(String[] args) {

		StackInterface<Integer> stack1 = new ArrayStack<Integer>();
		System.out.println("--- ArrayStack TESTING ---");
		System.out.println("--- TESTING .push AND .print ---");
		for (int i = 0; i < 10; i++)
			stack1.push(i);
		stack1.print();
		
		System.out.println("\n--- TESTING .pop ---");
		int val1 = stack1.pop();
		System.out.println("Removed: " + val1);
		int val2 = stack1.pop();
		System.out.println("Removed: " + val2);
		stack1.print();
		
		System.out.println("\n--- TESTING .peek ---");
		int val3 = stack1.peek();
		System.out.println("Peek: " + val3);
		
		
		StackInterface<Integer> stack2 = new LinkedListStack<Integer>();
		System.out.println("\n\n--- LinkedListStack TESTING ---");
		System.out.println("--- TESTING .push AND .print ---");
		for (int i = 0; i < 10; i++)
			stack2.push(i);
		stack2.print();
		
		System.out.println("\n--- TESTING .pop ---");
		int val4 = stack2.pop();
		System.out.println("Removed: " + val4);
		int val5 = stack2.pop();
		System.out.println("Removed: " + val5);
		stack2.print();
		
		System.out.println("\n--- TESTING .peek ---");
		int val6 = stack1.peek();
		System.out.println("Peek: " + val6);
	}

}
