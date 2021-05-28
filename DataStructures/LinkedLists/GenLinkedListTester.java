package DataStructures.LinkedLists;

// by Sam Dunny

public class GenLinkedListTester {

	public static void main(String[] args) {
		
		GenLinkedList<Integer> iLL = new GenLinkedList<Integer>();
		GenLinkedList<Double> dLL = new GenLinkedList<Double>();
		GenLinkedList<String> strLL = new GenLinkedList<String>();
		
		for (int i = 0; i < 5; i++) {
			iLL.add(i);
			dLL.add((double)i);
			strLL.add("str: " + i);
		}
		
		iLL.print();
		System.out.println();
		dLL.print();
		System.out.println();
		strLL.print();
		System.out.println();
		
	}

}
