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
 */
public class DP {
	static int lcs(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int[][] memo = new int[n+1][m+1];
		
		//Note- the first row and column of memo is always 0
		 		
		// we start from index 1 as i,j denotes the length of s1, s2 characters of string does not
		// exist when length = 0, we start from index 1.
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1))
					memo[i][j] = 1 + memo[i-1][j-1];
				else
					memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
			}
		}
		
		return memo[n][m];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "sunday";
	    String s2 = "saturday";
	    System.out.println("Max length: " + lcs(s1, s2));

	}

}
