import java.util.Arrays;
/*
 * Given an array arr[] denoting heights of N towers and a positive integer K, you 
 * have to modify the height of each tower either by increasing or decreasing them 
 * by K only once. After modifying, height should be a non-negative integer. 
 * 
 * Find out the minimum possible difference of the height of shortest and longest 
 * towers after you have modified each tower.
 * 
 * Input:
 * K = 3, N = 5
 * Arr[] = {3, 9, 12, 16, 20}
 * Output:
 * 11
 * Explanation:
 * The array can be modified as
 * {6, 12, 9, 13, 17}. The difference between 
 * the largest and the smallest is 17-6 = 11. 
 * 
 * Idea:
 * We will get the minimum if we sort the array and perform the increment/decrement
 * on neighboring elements
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 */
public class Greedy {
	static int getMinDiff(int[] arr, int n, int k) {
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		// Maximum possible height difference
		int ans = arr[n - 1] - arr[0];
		
		int smallest = arr[0] + k;
		int largest = arr[n - 1] - k;
		System.out.println("smallest: " + smallest + ", largest: " + largest);

		int min, max;

		for (int i = 0; i < n - 1; i++) {
			min = Math.min(smallest, arr[i + 1] - k);
			max = Math.max(largest, arr[i] + k);
			if (min < 0)
				continue;
			ans = Math.min(ans, max - min);
			System.out.println("Min: " + min + ", Max: " + max + ", Answer: " + ans);
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 6, 3, 4, 7, 2, 10, 3, 2, 1 };
		int k = 5;
		int n = arr.length;
		System.out.println(getMinDiff(arr, n, k));

	}

}
