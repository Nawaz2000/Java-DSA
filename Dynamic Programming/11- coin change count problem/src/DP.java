import java.util.Arrays;
/*
 * Given an array denoting the denomination of coins and a sum. Find out the number of
 * combinations of currencies that add up to that sum
 * 
 * Ex-
 * i/p: {1,2,3}, sum = 4
 * o/p = 4
 * 
 * Explanation:
 * 4 = 1+1+1+1
 * 4 = 1+1+2
 * 4 = 2+2
 * 4 = 1+3
 * 
 * Idea:
 * Everytime, 
 * Case1: we are reducing the size of array as we are no considering the last coin
 * Case2: we are considering the last coin
 * 
 * Time complexity: O(n*m)
 * Auxiliary space: O(n*m)
 */
public class DP {
	static int getCount(int[] coins, int n, int sum) {
		int[][] memo = new int[sum+1][n+1];
		for (int i=0; i<=n; i++)
			memo[0][i] = 1;

		for (int i=1; i<=sum; i++) {
			for (int j=1; j<=n; j++) {
				// memo[i][j] indicates the number of combination we can get from sum i and
				// coins from 1 to j
				memo[i][j] = memo[i][j-1];
				if (coins[j-1] <= i)
					memo[i][j] += memo[i-coins[j-1]][j];
			}
		}
		
//		for (int[] x : memo)
//			System.out.println(Arrays.toString(x));
		
		return memo[sum][n];
	}

	public static void main(String[] args) {
		int[] coins = {1,2,3};
		int sum = 4;
		int n = coins.length;
		System.out.println(getCount(coins, n, sum));

	}

}
