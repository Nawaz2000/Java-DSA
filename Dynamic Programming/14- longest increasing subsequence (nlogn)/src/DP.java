import java.util.Arrays;

/*
 * Given an array of integers, find the length of the longest (strictly) increasing subsequence 
 * from the given array.
 * 
 * Input:
 * N = 16
 * A[]={0,8,4,12,2,10,6,14,1,9,5
 *      13,3,11,7,15}
 * Output: 6
 * Explanation:Longest increasing subsequence
 * 0 2 6 9 13 15, which has length 6
 * 
 * Idea:
 * 1. use a tail array which stores the LIS
 * 2. set tail[0] = a[0] and start a loop from i=1
 * 3. if currEle > tail[last] then insert currEle into tail
 * 4. else binary search the ceil in tail and replace ceil with currELe
 * 
 * Time complexity: O(nlogn)
 * Auxiliary space: O(n)
 */
public class DP {
	static int binarySearch(int[] tail, int start, int end, int search) {
		while (end > start) {
			int mid = start + (end-start)/2;
			if (search <= tail[mid])
				end = mid;
			else
				start = mid+1;
		}
		
		return end;
	}
	
	static int longestSubsequence(int size, int a[])
    {
		int[] tail = new int[size]; // stores the LIS
		tail[0] = a[0];
		
		int len = 1;
		
		for (int j=1; j<size; j++) {
			if (a[j] > tail[len-1])
				tail[len++] = a[j];
			else {
				int ceil = binarySearch(tail, 0, len-1, a[j]);
				tail[ceil] = a[j];
			}
		}
//		System.out.println(Arrays.toString(tail));
		return len;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,10,20,4,6,7};
		int size = a.length;
		System.out.println(longestSubsequence(size, a));

	}

}
