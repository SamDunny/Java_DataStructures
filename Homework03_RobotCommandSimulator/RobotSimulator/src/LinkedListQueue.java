package Homework03_RobotCommandSimulator.RobotSimulator.src;

// by Sam Dunny

public class LinkedListQueue <T> {

	// internal ListNode class
	private class ListNode {
		T data;
		ListNode link;
		
		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}
	
	/* instance variables (don't need current or previous) 
	 * adding will always occur at the tail
	 * removing will always occur at the head*/
	private ListNode head;
	private ListNode tail;
	
	// default parameter
	public LinkedListQueue() {
		head= null;
		tail = null;
	}
	
	// add data to the end of the list
	public void enqueue(T aData) {
		// initialize new node with given data
		ListNode newNode = new ListNode(aData, null);
		// if the list is empty
		if (head == null) {
			head = tail = newNode;
			return;
		}
		// otherwise, set links accordingly
		tail.link = newNode;
		tail = tail.link;
	}
	
	// removing and returning first item's data
	public T dequeue() {
		// cannot return anything with empty list
		if (head == null)
			return null;
		
		// save head's data to return after head deletion
		T ret = head.data;
		head = head.link;
		return ret;
	}
	
	// returns data of first item
	public T peek() {
		if (head == null)
			return null;
		return head.data;
	}
	
	// traverse and prints all data in list from head to tail
	public void print() {
		// 'manually' traversing list and printing out all data
		for (ListNode temp = head; temp != null; temp = temp.link)
			System.out.print(temp.data + " ");
		System.out.println();
	}
	
	public boolean hasMore() {
		if (head == null)
			return false;
		return true;
	}
}