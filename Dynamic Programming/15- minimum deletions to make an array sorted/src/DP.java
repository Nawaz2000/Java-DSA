/*
 * Given an array arr of size N, the task is to remove or delete the minimum number of elements 
 * from the array so that when the remaining elements are placed in the same sequence order form 
 * an increasing sorted sequence.
 * 
 * Input: N = 5, arr[] = {5, 6, 1, 7, 4}
 * Output: 2
 * Explanation: Removing 1 and 4
 * leaves the remaining sequence order as
 * 5 6 7 which is a sorted sequence.
 * 
 * Idea:
 * find the longest increasing subsequence and return n-LIS
 * 
 * Time complexity: O(nlogn)
 * Auxiliary space: O(n)
 */
public class DP {
	static int findCeil(int[] memo, int start, int end, int search) {
		while (start < end) {
			int mid = start + (end-start)/2;
			if (search > memo[mid])
				start = mid+1;
			else
				end = mid;
		}
		return end;
	}
	
	static int minDeletions(int[] arr, int n) {
		int[] memo = new int[n];
		int last = 1;
		memo[0] = arr[0];
		
		for (int i=1; i<n; i++) {
			if (arr[i] > memo[last-1])
				memo[last++] = arr[i];
			else {
				int ceil = findCeil(memo, 0, last-1, arr[i]);
				memo[ceil] = arr[i];
			}
		}
		return n-last;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 6, 1, 7, 4};
		int n = arr.length;
		System.out.println(minDeletions(arr, n));

	}

}
