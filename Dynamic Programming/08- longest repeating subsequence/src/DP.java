/*
 * Given a string str, find the length of the longest repeating subsequence such that it can be 
 * found twice in the given string. The two identified subsequences A and B can use the same ith 
 * character from string str if and only if that ith character has different indices in A and B.
 * 
 * Input:
 * str = "axxxy"
 * Output: 2
 * Explanation:
 * The given array with indexes looks like
 * a x x x y 
 * 0 1 2 3 4
 * 
 * The longest subsequence is "xx". 
 * It appears twice as explained below.
 * 
 * subsequence A
 * x x
 * 0 1  <-- index of subsequence A
 * ------
 * 1 2  <-- index of str 
 * 
 * 
 * subsequence B
 * x x
 * 0 1  <-- index of subsequence B
 * ------
 * 2 3  <-- index of str 
 * 
 * We are able to use character 'x' 
 * (at index 2 in str) in both subsequences
 * as it appears on index 1 in subsequence A 
 * and index 0 in subsequence B.
 * 
 * Idea:
 * find the lcs of the given string with itself. Only this time if the characters match increment
 * only if i and j are different
 * 
 * Time complexity: O(n*m)
 * Space complexity: O(nm)
 */
public class DP {
	static int[][] memo;

	static int lcs(String s1, String s2, int n, int m) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j)// what changes then normal lcs
					memo[i][j] = 1 + memo[i - 1][j - 1];
				else
					memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
			}
		}
		return memo[n][m];
	}

	public int LongestRepeatingSubsequence(String str) {
		int n = str.length();
		int m = n;
		memo = new int[n + 1][m + 1];
		return lcs(str, str, n, m);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
