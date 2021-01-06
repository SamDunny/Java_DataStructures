// by Sam Dunny

import java.util.*;
public class SumAllCombinations {

	// constant for size of array
	public static final int SIZE = 5;
	
	// constant for range of numbers allowed in the array
	public static final int RANGE = 100;
	
	// main method
	public static void main(String[] args) {
		System.out.println("Welcome to the sum of all combinations program!");
		
		// declare new array
		int[] a = new int[SIZE];
		// populate it
		populateRandomArray(a);
		
		// provided test array
		//int[] a = {1,2,3,4,5};
		
		sumAndPrintComb(a);
	}
	
	// populates given array with random values within range
	public static void populateRandomArray(int[] a) {
		Random r = new Random();
		System.out.print("Given array = {");
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(RANGE);
			System.out.print(a[i]+" ");
		}
		System.out.println("}, all summed combinations are: ");
	}
	
	// initial function
	public static void sumAndPrintComb(int[] a) {
		sumAndPrintComb(a, new int[1], 0, 1);
	}
	
	// recursive method
	public static void sumAndPrintComb(int[] a, int[] workingArray, int currI, int currD) {
		// if current index or current depth exceed array size, return
		if (currI >= a.length || currD > a.length)
			return;
		
		// construct new temp array for all combinations with currD terms
		int[] c = new int[currD];
		
		// determine what terms are in the temp array
		for (int i = 0; i < workingArray.length; i++)
			c[i] = workingArray[i];
		c[c.length-1] = a[currI];
		
		// print temp array
		print(c);
		
		// ensuring we calculate all sums with incrementing length (depth)
		sumAndPrintComb(a, c, currI+1, currD+1);
		
		// ensuring we calculate all sums of same number of terms (breadth)
		sumAndPrintComb(a, c, currI+1, currD);
	}
	
	// prints out sum of current temporary array
	public static void print(int[] a) {
		System.out.print(a[0]);
		for (int i = 1 ; i < a.length; i++)
			System.out.print(" + " + a[i]);
		System.out.println(" = " + sum(a));
	}
	
	// calculates sum of surrent temporary array
	public static int sum(int[] a) {
		int ret = 0;
		for (int i = 0; i < a.length; i++)
			ret += a[i];
		return ret;
	}

}
