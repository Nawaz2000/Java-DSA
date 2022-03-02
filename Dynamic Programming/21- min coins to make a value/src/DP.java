import java.util.Arrays;
/*
 * Given a value val and array coins[], the task is to make the change for val cents, 
 * given that you have an infinite supply of each of coins{coins1, coins2, ..., coinsm} 
 * valued coins. Find the minimum number of coins to make the change. If not possible to 
 * make change then return -1.
 * 
 * Input: V = 11, M = 4,coins[] = {9, 6, 5, 1} 
 * Output: 2 
 * Explanation: Use one 6 cent coin
 * and one 5 cent coin
 * 
 * Time complexity: O(val * coins.length)
 * Auxiliary space: O(val)
 */
public class DP {
	static int[] memo;
	static int minCoinsHelper(int[] coins, int val) {
		// if we find val in memo, just return it. Else move on.
		if (memo[val] != -1)
			return memo[val];
		
		// if sum or val == 0, we need 0 coins to achieve it
		if (val == 0)
			return 0;
		
		int res = Integer.MAX_VALUE; // stores the min number of coins required
		
		// the below loop recursively selects the minimum coins required
		for (int i=0; i<coins.length; i++) {
			if (coins[i] <= val)
				res = Math.min(res, minCoinsHelper(coins, val-coins[i]));
		}
		
		if (res != Integer.MAX_VALUE) {
			memo[val] = res+1;
			return res+1;
		}
		// if no result is found (wrong combination of coins)
		else{
			memo[val] = res;
			return res;
		}
	}
	public static int minCoins(int coins[], int val) 
	{ 
	    memo = new int[val+1];
	    Arrays.fill(memo, -1);
	    int res = minCoinsHelper(coins, val);
	    if (res == Integer.MAX_VALUE)
	        return -1;
	    else
	        return res;
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {25,10,5};
		int val = 30;
		memo = new int[val+1];
		Arrays.fill(memo, -1);
		System.out.println("Minimum required coins: " + minCoins(coins, val));

	}

}
