import java.util.Arrays;
/*
 * Lomuto partition (here it works if pivotIndx is the last index of array... but can be tweaked for
 * all every index of pivot by swapping (arr[pivotIndx], arr[arr.length-1])- 
 * Given an array and an index, partition the array based on the index
 * 
 * Idea:
 * variable k (initially indexed to -1) stores the index of end of sub-array where all elements of 
 * sub-array is less than pivot
 * 
 * loop through the array and every time arr[i]<pivot, increment k and swap(arr[k],arr[i])
 * 
 * after coming out of the loop, increment k by one and swap(arr[k],arr[pivotIndx])
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 */
public class Partition {

	public static int lomutoPartition(int[] arr, int pivotIndx) {
		int k = -1; // last index of arr[i]<pivot, which at the end of the loop holds the index of
					// swapped pivot
		int pivot = arr[pivotIndx];
		for (int i=0; i<arr.length; i++) {
			if (arr[i] < pivot) {
				k++;
				// swap
				int temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;
			}
		}
		
		// now that all elements<pivot are placed till k, place pivot at k+1 by swapping
		// arr[++k] with arr[pivotIndx]
		k++;
		int temp = arr[k];
		arr[k] = pivot;
		arr[pivotIndx] = temp;
		
		System.out.println(Arrays.toString(arr));
		
		return k;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 7, 8, 9, 1, 5};
		int pivotIndx = arr.length-1;
		System.out.println("Partition at = " + lomutoPartition(arr, pivotIndx));

	}

}
