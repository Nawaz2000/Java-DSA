/*
 * Given two strings word1 and word2, return the minimum number of steps required to make word1 
 * and word2 the same. In one step, you can delete exactly one character in either string.
 * 
 * Input: word1 = "sea", word2 = "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * 
 * Idea:
 * 1. find lcs
 * 2. count = (word1.length() - lcs) + (word2.length()-lcs)
 * 
 * Time complexity: O(n*m)
 * Space complexity: O(n*m)
 */
public class DP {
	public int minDistance(String s1, String s2) {
        int n = s1.length();
		int m = s2.length();
		int[][] memo = new int[n+1][m+1];
        
		// find the lcs
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1))
					memo[i][j] = 1 + memo[i-1][j-1];
				else
					memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
			}
		}
        
        int lcs = memo[n][m];
        
        int count = 0;
        
        count = s1.length() - lcs;
        count += s2.length() - lcs;
        
        return count;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
