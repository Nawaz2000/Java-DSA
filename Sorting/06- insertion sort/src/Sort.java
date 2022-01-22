import java.util.Arrays;
/*
 * Insertion sort algorithm
 * 
 * Idea:
 * Divide the array into two parts (sorted and unsorted).
 * Traverse from the unsorted array (initially i=0) and for each traversal, loop from
 * j=0 to j<i and if arr[j] > arr[i], then swap
 * 
 * Time complexity: O(n^2)
 * Auxiliary space: O(1)
 */
public class Sort {

	public static int[] insertionSort(int[] arr) {
		int n = arr.length;
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<i; j++) {
				if (arr[j] > arr[i]) {
					// swap
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
			//System.out.println(Arrays.toString(arr));
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {20,5,40,60,10,30};
		int[] res = insertionSort(arr);
		System.out.println(Arrays.toString(res));

	}

}
