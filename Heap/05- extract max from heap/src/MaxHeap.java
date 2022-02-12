import java.util.Arrays;

/*
 * Given a max heap, extract the max from the heap in such a way that the resultant
 * heap maintains the max heap property
 * 
 * Idea:
 * arr[0] is always the extract result.
 * After removing arr[0], replace arr[0] with arr[size-1] and perform maxHeapify
 * 
 * Time complexity: O(logn)
 */
public class MaxHeap {
	public static int extractMax(int[] arr, int size) {
		int res = arr[0];
		arr[0] = arr[size-1];
		maxHeapify(arr, 0);
		arr[size-1] = -1;
		return res;
	}

	private static void maxHeapify(int[] arr, int i) {
		int largest = i;
		int l = 2*i+1;
		int r = 2*i+2;
		
		if (l<arr.length && arr[l]>arr[i])
			largest = l;
		
		if (r<arr.length && arr[r]>arr[largest])
			largest = r;
		
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			maxHeapify(arr, largest);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {17, 15, 13, 9, 6, 5, 10, 4, 8, 3, 1};
		System.out.println("Before:");
		System.out.println(Arrays.toString(arr));
		
		int i=0, size = arr.length + 1;
		System.out.println("Extract: " + (++i) + ": " + extractMax(arr, --size));
		System.out.println(Arrays.toString(arr));
		
		System.out.println("Extract: " + (++i) + ": " + extractMax(arr, --size));
		System.out.println(Arrays.toString(arr));
		
		System.out.println("Extract: " + (++i) + ": " + extractMax(arr, --size));
		System.out.println(Arrays.toString(arr));

	}

}
