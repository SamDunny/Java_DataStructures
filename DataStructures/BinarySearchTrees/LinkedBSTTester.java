package DataStructures.BinarySearchTrees;

public class LinkedBSTTester {

	// can only use LinkedBinarySearchTree if the data is comparable in some way
	public static void main(String[] args) {

		// instantiate new LinkedBinarySearchTree
		LinkedBinarySearchTree<Integer> iBST = new LinkedBinarySearchTree<Integer>();
		
		// adding values to the tree
		iBST.add(8);
		iBST.add(2);
		iBST.add(12);
		iBST.add(1);
		iBST.add(4);
		iBST.add(10);
		iBST.add(16);

		// print pre-order (pass by left)
		System.out.println("--- TESTING .printPreOrder ---");
		iBST.printPreOrder();
		
		// print in order (pass underneath)
		System.out.println("\n--- TESTING .printInOrder ---");
		iBST.printInOrder();
		
		// print post-order (pass by right)
		System.out.println("\n--- TESTING .printPostOrder ---");
		iBST.printPostOrder();
		
		int val1 = 4;
		System.out.println("\n--- TESTING .search WITH " + val1 + " ---");
		System.out.println(iBST.search(val1));
		
		int val2 = 10;
		System.out.println("\n--- TESTING .remove WITH " + val2 + " ---");
		iBST.remove(val2);
		iBST.printInOrder();
	}

}
