import java.util.Arrays;
/*
 * Merge sort implementation
 * 
 * Time complexity: O(nlogn)
 * Auxiliary space: O(n)
 */
public class MergeSortAlgorithm {

	private static void merge(int[] arr, int l, int mid, int r) {
		// TODO Auto-generated method stub
		int[] left = Arrays.copyOfRange(arr, l, mid+1);
		int[] right = Arrays.copyOfRange(arr, mid+1, r+1);
		
		
		int lenL = left.length;
		int lenR = right.length;
		
		int i=0, j=0, k=l;
		
		// merging two sorted arrays
		while(i<lenL && j<lenR) {
			if (left[i] <= right[j])
				arr[k++] = left[i++];
			else
				arr[k++] = right[j++];
		}
		
		// inserts remaining elements
		while (i<lenL)
			arr[k++] = left[i++];
		while (j<lenR)
			arr[k++] = right[j++];
		
	}

	
	public static void mergeSort(int[] arr, int l, int r) {
		if (l<r) {
			int mid = l+(r-l)/2;
			mergeSort(arr, l, mid); // divides left to mid
			mergeSort(arr, mid+1, r); // divides mid to right			
			merge(arr, l, mid, r); // merges left and right
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 12, 11, 13, 5, 6, 7 };
		int l = 0;
		int r = arr.length-1;
		mergeSort(arr, l, r);
		System.out.println(Arrays.toString(arr));

	}

}
