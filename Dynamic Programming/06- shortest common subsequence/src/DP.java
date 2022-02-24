/*
 * Given two strings X and Y of lengths m and n respectively, find the length of the smallest 
 * string which has both, X and Y as its sub-sequences. 
 * 
 * Note: X and Y can have both uppercase and lowercase letters.
 * 
 * Input:
 * X = abcd, Y = xycd
 * Output: 6
 * Explanation: Shortest Common Supersequence
 * would be abxycd which is of length 6 and
 * has both the strings as its subsequences.
 * 
 * Idea:
 * 1. find lcs
 * 2. return lcs + (n-lcs) + (m-lcs)
 * 
 * Time complexity: O(n*m)
 * Space complexity: O(n*m)
 */
public class DP {
	public static int shortestCommonSupersequence(String X,String Y,int n,int m)
    {
        int[][] memo = new int[n+1][m+1];
        
        // finds lcs
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                if (X.charAt(i-1) == Y.charAt(j-1))
                    memo[i][j] = 1 + memo[i-1][j-1];
                else
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
            }
        }
        
        int lcs = memo[n][m];       
        int count = lcs + (n-lcs) + (m-lcs);        
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String X = "abcd", Y = "xycd";
		System.out.println("Length of smallest string: " + shortestCommonSupersequence(X, Y, X.length(), Y.length()));

	}

}
