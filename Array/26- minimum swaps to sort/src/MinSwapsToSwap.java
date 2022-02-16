import java.util.Arrays;
import java.util.HashMap;
/*
 * Given an array of n distinct elements. Find the minimum number of swaps required 
 * to sort the array in strictly increasing order.
 * 
 * Input:
 * arr = {10, 19, 6, 3, 5}
 * Output:
 * 2
 * Explanation:
 * swap 10 with 3 and swap 19 with 5.
 * 
 * Time complexity: O(nlogn)
 * Auxiliary space: O(n)
 */
public class MinSwapsToSwap {
	static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	
	static int findMinSwaps(int[] arr) {
		int count = 0;
		int n = arr.length;
		int[] sorted = Arrays.copyOfRange(arr, 0, n);
		// stores the original array's elements as keys and indexes as values
		// makes fetching elements and indexes in O(1) for each call
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i=0; i<n; i++)
			map.put(arr[i], i);
		
		Arrays.sort(sorted);
		
		for (int i=0; i<n; i++) {
			if (arr[i] != sorted[i]) {
				count++;
				int curr = arr[i];
				swap(arr, i, map.get(sorted[i]));				
				map.put(curr, map.get(sorted[i]));
				map.put(sorted[i], i);
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,5,2,1,5};
		System.out.println(findMinSwaps(arr));

	}

}
