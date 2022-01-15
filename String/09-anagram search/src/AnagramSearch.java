/*
 * Find if the input string contains any anagram
 * 
 * I've done this using sliding window technique
 * 
 * Time complexity: Theta(n), n-> size of input string
 * Auxiliary space: Theta(1)
 */

import java.util.Arrays;

public class AnagramSearch {

	public static boolean search(String str, String anagram) {
		int[] countAna = new int[256];
		int[] countStr = new int[256];
		
		for (int i=0; i<anagram.length(); i++)
			countAna[anagram.charAt(i)]++;
		
		for (int i=0; i<str.length(); i++) {
			if (i>=anagram.length())
				countStr[str.charAt(i-anagram.length())]--;
			countStr[str.charAt(i)]++;
			if (Arrays.equals(countAna, countStr))
				return true;
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "geeksforgeeks";
		String anagram = "frog";
		System.out.println(search(str, anagram));

	}

}
