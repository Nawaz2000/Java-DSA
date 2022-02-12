import java.util.Arrays;

/*
 * Build min heap from a given array
 * 
 * i/p: {40,20,30,35,25,80,32,100,70,60}
 * o/p: {20,25,30,35,40,80,32,100,70,60}
 * 
 * Idea:
 * Start from n/2-1 to 0 as the all nodes above that are leaf nodes
 * 
 * Time complexity: O(nlogn)
 * Space complexity: O(logn)
 */
class MinHeap {
	int[] arr;
	int size, capacity;

	MinHeap(int c) {
		arr = new int[c];
		size = 0;
		capacity = c;
	}

	MinHeap(int[] arr) {
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
			minHeapify(arr, i); // O(logn)
	}
	
	void minHeapify(int[] arr, int i) {
		int smallest = i;
		
		// the below if else part finds the index of the smallest among root, left
		// and right
		if (rightChild(i) < size) {
			if (arr[rightChild(i)] < arr[leftChild(i)] && arr[rightChild(i)] < arr[i])
				smallest = rightChild(i);
			else if (arr[leftChild(i)] < arr[rightChild(i)] && arr[leftChild(i)] < arr[i])
				smallest = leftChild(i);
		}else {
			if (arr[leftChild(i)] < arr[i])
				smallest = leftChild(i);
		}
		
		// if smallest index found is not equal to the root then call it recursively
		// if smallest is i, that means the subtree is already heapified
		if (smallest != i) {
			swap(i, smallest);
			minHeapify(arr, smallest);
		}
	}

	private void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	@Override
	public String toString() {
		return "MinHeap [arr=" + Arrays.toString(arr) + ", size=" + size + ", capacity=" + capacity + "]";
	}

}

public class Heap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {40,20,30,35,25,80,32,100,70,60};
		MinHeap h = new MinHeap(arr);
		System.out.println(h);

	}

}
