package DataStructures.LinkedLists;

// by Sam Dunny

/* This implementation sacrifices speed(-) for memory(-):
 * 	(1) each node has a built in link to the next and previous nodes
 * 	(2) no instantiation of a previous or next node is needed
 * This implementation uses generic data type T, so as to be more versatile
 */

public class GenDoubleLinkedList <T> {

	// internal class ListNode
	private class ListNode {
		// instance variables for internal class
		T data;
		ListNode nextLink;
		ListNode prevLink;
		
		public ListNode(T aData, ListNode aNext, ListNode aPrev) {
			data = aData;
			nextLink = aNext;
			prevLink = aPrev;
		}
	}
	
	// first item in linked list
	private ListNode head;
	// current item in linked list
	private ListNode current;
	
	// default constructor
	public GenDoubleLinkedList() {
		head = null;
		current = null;
	}
	
	// sets current node to the next node
	public void gotoNext() {
		// there is no list to move in
		if (current == null)
			return;
		// otherwise, move current forward
		current = current.nextLink;
	}
	
	// sets current node to the previous node
	public void gotoPrev() {
		// there is no list to move in
		if (current == null)
			return;
		// otherwise, move current forward
		current = current.prevLink;
	}
	
	// returns true if current node != null 
	public boolean hasMore() {
		return current != null;
	}
	
	// sets current pointer back to head (beginning)
	public void reset() {
		current = head;
	}
	
	// returns T data at current node
	public T getCurrent() {
		if (current == null)
			return null;
		return current.data;
	}
	
	// sets current node's data from parameter value
	public void setCurrent(T aData) {
		if (current != null)
			current.data = aData;
	}
	
	// creates a new node with aData and adds it to the end of the list
	public void add(T aData) {
		// new instantiation of ListNode (null previous and next links)
		ListNode newNode = new ListNode(aData, null, null);
		// if there are no elements in list, newNode becomes head and current
		if (head == null) {
			head = newNode;
			current = head;
			return;
		}
		// otherwise, traverse list until you get to the last element
		ListNode temp = head;
		// runs until nextLink = null
		while (temp.nextLink != null)
			temp = temp.nextLink;
		// adds new node to the end of the list
		temp.nextLink = newNode;
		// sets previous link to the node behind it
		newNode.prevLink = temp;
	}
	
	// creates a new node with aData and adds it after the current node
	public void addAfterCurrent(T aData) {
		// only add after current if current != null
		if (current == null)
			return;
		// new instantiation of ListNode (nextLink set to current's nextLink (can be null), and prevLink is set to current)
		ListNode newNode = new ListNode(aData, current.nextLink, current);
		// set proper links assuming there is an item after current
		if (current.nextLink != null)
			current.nextLink.prevLink = newNode;
		current.nextLink = newNode;
	}
	
	// removes the current node
	public void removeCurrent() {
		// cannot remove something that doesn't exist
		if (current == null)
			return;
		
		// case 1: the current is also the head
		if (current == head) {
			// moving head to the next element (can be null, if 1 element list)
			head = head.nextLink;
			// assuming this is at least a 2 element list, set links accordingly
			if (head != null)
				head.prevLink = null;
			current = head;
			return;
		}
		
		// case 2: the current is in the list body somewhere
		// removes nextLink reference from the element before current (can be null)
		current.prevLink.nextLink = current.nextLink;
		// assuming there is a next element, set links accordingly
		if (current.nextLink != null)
			current.nextLink.prevLink = current.prevLink;
		// updates current (moving forward)
		current = current.nextLink;
	}
	
	// prints all data contents of the list
	public void print() {
		// make temporary variable, start at beginning of list
		ListNode temp = head;
		// traverse list
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.nextLink;
		}
	}
	
	// returns true of aData is in the list
	public boolean contains(T aData) {
		// using for-loop for some variance in style
		for (ListNode temp = head; temp != null; temp = temp.nextLink)
			// using .equals(), as all base data types are applicable (if using custom classes, must use an overridden .equals() method)
			if (temp.data.equals(aData))
				return true;
		return false;
	}
	
}