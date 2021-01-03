// by Sam Dunny

/* This class was created for analyzing purposes
 * 	(1) This class analyzes strings based on vowel and consonant amounts
 * 	(2) This class provides accessors for all instance variables
 */
public class Word {

	// instance variables
	private String word;
	private int vowels;
	private int consonants;
	
	// parameterized 'constructor'
	public Word(String aWord) {
		// passed argument to helper function to calculate instance variables
		this.analyzeWord(aWord);
	}

	// helper function, calculates vowel and consonant amounts
	private void analyzeWord(String aWord) {
		// exit program if word memory is null
		if(aWord == null)
			return;
		
		// set word instance variable
		this.word = aWord;
		
		// set to lower case to reduce character checks
		aWord = aWord.toLowerCase();
		
		// count variable keeps track of vowel count
		int count = 0;
		
		// find and count all vowels
		for (int i = 0; i < aWord.length(); i++) {
			if (aWord.charAt(i) == 'a' ||
					aWord.charAt(i) == 'e' ||
					aWord.charAt(i) == 'i' ||
					aWord.charAt(i) == 'o' ||
					aWord.charAt(i) == 'u' ||
					aWord.charAt(i) == 'y') {
				count++;
			}
		}
		
		// set vowels and consonants intance variables
		this.vowels = count;
		this.consonants = aWord.length() - count;
	}
	
	// word accessor
	public String getWord() {
		return this.word;
	}
	
	// vowels accessor
	public int getVowels() {
		return this.vowels;
	}
	
	// consonants accessor
	public int getConsonants() {
		return this.consonants;
	}
}
