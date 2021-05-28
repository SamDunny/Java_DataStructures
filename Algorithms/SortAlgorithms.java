package Algorithms;

// by Sam Dunny

public class SortAlgorithms {

	public static void main(String[] args) {
		System.out.println("--- Original Array ---");
		int[] array = {10,8,7,6,12,5,11,9};
		for (int i : array)
			System.out.println(i);
		
		System.out.println("\n--- TESTING mergeSort ---");
		mergeSort(array);
		for (int i : array)
			System.out.println(i);
		
		System.out.println("\n--- TESTING quickSort ---");
		quickSort(array);
		for (int i : array)
			System.out.println(i);
	}
	
	// merge-sort method
	public static void mergeSort(int[] a) {
		// retrieve array size, ensure it is greater than 2
		int size = a.length;
		if (size < 2)
			return;
		
		// calculate mid index
		int mid = size/2;
		
		// calculate split array sizes
		int leftSize = mid;
		int rightSize = size-mid;
		
		// initialize left and right array branches
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];
		
		// populate left branch with the first 0 -> (mid-1) numbers
		for (int i = 0; i < mid; i++)
			left[i] = a[i];
		
		// populate right branch with the mid -> (end-1) numbers
		for (int i = mid; i < size; i++)
			// assign starting at 0 index in right[]
			right[i-mid] = a[i];
		
		// recursively call mergeSort on both left and right arrays until they are only 1 element arrays
		mergeSort(left);
		mergeSort(right);
		
		// merge
		merge(left, right, a);
	}
	
	// merge-sort helper, merges together 2 sorted arrays into 1 sorted array
	public static void merge(int[] left, int[] right, int[] a) {
		int leftSize = left.length;
		int rightSize = right.length;
		
		// left arrays index
		int i = 0;
		
		// right arrays index
		int j = 0;
		
		// merged arrays index
		int k = 0;
		
		// ensures we exhaust at least one array
		while (i < leftSize && j < rightSize) {
			// assuming left's value was <= right's value
			if (left[i] <= right[j]) {
				a[k] = left[i];
				i++;
				k++;
			}
			else {
				a[k] = right[j];
				j++;
				k++;
			}
		}
		
		// ensures we exhaust that final array
		// right array is empty, left still has some elements
		while (i < leftSize) {
			a[k] = left[i];
			i++;
			k++;
		}
		// left array is empty, right still has some elements
		while (j < rightSize) {
			a[k] = right[j];
			j++;
			k++;
		}
	}
	
	// quick-sort method
	public static void quickSort(int[] a) {
		quickSort(a, 0, a.length-1);
	}
	
	// quick-sort helper, quick-sort method
	public static void quickSort(int[] a, int start, int end) {
		// check to see if we've exceeded index values
		if (start >= end)
			return;
		int pivot = partition(a, start, end);
		quickSort(a, start, pivot-1);
		quickSort(a, pivot+1, end);
	}
	
	// quick-sort helper, calculates new pivot index
	public static int partition(int[] a, int start, int end) {
		// pivot point for quick sort is the end of the array
		int pivot = a[end];
		int i = start;
		
		// go through array
		for (int j = start; j <= end; j++) {
			if (a[j] < pivot) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}
		
		int temp = a[i];
		a[i] = a[end];
		a[end] = temp;
		
		// returns where pivot is
		return i;
	}

}
