import java.util.Arrays;
/*
 * There are n stairs, a person standing at the bottom wants to reach the top. The person can 
 * climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach 
 * the top (order does matter).
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
	static int[] memo;
	static int countWays(int n) {
		if (n>=0 && memo[n] != -1)
			return memo[n];
		if (n == 0) 
			return 1;
		
		if (n < 0)
			return 0;
		
		int a = countWays(n-1);
		int b = countWays(n-2);
		memo[n] = (a+b)%1000000007;
		return memo[n];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		memo = new int[n+1];
		Arrays.fill(memo, -1);
		memo[0] = 1;
		System.out.println("Number of ways: " + countWays(n));

	}

}
