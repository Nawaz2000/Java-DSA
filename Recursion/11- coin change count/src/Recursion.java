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
 * Time complexity: O(n^m)
 */
public class Recursion {

	static int getCount(int[] coins, int n, int sum) {
		// if sum is 0, there is only one way i.e., we are not considering any coin
		if (sum == 0) 
			return 1;
		
		// if n=0, that means we are not considering any coin
		if (n == 0)
			return 0;
		
		// we are not considering the last coin
		int res = getCount(coins, n-1, sum);
		
		// we are considering the last coin
		if (coins[n-1] <= sum)
			res = res + getCount(coins, n, sum-coins[n-1]);
		
		return res;
	}

	public static void main(String[] args) {
		int[] coins = {1,2,3};
		int sum = 4;
		int n = coins.length;
		System.out.println(getCount(coins, n, sum));

	}

}
