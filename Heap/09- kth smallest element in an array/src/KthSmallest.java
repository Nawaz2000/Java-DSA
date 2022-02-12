import java.util.PriorityQueue;
/*
 * Kth smallest element in an array.
 * Given an array = {7,10,4,3,20,15} and k = 3, we have to find the kth smallest
 * element in the array
 * 
 * Idea:
 * Use a min heap and extract k elements. the last element extracted is the answer
 * 
 * Time complexity: O(k*logn)
 * Auxiliary Space: O(n)
 */
public class KthSmallest {
	public static int kthSmallest(int[] arr, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (int x : arr)
			minHeap.offer(x);
		for (int i=1; i<k; i++)
			minHeap.poll();
		return minHeap.poll();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7,10,4,3,20,15};
		int k = 3;
		System.out.println(kthSmallest(arr, k));

	}

}
