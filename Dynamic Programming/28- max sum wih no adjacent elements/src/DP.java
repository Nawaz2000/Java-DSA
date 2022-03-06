import java.math.BigInteger;

/*
 * You are given an array A of size N. You need to find the maximum-sum of the array provided 
 * that you cannot sum neighboring elements. So for each element of the array, you need to 
 * find maximum-sum from initial index till the element's index.
 * 
 * Examples:
 * Input:
 * 4 5 6 7 8
 * 1 2
 * Output:
 * 4 5 10 12 18
 * 1 2
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class DP {
	static void sumArray(int arr[], int n) {
		// Your code here
		int[] dp = new int[n];
		if (n == 1) {
			dp[0] = arr[0];
			System.out.print(dp[0]);
		} else if (n == 2) {
			dp[0] = arr[0];
			dp[1] = arr[1];
			System.out.print(Math.max(dp[0], dp[1]));
		} else {
			dp[0] = arr[0];
			dp[1] = arr[1];
			dp[2] = arr[2] + arr[0];
			for (int i = 3; i < n; i++) {
				dp[i] = arr[i] + Math.max(dp[i - 2], dp[i - 3]);
			}

			for (int j : dp)
				System.out.print(j + " ");

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 5, 10, 100, 10, 5 };
		int n = arr.length;
		sumArray(arr, n);

	}

}
