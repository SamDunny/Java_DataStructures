// by Sam Dunny

public class WordHelper {

	// will sort String[] parameter by vowel count (ascending order)
	public static String[] sortByVowels(String[] words) {
		// convert String[] to Word[] for Word class functionality
		Word[] wArr = strArrToWordArr(words);
		
		// create swapping condition
		boolean hasSwapped = true;
		
		// using bubble sort to sort words by vowels (smallest to largest count)
		while (hasSwapped) {
			hasSwapped = false;
			for (int i = 0; i < wArr.length - 1; i++) {
				if (wArr[i].getVowels() > wArr[i+1].getVowels()) {
					Word temp = wArr[i];
					wArr[i] = wArr[i+1];
					wArr[i+1] = temp;
					hasSwapped = true;
				}
			}
		}
		
		// convert Word[] back to String[] and returning
		return wordArrToStrArr(wArr);
	}
	
	// will sort String[] parameter by consonant count (ascending order)
	public static String[] sortByConsonants(String[] words) {
		// convert String[] to Word[] for Word class functionality
		Word[] wArr = strArrToWordArr(words);
				
		// create swapping condition
		boolean hasSwapped = true;
				
		// using bubble sort to sort words by consonants (smallest to largest count)
		while (hasSwapped) {
			hasSwapped = false;
			for (int i = 0; i < wArr.length - 1; i++) {
				if (wArr[i].getConsonants() > wArr[i+1].getConsonants()) {
					Word temp = wArr[i];
					wArr[i] = wArr[i+1];
					wArr[i+1] = temp;
						hasSwapped = true;
				}
			}
		}
				
		// convert Word[] back to String[] and returning
		return wordArrToStrArr(wArr);
	}
	
	// will sort String[] parameter by string length (ascending order)
	public static String[] sortByLength(String[] words) {
		Word[] wArr = strArrToWordArr(words);
		
		// create swapping condition
		boolean hasSwapped = true;
						
		// using bubble sort to sort words by length (smallest to largest count)
		while (hasSwapped) {
			hasSwapped = false;
			for (int i = 0; i < wArr.length - 1; i++) {
				if (wArr[i].getWord().length() > wArr[i+1].getWord().length()) {
					Word temp = wArr[i];
					wArr[i] = wArr[i+1];
					wArr[i+1] = temp;
						hasSwapped = true;
				}
			}
		}
						
		// convert Word[] back to String[] and returning
		return wordArrToStrArr(wArr);
	}
	
	// private helper method, converts String[] to Word[]
	private static Word[] strArrToWordArr(String[] words) {
		// stop program if words is null
		if (words == null)
			return null;
		
		// create return array, assign all index values
		Word[] ret = new Word[words.length];
		for (int i = 0; i < words.length; i++)
			ret[i] = new Word(words[i]);
		
		// return Word[] array
		return ret;
	}
	
	// private helper method, converts Word[] to String[]
	private static  String[] wordArrToStrArr(Word[] words) {
		// stop program if words is null
		if (words == null)
			return null;
		
		// create return array, assign all index values
		String[] ret = new String[words.length];
		for (int i = 0; i < words.length; i++)
			ret[i] = words[i].getWord();
		
		// return String[] array
		return ret;
	}

}
