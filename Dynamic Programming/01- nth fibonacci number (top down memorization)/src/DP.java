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
		// if n has been encountered before, return memo[n]
		if (memo[n] != -1)
			return memo[n];
		
		// base condition for fibonacci
		if (n==0 || n==1)
			memo[n] = n;
		else
			memo[n] = fib(n-1) + fib(n-2);
		return memo[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		memo = new int[n+1];
		Arrays.fill(memo, -1);
		System.out.println(n + "th fibonacci number: " + fib(n));
		System.out.println(Arrays.toString(memo));

	}

}
