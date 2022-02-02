/*
 * Given a palindromic string of lowercase English letters palindrome, replace 
 * exactly one character with any lowercase English letter so that the resulting 
 * string is not a palindrome and that it is the lexicographically smallest one 
 * possible.
 * 
 * Return the resulting string. If there is no way to replace a character to make 
 * it not a palindrome, return an empty string.
 * 
 * Input: palindrome = "abccba"
 * Output: "aaccba"
 * Explanation: There are many ways to make "abccba" not a palindrome, such as "zbccba", "aaccba", and "abacba".
 * Of all the ways, "aaccba" is the lexicographically smallest.
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 */
public class BreakPalindrome {

	public static String breakPalindrome(String palindrome) {
		int n = palindrome.length();

		// string with length 1 will always be a palindrome
		if (n == 1)
			return "";

		// the return statement will execute only if all the characters in the
		// given palindrome are not the same
		for (int i = 0; i < n; i++) {
			if (i != (n / 2)) {
				if (palindrome.charAt(i) != 'a')
					return palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1, n);

			}
		}

		// if the code reaches this section, it means that all characters in the
		// palindrome are same
		boolean allA = false; // to check if all characters are 'a'
		if (palindrome.charAt(n - 1) == 'a')
			allA = true;

		if (allA == true)
			return palindrome.substring(0, n - 1) + 'b';
		else {
			int i = 0;
			while (palindrome.charAt(i++) == 'a');
			i--;
			return palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1, n);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "zzz";
		System.out.println("After breaking: " + breakPalindrome(str));

	}

}
