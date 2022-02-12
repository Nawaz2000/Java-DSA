import java.util.Arrays;

/*
 * Given an array and one node which violates the min-heap property, heapify the array
 * 
 * i/p: {40,20,30,35,25,80,32,100,70,60}
 * o/p: {20,25,30,35,40,80,32,100,70,60}
 * 
 * Idea:
 * In each recursive loop,
 * smallest = Min(root, left, right)
 * if (smallest != root) then swap(smallest, root) and minHeapify(arr,smallest)
 * 
 * Time complexity: O(logn)
 * Space complexity: O(logn)
 */

public class Heap {
	public static void minHeapify(int[] arr, int i) {
		// i is the root of tree/ sub-tree which doesn't follow the min-heap structure
		int l = 2*i+1;
		int r = 2*i+2;
		
		int smallest = i; // stores Min(root, left, right)
		
		// the first two if condition finds the Min(root, left, right)
		if (l<arr.length && arr[l]<arr[i])
			smallest = l;
		if (r<arr.length && arr[r]<arr[smallest])
			smallest = r;
		
		// if smallest == i, that means the current sub-tree is already heapified
		// else swap and heapify
		if (smallest != i) {
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
			
			minHeapify(arr, smallest);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {40,20,30,35,25,80,32,100,70,60};
		minHeapify(arr, 0);
		System.out.println(Arrays.toString(arr));

	}

}
