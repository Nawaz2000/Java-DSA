/*
 * Given an String str containing of only lower case characters, we need to count 
 * frequencies of every characters and print them in sorted order we are going to
 * print the result in sorted format 
 */

public class Freq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "geeksforgeeks";
		int[] count = new int[26];
		
		for (int i = 0; i<str.length(); i++)
			count[str.charAt(i) - 'a']++;
		
		for (int i = 0; i<26; i++) {
			if (count[i] != 0) {
				System.out.println((char)(i + 'a') + " " + count[i]);
			}
		}
		
	}

}
