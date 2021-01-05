// by Sam Dunny

public class QueueTester {

	public static void main(String[] args) {
		
		QueueInterface<Integer> q1 = new ArrayQueue();
		System.out.println("--- ArrayQueue TESTING ---");
		System.out.println("--- TESTING .enqueue AND .print ---");
		for (int i = 0; i < 10; i++) {
			q1.enqueue(i);
		}
		q1.print();
		
		System.out.println("\n--- TESTING .dequeue ---");
		int val1 = q1.dequeue();
		System.out.println("Removed: " + val1);
		int val2 = q1.dequeue();
		System.out.println("Removed: " + val2);
		q1.print();
		
		System.out.println("\n--- TESTING .peek ---");
		int val3 = q1.peek();
		System.out.println("Peek: " + val3);
		
		
		
		QueueInterface<Double> q2 = new LinkedListQueue();
		System.out.println("\n\n--- LinkedListQueue TESTING ---");
		System.out.println("--- TESTING .enqueue AND .print ---");
		for (double i = 0.0; i < 10.0; i+=1.0) {
			q2.enqueue(i);
		}
		q2.print();
		
		System.out.println("\n--- TESTING .dequeue ---");
		double val4 = q2.dequeue();
		System.out.println("Removed: " + val4);
		double val5 = q2.dequeue();
		System.out.println("Removed: " + val5);
		q2.print();
		
		System.out.println("\n--- TESTING .peek ---");
		double val6 = q2.peek();
		System.out.println("Peek: " + val6);
		
	}
}
