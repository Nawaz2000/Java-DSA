import java.util.Stack;

/*
 * Given two strings, print the lcs
 * 
 * Input:
 * X = "AGGTAB", Y = "GXTXAYB"
 * Output: GTAB
 * 
 * Idea:
 * 1. loop through the memo array from index (n,m) till i>0 && j>0
 * 2. if s1[i-1] == s2[j-1], put it into a stack and decrement both i and j by i
 * 3. else 
 * 4. if memo[i-1][j] > memo[i][j-1] decrement i by 1
 * 5. else decrement j by 1
 * 
 * Time complexity: O(max(n,m))
 * Auxiliary space: O(max(n,m))
 */
public class DP {
	private static void printLcs(int[][] memo, String s1, String s2) {
		int i = s1.length();
		int j = s2.length();
		
		// holds the lcs
		Stack<Character> stack = new Stack<Character>();
		while (i>0 && j>0) {
			if (s1.charAt(i-1) == s2.charAt(j-1)) {
				stack.push(s1.charAt(i-1));
				i = i-1;
				j = j-1;
			}else {
				if (memo[i-1][j] > memo[i][j-1])
					i = i-1;
				else
					j = j-1;
			}
				
		}
		
		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");
		
	}
	
	static void lcs(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int[][] memo = new int[n+1][m+1];
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1))
					memo[i][j] = 1 + memo[i-1][j-1];
				else
					memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
			}
		}
		
		printLcs(memo, s1, s2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "geeksforgeeks";
	    String s2 = "esforkmn";
	    lcs(s1, s2);

	}

}
