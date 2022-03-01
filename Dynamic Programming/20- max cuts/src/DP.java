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
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class DP {
	static int[] memo;
	
	static int cutRod(int[] arr, int n) {
		if (memo[n] != Integer.MIN_VALUE)
			return memo[n];
		System.out.println("n = " + n);
		if (n==0)
			return 0;
		
		int max = Integer.MIN_VALUE;
		for (int i=0; i<arr.length; i++) {
			if (arr[i] <= n)
				max = Integer.max(max, cutRod(arr, n-arr[i]));
			else
				max = -1;
		}
		
		if (max<0) {
			memo[n] = -1;
			return -1;
		}
		
		memo[n] = max+1;
		return max+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,3};
        int target = 7;
        memo = new int[target+1];
        Arrays.fill(memo, Integer.MIN_VALUE);
        System.out.println("Maximum Obtainable Value is " +
                            cutRod(arr, target));
        System.out.println(Arrays.toString(memo));

	}

}
