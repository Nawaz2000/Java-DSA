/*
 * Fibonacci series using DP (bottom up/ tabulation)
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class DP {
	static int fib(int n) {
		int[] memo = new int[n+1];
		memo[0] = 0;
		memo[1] = 1;
		
		for (int i=2; i<n+1; i++)
			memo[i] = memo[i-1] + memo[i-2];
		
		return memo[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		System.out.println(n + "th fib number = " + fib(n));

	}

}
