/*
 * Given an integer. Find how many structurally unique binary search trees are there that 
 * stores the values from 1 to that integer (inclusive).
 * 
 * Time complexity: O(n^2)
 */
public class DP {
	static int numOfBST(int n) {
		int[] memo = new int[n+1];
		memo[0] = 1;
		for (int i=1; i<=n; i++) {
			memo[i] = 0;
			for (int j=0; j<i; j++)
				memo[i] += memo[j] * memo[i-j-1];
		}
		return memo[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		System.out.println(numOfBST(n));

	}

}
