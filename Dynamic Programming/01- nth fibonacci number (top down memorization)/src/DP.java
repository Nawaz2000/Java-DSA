import java.util.Arrays;
/*
 * Fibonacci series using DP (top down/ memorization)
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class DP {
	// memo is used to store previous values
	static int[] memo;
	static int fib(int n) {
		if (memo[n] == -1) {
			int res = 0;
			if (n==0 || n==1)
				res = n;
			else
				res = fib(n-1) + fib(n-2);
			memo[n] = res;
		}
		return memo[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		memo = new int[n+1];
		Arrays.fill(memo, -1);
		System.out.println(n + "th fibonacci number: " + fib(n));

	}

}
