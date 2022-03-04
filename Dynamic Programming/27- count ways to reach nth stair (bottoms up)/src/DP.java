/*
 * There are n stairs, a person standing at the bottom wants to reach the top. The person can 
 * climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach 
 * the top (order does matter).
 * 
 * Bottoms up approach
 * 
 * Input:
 * n = 4
 * Output: 5
 * Explanation:
 * You can reach 4th stair in 5 ways. 
 * Way 1: Climb 2 stairs at a time. 
 * Way 2: Climb 1 stair at a time.
 * Way 3: Climb 2 stairs, then 1 stair
 * and then 1 stair.
 * Way 4: Climb 1 stair, then 2 stairs
 * then 1 stair.
 * Way 5: Climb 1 stair, then 1 stair and
 * then 2 stairs.
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class DP {
	static int countWays(int n) {
		int[] memo = new int[n+1];
		memo[0] = 1;
		memo[1] = 1;
		
		for (int i=2; i<=n; i++)
			memo[i] = (memo[i-1] + memo[i-2])%1000000007;
		
		return memo[n];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		System.out.println("Number of ways: " + countWays(n));

	}

}
