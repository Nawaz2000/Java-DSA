/*
 * Given 3 strings A, B and C, the task is to find the longest common sub-sequence in all three 
 * given sequences.
 * 
 * Input:
 * A = "geeks", B = "geeksfor", 
 * C = "geeksforgeeks"
 * Output: 5
 * Explanation: "geeks"is the longest common
 * subsequence with length 5.
 * 
 * Idea:
 * use same lcs algorithm but this time with memo[][][]
 * 
 * Time complexity: (n1*n2*n3)
 * Auxiliary space: O(n1*n2*n3)
 * 
 * *Note - the complexity can be reduced to quadratic by finding lcs string between two strings
 * and then finding the lcs between then last found lcs string with the third string
 */
public class DP {
	static int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        int[][][] memo = new int[n1+1][n2+1][n3+1];
        for (int i=1; i<=n1; i++){
            for (int j=1; j<=n2; j++){
                for (int k=1; k<=n3; k++){
                    if (A.charAt(i-1) == B.charAt(j-1) && B.charAt(j-1) == C.charAt(k-1))
                        memo[i][j][k] = 1 + memo[i-1][j-1][k-1];
                    else
                        memo[i][j][k] = Math.max(memo[i-1][j][k], Math.max(memo[i][j-1][k], 
                        		memo[i][j][k-1]));
                }
            }
        }
        return memo[n1][n2][n3];
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "geeks", B = "geeksfor", C = "geeksforgeeks";
		System.out.println("LCS length: " + LCSof3(A, B, C, A.length(), B.length(), C.length()));

	}

}
