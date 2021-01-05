// by Sam Dunny
public class LinkedListStack<T> implements StackInterface<T> {

	// internal ListNode class
	private class ListNode {
		// instance variables
		T data;
		ListNode link;
		
		// parameterized constructor
		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}

	// instance variable
	// head tracks the first null element in the list
	private ListNode head;
	
	// default constructor
	public LinkedListStack() {
		head = null;
	}
	
	// adds new item to the head of the list with given data
	public void push(T aData) {
		ListNode newNode = new ListNode(aData,head);
		head = newNode;
	}
	
	// removes head from the list, returns head's data
	public T pop() {
		// can't remove from and empty list
		if (head == null)
			return null;
		// copy reference data
		T ret = head.data;
		// remove the head by setting link
		head = head.link;
		// return data
		return ret;
	}
	
	// returns data at the head (without removal)
	public T peek() {
		if (head == null)
			return null;
		return head.data;
	}
	
	// traverses list and prints stacks' data
	public void print() {
		for (ListNode temp = head; temp != null; temp = temp.link)
			System.out.println(temp.data);
	}
}
