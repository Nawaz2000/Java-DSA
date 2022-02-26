
public class DP {
	static int getCount(int[] coins, int n, int sum) {
		if (sum == 0) 
			return 1;
		if (n == 0)
			return 0;
		int res = getCount(coins, n-1, sum);
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
