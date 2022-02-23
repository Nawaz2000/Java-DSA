import java.util.Arrays;
/*
 * Given two sequences, find the length of longest subsequence present in both of 
 * them. Both the strings are of uppercase.
 * 
 * Input:
 * A = 6, B = 6
 * str1 = ABCDGH
 * str2 = AEDFHR
 * 
 * Output: 3
 * Explanation: LCS for input Sequences
 * “ABCDGH” and “AEDFHR” is “ADH” of
 * length 3.
 * 
 * Idea:
 * This is a memorization based technique. The idea is to use the same technique
 * as in the recursion process but here we store every occurrence so that we don't
 * recalculate the overlapping recursions
 * 
 * Time complexity: O(n*m)
 * Auxiliary space: O(n*m)
 */
public class DP {
	// stores the value if (s1[n] == s2[m])
	static int[][] memo;
	
	static int lcs(String s1, String s2, int n, int m) {
		// if encountered before, return the value
		if (memo[n][m] != -1)
			return memo[n][m];
		
		// if it is the first character, we set memo[n][m] to 0
		if (n == 0 || m == 0)
			memo[n][m] = 0;
		else {
			if (s1.charAt(n-1) == s2.charAt(m-1))
				memo[n][m] = 1 + lcs(s1, s2, n-1, m-1);
			else
				memo[n][m] = Math.max(lcs(s1, s2, n-1, m), lcs(s1, s2, n, m-1));
		}
		return memo[n][m];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		int n = s1.length();
		int m = s2.length();
		memo = new int[n+1][m+1];
		for (int[] x : memo)
			Arrays.fill(x, -1);
		System.out.println(lcs(s1, s2, n, m));

	}

}
