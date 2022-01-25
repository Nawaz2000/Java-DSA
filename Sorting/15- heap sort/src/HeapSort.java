import java.util.Arrays;
/*
 * Heap Sort implementation
 * 
 * Time complexity: O(nlogn)
 * Auxiliary space: O(1)
 */
public class HeapSort {

	public static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
	
	// heapifies a subtree
	// Time complexity: O(logn)
	public static void maxHeapify(int[] arr, int n, int i) {
		int largest = i;
		int left = 2*i + 1; // index of left child
		int right = 2*i + 2; // index of right child
		
		// the next two if conditions finds the index of max(root, lChild, rChild) 
		if (left<n && arr[left]>arr[largest])
			largest = left;
		if (right<n && arr[right]>arr[largest])
			largest = right;
		
		// if the index of the max(root, lChild, rChild) isn't the index of root itself
		// or if root isn't the max among itself, lChild and rChild, it swaps root with
		// largest and calls to maxHeapify on the child with which swapping happened
		if (largest != i) {
			swap(arr, i, largest);
			maxHeapify(arr, n, largest);
		}
	}
	
	public static void heapSort(int[] arr, int n) {
		// heapifies the entire array O(n*logn)
		for (int i=n/2-1; i>=0; i--) {
			maxHeapify(arr, n, i);
		}
		
		// swaps the root with arr[n-1] and calls maxHeapify on arr[n-1-i]
		// this for loop actually sorts the array
		for (int i=n-1; i>0; i--) {
			swap(arr, 0, i);
			maxHeapify(arr, i, 0);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {40,10,30,50,60,15};
		heapSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));

	}

}
