import java.util.Arrays;
/*
 * Given a String, find the longest palindromic subsequence.
 * 
 * Input:
 * S = "bbabcbcab"
 * Output: 7
 * Explanation: Subsequence "babcbab" is the
 * longest subsequence which is also a palindrome.
 * 
 * Idea: 
 * Reverse the given string and return the lcs of both the strings
 * 
 * Time complexity: O(n*m)
 * Space complexity: O(n*m)
 */
public class DP {
	static int[][] memo;
    
    static int lcs(String s1, String s2, int n, int m){
        if (memo[n][m] != -1)
            return memo[n][m];
        if (n==0 || m==0)
            memo[n][m] = 0;
        else{
            if (s1.charAt(n-1) == s2.charAt(m-1))
                memo[n][m] = 1 + lcs(s1, s2, n-1, m-1);
            else
                memo[n][m] = Math.max(lcs(s1, s2, n-1, m), lcs(s1, s2, n, m-1));
        }
        return memo[n][m];
    }
    
    public static int longestPalinSubseq(String S)
    {
        //code here
        StringBuilder sb = new StringBuilder(S);
        String str = sb.reverse().toString();
        int n = S.length();
        int m = n;
        
        memo = new int[n+1][m+1];
        
        for (int[] x : memo)
            Arrays.fill(x, -1);
        
        int lcs = lcs(S, str, n, m);
        
        return lcs;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "bbabcbcab";
		System.out.println("Longest palindromic subsequence: " + longestPalinSubseq(S));

	}

}
