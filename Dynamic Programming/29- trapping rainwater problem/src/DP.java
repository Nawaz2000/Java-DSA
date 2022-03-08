import java.util.Arrays;
/*
 * Given an array arr[] of N non-negative integers representing the height of blocks. If 
 * width of each block is 1, compute how much water can be trapped between the blocks during 
 * the rainy season. 
 * 
 * Input:
 * N = 6
 * arr[] = {3,0,0,2,0,4}
 * Output:
 * 10
 * 
 * Input:
 * N = 3
 * arr[] = {6,9,9}
 * Output:
 * 0
 * 
 * Idea:
 * To make this efficient one must pre-compute the highest bar on the left and right of every 
 * bar in linear time. Then use these pre-computed values to find the amount of water in 
 * every array element.
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class DP {
	static long trappingWater(int arr[], int n) {
		long res = 0;
		int maxOnLeft[] = new int[n]; // max height on the left of it including it
		int maxOnRight[] = new int[n]; // max height on the right of it including it
		maxOnLeft[0] = arr[0];

		// fills maxOnLeft
		for (int i=1; i<n; i++)
			maxOnLeft[i] = Math.max(maxOnLeft[i - 1], arr[i]);

		// fills maxOnRight
		maxOnRight[n-1] = arr[n-1];
		for (int i=n-2; i>=0; i--)
			maxOnRight[i] = Math.max(maxOnRight[i + 1], arr[i]);

		System.out.println("mxL = " + Arrays.toString(maxOnLeft));
		System.out.println("rMax = " + Arrays.toString(maxOnRight));

		for (int i = 1; i < n - 1; i++)
			res += Math.min(maxOnLeft[i], maxOnRight[i]) - arr[i];

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 0, 0, 2, 0, 4 };
		int n = arr.length;
		System.out.println(trappingWater(arr, n));

	}

}
