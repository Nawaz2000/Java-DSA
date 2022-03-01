import java.util.Arrays;
/*
 * Given a rope of size n, and an array arr[] whose elements denote the length of cuts we can,
 * cut the rope into, find the maximum number of pieces the rope can be cut into.
 * 
 * i/p:
 * arr[] = {1,5,4}, n=9
 * o/p: 9
 * 
 * i/p:
 * arr[] = {2,3}, n=7
 * o/p: 3 (cuts: 2,2,3)
 * 
 * Time complexity: O(n*m)
 * Auxiliary space: O(n)
 */
public class DP {
	static int[] memo;
	
	static int cutRod(int[] arr, int n) {
		for (int sum=1; sum<=n; sum++) {
			for (int j=0; j<arr.length; j++) {
				if (sum-arr[j] >= 0)
					memo[sum] = Math.max(memo[sum], memo[sum-arr[j]]);
			}
			
			if (memo[sum] != -1)
				memo[sum]++;
		}
		return memo[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,3};
        int target = 7;
        memo = new int[target+1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        System.out.println("Maximum Obtainable Value is " +
                            cutRod(arr, target));
//        System.out.println(Arrays.toString(memo));

	}

}
