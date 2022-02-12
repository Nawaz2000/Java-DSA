import java.util.Arrays;

/*
 * Build max heap from a given array
 * 
 * i/p: {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17}
 * o/p: {17, 15, 13, 9, 6, 5, 10, 4, 8, 3, 1}
 * 
 * Idea:
 * Start from n/2-1 to 0 as the all nodes above that are leaf nodes
 * 
 * Time complexity: O(nlogn)
 * Space complexity: O(logn)
 */
class MaxHeap {
	int[] arr;
	int size, capacity;

	MaxHeap(int c) {
		arr = new int[c];
		size = 0;
		capacity = c;
	}

	MaxHeap(int[] arr) {
		this.arr = arr;
		size = arr.length;
		capacity = arr.length;
//		System.out.println(size);
		buildHeap(arr);
	}

	int leftChild(int i) {
		return 2 * i + 1;
	}

	int rightChild(int i) {
		return 2 * i + 2;
	}

	int parent(int i) {
		return (i - 1) / 2;
	}

	// for each non-leaf node, heapify from end of array towards front
	void buildHeap(int[] arr) {
		for (int i = (size / 2) - 1; i >= 0; i--) // O(n)
			maxHeapify(arr, i); // O(logn)
	}
	
	void maxHeapify(int[] arr, int i) {
		int largest = i; // stores the index of the largest among root, left, right
		int l = leftChild(i);
		int r = rightChild(i);
		// the below if else part finds the index of the largest among root, left
		// and right
		if (r < size) {
			if (arr[r] > arr[l] && arr[r] > arr[i])
				largest = r;
			else if (arr[l] > arr[r] && arr[l] > arr[i])
				largest = l;
		}else {// executes if the root doesn't have a right child
			if (l<size && arr[l] > arr[i])
				largest = l;
		}
		
		// if largest index found is not equal to the root then call it recursively
		// if largest is i, that means the subtree is already heapified
		if (largest != i) {
			swap(i, largest);
			maxHeapify(arr, largest);
		}
	}

	private void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	@Override
	public String toString() {
		return "MaxHeap [arr=" + Arrays.toString(arr) + ", size=" + size + ", capacity=" + capacity + "]";
	}

}

public class Heap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
		MaxHeap h = new MaxHeap(arr);
		System.out.println(h);

	}

}
