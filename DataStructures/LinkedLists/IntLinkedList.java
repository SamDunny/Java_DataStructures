// by Sam Dunny

public class IntLinkedList {

	// ListNode internal class
	private class ListNode {
		// internal class instance variables
		int data;
		ListNode link;
		
		// parameterized constructor
		public ListNode(int aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}
	
	// instance variables (private and not available outside of class)
	// first element in the list
	private ListNode head;
	// current node of interest
	private ListNode current;
	// node that always one node behind current
	private ListNode previous;
	
	// default constructor
	public IntLinkedList() {
		// set to default values
		head = null;
		current = null;
		previous = null;
	}
	
	// adds new node to the end of the list
	public void add(int aData) {
		// create new node with parameter data
		ListNode newNode = new ListNode(aData, null);
		
		// special case: empty list
		if (head == null) {
			head = newNode;
			current = newNode;
			return;
		}
		
		// otherwise, traverse list until we reach the end, and add the new node
		ListNode temp = head;
		while (temp.link != null)
			temp = temp.link;
		temp.link = newNode;
	}
	
	// adds new node after the current node
	public void addAfterCurrent(int aData) {
		// assuming current is null, cannot add element after null element
		if (current == null)
			return;
		
		// construct new node, then insert after current node
		ListNode newNode = new ListNode(aData, current.link);
		current.link = newNode;
	}
	
	// prints out the list
	public void print() {
		ListNode temp = head;
		System.out.println("In order: ");
		while (temp != null) {
			System.out.print(temp.data + "  ");
			temp = temp.link;
		}
		System.out.println();
	}
	
	// retrieves current element data
	public int getCurrent() {
		if (current == null)
			return 0;
		return current.data;
	}
	
	// sets current element data
	public void setCurrent(int aData) {
		if (current == null)
			return;
		current.data = aData;
	}
	
	// returns length of list
	public int getListLength() {
		if (head != null) {
			ListNode temp = head;
			int length = 1;
			while (temp.link != null) {
				temp = temp.link;
				length++;
			}
			return length;
		}
		return 0;
	}
	
	// sets current to next element in the list (only if current and next elements are != null)
	public void gotoNext() {
		if (current != null && current.link != null) {
			previous = current;
			current = current.link;
		}
	}
	
	// sets current to previous element in list (only if != null and != head)
	public void gotoPrev() {
		if (current != null && current != head) {
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
	}
	
	// returns true if current is != null
	public boolean hasMore() {
		return current != null;
	}
	
	// moves current back to head
	public void reset() {
		current = head;
		previous = null;
	}

	// removes current element, resets links properly
	public void removeCurrent() {
		// case 1: current is in the middle of the list (or last)
		if (current != null && previous != null) {
			previous.link = current.link;
			current = current.link;
		}
		// case 2: current is the head
		else if (current != null && previous == null) {
			head = head.link;
			current = head;
		}
	}

}
