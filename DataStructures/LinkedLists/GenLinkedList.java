package DataStructures.LinkedLists;

// by Sam Dunny

public class GenLinkedList <T> {

	// internal ListNode class
	private class ListNode {
		// internal instance variables
		T data;
		ListNode link;
		
		// internal parameterized constructor
		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}
	
	// instance variables
	private ListNode head;
	private ListNode current;
	private ListNode previous;
	
	// default constructor
	public GenLinkedList() {
		head = null;
		current = null;
		previous = null;
	}
	
	// adds data from parameter at the end of the list
	public void add(T aData) {
		// construct new node with given data
		ListNode newNode = new ListNode(aData, null);
		
		// no items in list
		if (head == null) {
			head = newNode;
			current = newNode;
			return;
	    }
		
		// traverse list until we find the end, add new node
		ListNode temp = head;
		while (temp.link != null)
			temp = temp.link;
		temp.link = newNode;
	}

	// prints all nodes' data
	public void print() {
		// create iterator node
		ListNode temp = head;
		System.out.println("In order: ");
		
		// traverse list printing values
		while (temp != null) {
			System.out.print(temp.data + "  ");
			temp = temp.link;
		}
		System.out.println();
	}
	
	// adds data from parameter after current node
	public void addAfterCurrent(T aData) {
		if (current == null)
			return;
		ListNode newNode = new ListNode(aData, current.link);
		current.link = newNode;
	}
	
	// returns current node's data
	public T getCurrent() {
		if (current == null)
			return null;
		return current.data;
	}
	
	// sets current node's data
	public void setCurrent(T aData) {
		if (aData == null || current == null)
			return;
		current.data = aData;
	}
	
	// sets current to the next node (even if null)
	public void gotoNext() {
		if (current == null)
			return;
		previous = current;
		current = current.link;
	}
	
	// sets current to the previous node (only if current != null or head)
	public void gotoPrev() {	
		if (current == null || current == head) {
			return;
		}
		ListNode temp = head;
		// start previous off at null (in case second element is current)
		previous = null;
		while (temp.link != current) {
			// increment previous
			previous = temp;
			// increment temp
			temp = temp.link;
		}
		// set current to temp
		current = temp;
	}
	
	// resets the current to the head
	public void reset() {
		// don't need a null check, resetting regardless
		current = head;
		previous = null;
	}
	
	// returns true if current != null
	public boolean hasMore() {
		return current != null;
	}
	
	// removes current, and sets links accordingly
	public void removeCurrent() {
		// case 1: the current item is the head
		if (current == head) {
			head = head.link;
			current = head;
		}
		// case 2: current item is somewhere in the middle of the list (or last)
		else {
			previous.link = current.link;
			current = current.link;
		}
	}
}
