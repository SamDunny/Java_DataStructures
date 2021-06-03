// by Sam Dunny

package Lab05_SORTSort;

import java.util.Scanner;
public class SORTSort {

    // max amount of words in data structures
    private static final int MAX_SIZE = 10;
    private static final String KEY_WORD = "SORT";
    private static final String EXIT_WORD = "quit";

    // may have null values if arrays arent filled
    public static String[] words = new String[MAX_SIZE];
    public static int[] word_counts = new int[MAX_SIZE];

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
                String temp_Word = words[i];

				a[i] = a[j];
                words[i] = words[j];

				a[j] = temp;
                words[j] = temp_Word;

				i++;
			}
		}
		
		int temp = a[i];
        String temp_Word = words[i];

		a[i] = a[end];
        words[i] = words[end];

		a[end] = temp;
        words[end] = temp_Word;
		
		// returns where pivot is
		return i;
	}

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter up to " + MAX_SIZE + " strings and I will sort by " + KEY_WORD + "’s.  Once you’re done entering sentences enter \"quit\".\n");

        // takes in new line, and adds the word and its count to their respectiuve arrays
        for (int i = 0; i < MAX_SIZE; i++) {
            // capture new user input
            String newLine = keyboard.nextLine();

            // if user enters quit, break
            if (newLine.equalsIgnoreCase(EXIT_WORD))
                break;
            else {
                // store original entry
                words[i] = newLine;
                // convert to all uppercase for comparison
                newLine = newLine.toUpperCase();

                // start count at 0
                int count = 0;
                // loop while the entry still contains the key word
                while (newLine.contains(KEY_WORD.toUpperCase())) {
                    // increase the count, then 'delete' the word from the phrase
                    count++;
                    newLine = newLine.replaceFirst(KEY_WORD.toUpperCase(), "");
                    //System.out.println("AFTER: " + newLine);
                }
                word_counts[i] = count;
            }
        }

        // sort the arrays based on word_count values
        quickSort(word_counts);

        System.out.println("\n" + KEY_WORD + " SORTED!");

        for (int i = 0; i < MAX_SIZE; i++) {
            if (words[i] != null)
                System.out.println(words[i]);
        }

        keyboard.close();
    }
}