/*
 * Written by JJ Shepherd
 */
public class GenDoubleLinkedListTester {
	public static final int[] TEST_VALS_1 = {0,1,2,3,4,5,6,7,8,9};
	public static final int[] TEST_VALS_2 = {1,3,4,5,6,7,8};
	public static final int[] TEST_VALS_3 = {1,3,-4,5,-6,7,-8};

	public static final String DEC = "------------------------------------------------------\n";
	public static void main(String[] args) {
		printDecorated("Double Linked List Tester");
		GenDoubleLinkedList<Integer> intList = new GenDoubleLinkedList<Integer>();

		System.out.println("SUCCESS: "+insertAndContainsTest(intList)+"\n");
		System.out.println("SUCCESS: "+deleteTest(intList)+"\n");
		System.out.println("SUCCESS: "+modifyingValuesTest(intList)+"\n");
		
		printDecorated("Printing the list");
		intList.print();
	}
	
	public static boolean insertAndContainsTest(GenDoubleLinkedList<Integer> intList)
	{
		printDecorated("Inserting and Contains Test");
		for(int i=0;i<TEST_VALS_1.length;i++)
			intList.add(TEST_VALS_1[i]);
		return valuesMatch(intList,TEST_VALS_1);
	}
	public static boolean deleteTest(GenDoubleLinkedList<Integer> intList)
	{
		printDecorated("Removing Test\nRemoving first item, third item, and last item");
		intList.reset();
		intList.removeCurrent();
		
		intList.gotoNext();
		intList.removeCurrent();

		for(int i=0;i<6;i++)
			intList.gotoNext();
		intList.removeCurrent();
		return valuesMatch(intList,TEST_VALS_2) && valuesNotMatch(intList,TEST_VALS_4);
	}
	public static boolean modifyingValuesTest(GenDoubleLinkedList<Integer> intList)
	{
		printDecorated("Modified Values Test\nChanging all even values to negative values");
		intList.reset();
		while(intList.hasMore())
		{
			if(intList.getCurrent() % 2 == 0)
				intList.setCurrent(-intList.getCurrent());
			intList.gotoNext();
		}
		//This would stop on the last element which also needs to be checked
		//if(intList.getCurrent() % 2 == 0)
			//intList.setCurrent(-intList.getCurrent());
		return valuesMatch(intList,TEST_VALS_3);
	}
	public static boolean valuesMatch(GenDoubleLinkedList<Integer> intList, int[] testVals)
	{
		for(int i=0;i<testVals.length;i++)
			if(!intList.contains(testVals[i]))
				return false;
		return true;
	}
	public static final int[] TEST_VALS_4 = {0,2,9};
	public static boolean valuesNotMatch(GenDoubleLinkedList<Integer> intList, int[] testVals)
	{
		for(int i=0;i<testVals.length;i++)
			if(intList.contains(testVals[i]))
				return false;
		return true;
	}
	public static void printDecorated(String str)
	{
		System.out.println(DEC+str+"\n"+DEC);
	}
}