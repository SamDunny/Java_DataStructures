// by Sam Dunny

package Lab06_FruitTree;

// extending so we can compare types in the tree (must implement comparable interface)
public class LinkedBinarySearchTree <T extends Comparable<T>> {

	// internal Node class
	private class Node {
		// instance variables
		T data;
		Node leftChild;
		Node rightChild;
		
		// default constructor
		public Node(T aData) {
			data = aData;
			leftChild = null;
			rightChild = null;
		}
	}
	
	// instance variables
	// first element in the tree
	private Node root;
	
	// default constructor
	public LinkedBinarySearchTree() {
		// creates empty tree
		root = null;
	}
	
	// add method, call-able and non-recursive
	public void add(T aData) {
		// make root the new node if tree is empty
		if (root == null)
			root = new Node(aData);
		else
			// recursively add the elements
			add(root, aData);
	}
	
	// add helper method, non-call-able and recursive
	private Node add(Node aNode, T aData) {
		if (aNode == null)
			aNode = new Node(aData);
		// aData was less than data at the node, go left
		else if (aData.compareTo(aNode.data) < 0)
			aNode.leftChild = add(aNode.leftChild, aData);
		
		// aData was greater than data at the node, go right
		else if (aData.compareTo(aNode.data) > 0)
			aNode.rightChild = add(aNode.rightChild, aData);
		
		return aNode;
	}
	
	// printPreOrder method, call-able and non-recursive
	public void printPreOrder() {
		printPreOrder(root);
	}
	
	// printPreOrder helper method, non-call-able and recursive
	private void printPreOrder(Node aNode) {
		if (aNode == null)
			return;
		// process
		System.out.println(aNode.data);
		
		// left
		printPreOrder(aNode.leftChild);
		
		// right
		printPreOrder(aNode.rightChild);
	}
	
	// printInOrder method, call-able and non-recursive
	public void printInOrder() {
		printInOrder(root);
	}
	
	// printInOrder helper method, non-call-able and recursive
	private void printInOrder(Node aNode) {
		if (aNode == null)
			return;
		// left
		printInOrder(aNode.leftChild);
		
		// process
		System.out.println(aNode.data);
		
		// right
		printInOrder(aNode.rightChild);
	}
	
	// printPostOrder method, call-able and non-recursive
	public void printPostOrder() {
		printPostOrder(root);
	}
		
	// printPostOrder helper method, non-call-able and recursive
	private void printPostOrder(Node aNode) {
		if (aNode == null)
			return;
		// left
		printPostOrder(aNode.leftChild);
		
		// right
		printPostOrder(aNode.rightChild);
		
		// process
		System.out.println(aNode.data);
	}

	// search method, call-able and non-recursive
	public boolean search(T aData) {
		return search(root, aData);
	}
	
	// search helper method, non-call-able and recursive
	private boolean search(Node aNode, T aData) {
		// reached a leaf, value was never found
		if (aNode == null)
			return false;
		// target value was less than this node's value, go left
		else if (aData.compareTo(aNode.data) < 0)
			return search(aNode.leftChild, aData);
		
		// target value was greater than this node's value, go right
		else if (aData.compareTo(aNode.data) > 0)
			return search(aNode.rightChild, aData);
		
		// target value = node's value
		else 
			return true;		
	}
	
	// remove method, call-able and non-recursive
	public void remove(T aData) {
		// updates roots reference if the root changes
		root = remove(root, aData);
	}
	
	// remove helper method, non-call-able and recursive
	private Node remove(Node aNode, T aData) {
		// reached a leaf, value was never found
		if (aNode == null)
			return null;
		
		// target value was less than this node's value, go left
		else if (aData.compareTo(aNode.data) < 0)
			aNode.leftChild = remove(aNode.leftChild, aData);
		
		// target value was greater than this node's value, go right
		else if (aData.compareTo(aNode.data) > 0)
			aNode.rightChild = remove(aNode.rightChild, aData);
		
		// target value = node's value
		else {
			/* left child can exist or be null, gets returned regardless
			 * 	(1) returns null, meaning the node had no children to replace it
			 * 	(2) returns left child to replace node
			 */
			if (aNode.rightChild == null)
				return aNode.leftChild;
			
			/* right child cannot be null at this point 
			 * 	(1) returns right child to replace node
			 */
			else if (aNode.leftChild == null)
				return aNode.rightChild;
			
			// node has two children
			// finds minimum value in right tree
			Node temp = findMinInTree(aNode.rightChild);
			
			// sets deleted node to that minimum value
			aNode.data = temp.data;
			
			// removes the duplicate from right subtree
			aNode.rightChild = remove(aNode.rightChild, temp.data);
		}
		// returns the newly set node (or non-changed node)
		return aNode;
	}
	
	// finds the minimum value in a tree
	private Node findMinInTree(Node aNode) {
		if (aNode == null)
			return null;
		
		// if no left child, node is smallest in tree
		if (aNode.leftChild == null)
			return aNode;
		else
			// search for smallest value in right child
			return findMinInTree(aNode.leftChild);
	}

}
