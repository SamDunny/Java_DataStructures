package DataStructures.LinkedLists;

// by Sam Dunny
public class IntLinkedListTester {

	public static void main(String[] args) {
		
		// initialize new linked list
		IntLinkedList iLL = new IntLinkedList();
		
		System.out.println("--- TESTING .add AND .print ---");
		// populate linked list
		for (int i = 0; i < 5; i++) {
			iLL.add(i);
		}
		// print out list
		iLL.print();
		
		System.out.println("\n--- TESTING .addAfterCurrent ---");
		int testVal1 = 22;
		System.out.println("Adding " + testVal1 + " after current");
		iLL.addAfterCurrent(testVal1);
		iLL.print();
		
		System.out.println("\n--- TESTING .add ---");
		int testVal2 = 23;
		System.out.println("Adding " + testVal2);
		iLL.add(testVal2);
		iLL.print();
		
		System.out.println("\n--- TESTING .gotoNext ---");
		System.out.println("Current: " + iLL.getCurrent());
		iLL.gotoNext();
		System.out.println("Current set to next element: " + iLL.getCurrent());
		
		
		System.out.println("\n--- TESTING .gotoPrev ---");
		System.out.println("Current: " + iLL.getCurrent());
		iLL.gotoPrev();
		System.out.println("Current moved back to: " + iLL.getCurrent());
		iLL.gotoPrev();
		// this test line will not print unless the previous .gotoPrev works correctly
		System.out.println("Test to make sure current does not IOB: TRUE");
		
		System.out.println("\n--- TESTING .setCurrent ---");
		int testVal3 = 50;
		System.out.println("Current: " + iLL.getCurrent());
		iLL.setCurrent(testVal3);
		System.out.println("New Current: " + iLL.getCurrent());
		iLL.print();
		
		System.out.println("\n--- TESTING .reset ---");
		iLL.gotoNext();
		System.out.println("Moving current forward");
		System.out.println("New Current: " + iLL.getCurrent());
		System.out.println("Resetting");
		iLL.reset();
		System.out.println("Current: " + iLL.getCurrent());
		
		System.out.println("\n--- TESTING .removeCurrent ---");
		System.out.println("Current: " + iLL.getCurrent());
		System.out.println("Removing Current");
		iLL.removeCurrent();
		System.out.println("New Current: " + iLL.getCurrent());
		iLL.print();
		System.out.println("Attempting to .gotoPrev before head");
		iLL.gotoPrev();
		System.out.println("Current: " + iLL.getCurrent());
		
		System.out.println("\n--- TESTING .reset AND .removeCurrent (again)");
		System.out.println("Removing all elements");
		iLL.print();
		iLL.reset();
		System.out.println("List Length: " + iLL.getListLength());
		while (iLL.hasMore()) {
			iLL.removeCurrent();
		}
		iLL.print();
	}
}
