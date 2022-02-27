import java.util.Arrays;
/*
 * Given two strings str1 and str2 and below operations that can be performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.  
 * 
 * Insert
 * Remove
 * Replace
 * All of the above operations are of equal cost. 
 * 
 * Input:   str1 = "geek", str2 = "gesek"
 * Output:  1
 * We can convert str1 into str2 by inserting a 's'.
 * 
 * Input:   str1 = "cat", str2 = "cut"
 * Output:  1
 * We can convert str1 into str2 by replacing 'a' with 'u'.
 * 
 * Idea:
 * 1. start from the last characters of both the strings
 * 2. if they match, remove the last of both strings
 * 3. if they don't try all combintions (insert, delete, replace) and take the minimum of all + 1
 * 
 * Time complexity: O(n*m)
 * Auxiliary space: O(n*m)
 */
public class DP {
	static int editDistance(String s1, String s2, int n, int m) {
		int[][] memo = new int[n+1][m+1];
		
		// if s1 is empty, then we need to insert all the characters of s2
		for (int j=1; j<=m; j++)
			memo[0][j] = j;
		
		// if s2 is empty, then we need to insert all the characters of s1
		for (int i=1; i<=n; i++)
			memo[i][0] = i;
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				// if the last characters match, then we skip the last characters from both strings
				if (s1.charAt(i-1) == s2.charAt(j-1))
					memo[i][j] = memo[i-1][j-1];
				// if the last characters don't match, try all three combinations
				else
					memo[i][j] = 1 + Math.min(memo[i][j-1], // insert last char of s2 in s1
									 Math.min(memo[i-1][j], // delete last s1
											  memo[i-1][j-1])); // replace last of s1 with s2
			}
		}
		
		for (int[] x : memo)
			System.out.println(Arrays.toString(x));
		
		return memo[n][m];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "cut";
		String s2 = "cat";
		int n = s1.length();
		int m = s2.length();
		System.out.println(editDistance(s1, s2, n, m));

	}

}
