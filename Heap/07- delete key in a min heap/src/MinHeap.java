import java.util.Arrays;

/*
 * Given a min heap and an index(i) delete value at index i in such a way that the 
 * min heap condition persists
 * 
 * Idea:
 * decrease the to be deleted key to -infinity
 * now the -infinity comes to the top position on min heap
 * extract top
 * 
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */
public class MinHeap {
	public static int parent(int i) {
		return (i-1)/2;
	}
	
	public static void decreaseKey(int[] arr, int i, int x) {
		arr[i] = x;
		while (i!=0 && arr[parent(i)] > arr[i]) {
			int temp = arr[i];
			arr[i] = arr[parent(i)];
			arr[parent(i)] = temp;
			
			i = parent(i);
		}
	}
	
	public static void minHeapify(int[] arr, int i) {
		int smallest = i;
		int l = 2*i+1;
		int r = 2*i+2;
		
		if (l<arr.length && arr[l]<arr[i])
			smallest = l;
		if (r<arr.length && arr[r]<arr[smallest])
			smallest = r;
		
		if (smallest != i) {
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
			
			minHeapify(arr, smallest);
		}
	}
	
	public static void extractMin(int[] arr, int size) {
		arr[0] = arr[size-1];
		minHeapify(arr, 0);
		arr[size-1] = -1;
	}
	
	public static void delete(int[] arr, int i) {
		decreaseKey(arr, i, Integer.MIN_VALUE);
		extractMin(arr, arr.length);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {20,25,30,35,40,80,32,100,70,60};
		System.out.println("Before:");
		System.out.println(Arrays.toString(arr));
		
		int i = 4;
		System.out.println("After deleting arr["+i+"]: ");
		delete(arr, i);
		System.out.println(Arrays.toString(arr));

	}

}
