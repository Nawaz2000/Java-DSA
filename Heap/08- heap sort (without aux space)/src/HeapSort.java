import java.util.Arrays;
/*
 * In place heap sort algorithm
 * 
 * Idea:
 * 1. Build a max heap out of the original array.
 * 2. in each loop from n-1 to 0
 * 	a. swap arr[i], arr[0]
 * 	b. remove the last element from maxHeap
 * 
 * Time complexity: O(nlogn)
 * Auxiliary space: O(1)
 * Space complexity: O(logn)
 */
public class HeapSort {
	static void buildMaxHeap(int arr[], int n)
    {
        for (int i=n/2-1; i>=0; i--)
            heapify(arr, n, i);
    }
 
    static void heapify(int arr[], int n, int i)
    {
        int l = 2*i+1;
        int r = 2*i+2;
        int largest = i;
        if (l<n && arr[l]>arr[i])
            largest = l;
        if (r<n && arr[r]>arr[largest])
            largest = r;
            
        if (largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            
            heapify(arr, n, largest);
        }
    }
    
    public static void heapSort(int[] arr, int n) {
    	buildMaxHeap(arr, n);
    	for (int i=n-1; i>=0; i--) {
    		int temp = arr[0];
    		arr[0] = arr[i];
    		arr[i] = temp;
    		
    		heapify(arr, i, 0);
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,9,8,7,6,5,4,3,2,1};
		System.out.println("Before: " + Arrays.toString(arr));
		heapSort(arr, arr.length);
		System.out.println("After: " + Arrays.toString(arr));

	}

}
