import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
/*
 * Given an array and an integer K, find the maximum for each and every contiguous 
 * subarray of size k.
 * 
 * Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3 
 * Output: 3 3 4 5 5 5 6
 * 
 * Idea:
 * 1. Use a deque to store important indexes
 * 2. First traverse arr from i=0 to i<k and in each loop
 * 			Remove from last of dq if arr[i] >= arr[dq.last]
 * 		insert i into last of dq
 * 3. traverse the array from the last position of i to n
 * 		res[j] = arr[dq.first]
 * 		if dq.first is out of curr window (dq.first <= i-k), remove dq.first
 * 		while arr[i] >= arr[dq.last], remove arr.last
 * 4. res[j] = dq.first
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 */
public class SlidingWindowMaximum {
	public static int[] maxInEverySubArrayOfSizeK(int[] arr, int k) {
		int[] res = new int[arr.length-k+1];
		int j = 0;
		Deque<Integer> deque = new LinkedList<Integer>();// insert last, delete first
		
		int i=0;
		for (i=0; i<k; i++) {
			while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()])
				deque.pollLast();
			deque.offerLast(i);
		}
		
		for (; i<arr.length; i++) {
			res[j++] = arr[deque.peekFirst()];
			
			if (!deque.isEmpty() && deque.peekFirst() <= (i-k))
				deque.pollFirst();
			
			while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()])
				deque.pollLast();
			deque.offerLast(i);
		}
		res[j] = arr[deque.peekFirst()];
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 12, 1, 78, 90, 57, 89, 56 };
		int k = 3;
		int[] res = maxInEverySubArrayOfSizeK(arr, k);
		System.out.println(Arrays.toString(res));

	}

}
