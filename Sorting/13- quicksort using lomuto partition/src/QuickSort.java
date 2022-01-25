import java.util.Arrays;
/*
 * Quick Sort
 * implementation of quick sort algorithm using algorithm using lomuto partition
 * Stability: unstable
 * 
 * Worst time complexity: O(n^2)
 * Average time complexity: O(nlogn)
 * Auxiliary space: O(1)
 */
public class QuickSort {

	public static int lomutoPartition(int[] arr, int left, int right) {
		int k = left-1;
		int pivot = arr[right];
		for (int i=left; i<right; i++) {
			if (arr[i]<pivot) {
				k++;
				int temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;
			}
		}
		
		k++;
		int temp = arr[k];
		arr[k] = pivot;
		arr[right] = temp;
//		System.out.println(Arrays.toString(arr));
		
		return k;
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int partitionIndx = lomutoPartition(arr, left, right);
			quickSort(arr, left, partitionIndx-1);
			quickSort(arr, partitionIndx+1, right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {8,4,7,9,3,10,5};
		int left = 0;
		int right = arr.length-1;
		quickSort(arr, left, right);;
		System.out.println(Arrays.toString(arr));

	}

}
